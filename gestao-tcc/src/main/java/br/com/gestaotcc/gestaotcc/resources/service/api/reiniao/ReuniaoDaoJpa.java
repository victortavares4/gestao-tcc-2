/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.reiniao;

import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class ReuniaoDaoJpa {

    private ConnectionDB connectionDB;

    public ReuniaoDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    List<Object[]> findByIdProjeto(Integer idProjeto) throws Exception {
        String sql = "SELECT \n"
                + "    r.id_reuniao,\n"
                + "    r.id_projeto,\n"
                + "    r.data_hora,\n"
                + "    r.descricao,\n"
                + "    ra.id_arquivo\n"
                + "FROM \n"
                + "    reuniao r\n"
                + "left JOIN \n"
                + "    reuniao_arquivo ra ON r.id_reuniao = ra.id_reuniao\n"
                + "WHERE \n"
                + "    r.id_projeto = ?\n"
                + "ORDER BY \n"
                + "    r.data_hora ASC;";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idProjeto);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Object[]> retorno = new ArrayList<>();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            while (resultSet.next()) {

                Object[] linha = new Object[5];
                linha[0] = resultSet.getInt("id_reuniao");
                linha[1] = resultSet.getInt("id_projeto");

                linha[2] = resultSet.getTimestamp("data_hora");
                linha[3] = resultSet.getString("descricao");
                linha[4] = resultSet.getInt("id_arquivo");

                retorno.add(linha);
            }

            return retorno;
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    Object[] findByIdArquivo(Integer idArquivo) throws Exception {
        String sql = "SELECT id_arquivo, arquivo, data_envio, id_documento\n"
                + "FROM arquivo\n"
                + "WHERE id_arquivo = ?";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idArquivo);

            ResultSet resultSet = preparedStatement.executeQuery();

            Object[] linha = new Object[4];
            linha[0] = resultSet.getInt("id_arquivo");
            linha[1] = resultSet.getInt("arquivo");
            linha[2] = resultSet.getTimestamp("data_envio");
            linha[3] = resultSet.getInt("id_documento");

            return linha;
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

}
