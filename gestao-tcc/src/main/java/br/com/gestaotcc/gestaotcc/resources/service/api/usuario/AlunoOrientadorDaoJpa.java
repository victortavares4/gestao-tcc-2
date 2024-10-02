/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.usuario;

import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoOrientadorDaoJpa {

    private ConnectionDB connectionDB;

    public AlunoOrientadorDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public void vincularAlunoOrientador(int idAluno, int idOrientador) throws SQLException {
        String sql = "INSERT INTO aluno_orientador (id_aluno, id_orientador) VALUES (?, ?)";

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idAluno);
            preparedStatement.setInt(2, idOrientador);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao vincular aluno ao orientador.", e);
        }
    }
    
     public Integer getOrientadorIdByAlunoId(int idAluno) throws SQLException {
        String sql = "SELECT id_orientador FROM aluno_orientador WHERE id_aluno = ?";

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idAluno);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id_orientador");
            } else {
                // Nenhum orientador encontrado para o aluno especificado
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao buscar o orientador do aluno.", e);
        }
    }
}