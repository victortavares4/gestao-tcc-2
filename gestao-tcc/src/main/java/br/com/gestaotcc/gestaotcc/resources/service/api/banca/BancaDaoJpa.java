/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;
import jakarta.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class BancaDaoJpa {

    private ConnectionDB connectionDB;

    public BancaDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    @Transactional
    public void create(BancaCommand bancaCommand) throws SQLException {
        String sql = "INSERT INTO banca (id_coordenador) VALUES (?)";
        String retornoSql = "SELECT LAST_INSERT_ID()";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, bancaCommand.getId_coordenador());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try ( PreparedStatement lastInsertIdStatement = connection.prepareStatement(retornoSql);  ResultSet rs = lastInsertIdStatement.executeQuery()) {
                    if (rs.next()) {
                        bancaCommand.getId_professor().forEach(idProfessor -> {
                            String sqlProfessor = "INSERT INTO banca_professor (id_banca, id_professor) VALUES (?, ?)";
                            try ( PreparedStatement preparedStatementProfessor = connection.prepareStatement(sqlProfessor)) {

                                preparedStatementProfessor.setInt(1, rs.getInt(1));
                                preparedStatementProfessor.setInt(2, idProfessor);
                                preparedStatementProfessor.executeUpdate();

                            } catch (SQLException ex) {
                                System.out.println("Erro ao inserir professor na banca: " + ex.getMessage());
                            }
                        });
                    }
                }
            }
        }

    }

    List<Object[]> findByIdProjeto(Integer idProjeto) throws Exception {
        String sql = "SELECT \n"
                + "    p.id_projeto,\n"
                + "    p.nome AS nome_projeto,\n"
                + "    b.id_banca,\n"
                + "    bp.id_professor,\n"
                + "    u.nome AS nome_professor\n"
                + "FROM \n"
                + "    projeto p\n"
                + "JOIN \n"
                + "    banca_professor_projeto bpp ON p.id_projeto = bpp.id_projeto\n"
                + "JOIN \n"
                + "    banca_professor bp ON bp.id_banca_professor = bpp.id_banca_professor\n"
                + "JOIN \n"
                + "    banca b ON bp.id_banca = b.id_banca\n"
                + "JOIN \n"
                + "    usuario u ON bp.id_professor = u.id\n"
                + "WHERE \n"
                + "    p.id_projeto = ?";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idProjeto);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Object[]> retorno = new ArrayList<>();

            while (resultSet.next()) {

                Object[] linha = new Object[5];
                linha[0] = resultSet.getInt("id_projeto");
                linha[1] = resultSet.getString("nome_projeto");
                linha[2] = resultSet.getInt("id_banca");
                linha[3] = resultSet.getInt("id_professor");
                linha[4] = resultSet.getString("nome_professor");

                retorno.add(linha);
            }

            return retorno;

        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
}
