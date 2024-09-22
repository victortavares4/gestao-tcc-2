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

/**
 *
 * @author Nicolas
 */
public class UsuarioDaoJpa {

    private ConnectionDB connectionDB;

    public UsuarioDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public void create(UsuarioDto usuarioDto) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, login, senha) VALUES (?, ?, MD5(?), ?)";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuarioDto.getNome());
            preparedStatement.setString(2, usuarioDto.getLogin());
            preparedStatement.setString(3, usuarioDto.getSenha());
            preparedStatement.executeUpdate();
        }
    }

    public Object[] authenticate(LoginDto loginDto) throws SQLException {
        String sql = "SELECT id_usuario FROM usuarios WHERE login = ? AND senha = MD5(?)";
        
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, loginDto.getLogin());
            preparedStatement.setString(2, loginDto.getSenha());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            Object[] retorno = new Object[2];
            
            if (resultSet.next()) {
                retorno[0] = resultSet.getInt("id_usuario");
                retorno[1] = loginDto.getLogin();
                return retorno;
            } else {
                throw new IllegalArgumentException("Login ou senha inválidos");
            }
        }
    }
    
    
}
