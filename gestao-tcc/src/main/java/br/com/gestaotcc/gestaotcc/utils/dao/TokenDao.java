/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.utils.dao;

import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author Nicolas
 */
public class TokenDao {

    private ConnectionDB connectionDB;

    public TokenDao() {
        this.connectionDB = new ConnectionDB();
    }

    // Método para validar o token
    public boolean isValidToken(int userId, String token) {

        deleteExpiredTokens();

        String sql = "SELECT data_validade FROM user_token WHERE id_usuario = ? AND token = ?";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, token);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Timestamp dataValidade = resultSet.getTimestamp("data_validade");
                return dataValidade != null && dataValidade.after(new Timestamp(System.currentTimeMillis()));
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isValidToken(String token) {

        deleteExpiredTokens();

        String sql = "SELECT data_validade FROM user_token WHERE token = ?";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, token);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Timestamp dataValidade = resultSet.getTimestamp("data_validade");
                return dataValidade != null && dataValidade.after(new Timestamp(System.currentTimeMillis()));
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obter o ID do usuário com base no token
    public int getUserIdByToken(String token) {
        String sql = "SELECT id_usuario FROM user_token WHERE token = ?";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, token);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id_usuario");
            } else {
                return -1; // Retorna -1 se o token não for encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void deleteExpiredTokens() {
        String sql = "DELETE FROM user_token WHERE data_validade < CURRENT_TIMESTAMP";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getChaveApiByToken(String token) {
        String sql = "SELECT u.chave_api FROM user_token ut "
                + "JOIN usuarios u ON ut.id_usuario = u.id_usuario "
                + "WHERE ut.token = ?";
       
        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, token);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("chave_api");
            } else {
                return null; // Retorna null se o token não for encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void storeToken(int userId, String token) throws SQLException {
        String sql = "INSERT INTO user_token (id_usuario, token, data_validade) VALUES (?, ?, ?)"
                + "ON DUPLICATE KEY UPDATE token = VALUES(token), data_validade = VALUES(data_validade)";
        
        LocalDateTime validade = LocalDateTime.now().plusDays(2); // Token válido por 7 dias
        Timestamp validadeTimestamp = Timestamp.valueOf(validade);

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, token);
            preparedStatement.setTimestamp(3, validadeTimestamp);
            
            preparedStatement.executeUpdate();
        }
    }
}
