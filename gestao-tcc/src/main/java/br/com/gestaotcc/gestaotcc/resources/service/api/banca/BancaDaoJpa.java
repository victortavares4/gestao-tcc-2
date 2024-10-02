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
}
