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
import java.util.ArrayList;
import java.util.List;

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
        String sql = "INSERT INTO usuario (nome, matricula, senha, tipo) VALUES (?, ?, MD5(?), ?)";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuarioDto.getNome());
            preparedStatement.setString(2, usuarioDto.getMatricula());
            preparedStatement.setString(3, usuarioDto.getSenha());
            preparedStatement.setInt(4, usuarioDto.getTipo());
            preparedStatement.executeUpdate();
        }
    }

    public Object[] authenticate(LoginDto loginDto) throws SQLException {
        String sql = "SELECT id FROM usuario WHERE matricula = ? AND senha = MD5(?)";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, loginDto.getLogin());
            preparedStatement.setString(2, loginDto.getSenha());

            ResultSet resultSet = preparedStatement.executeQuery();
            Object[] retorno = new Object[2];

            if (resultSet.next()) {
                retorno[0] = resultSet.getInt("id");
                retorno[1] = loginDto.getLogin();
                return retorno;
            } else {
                throw new IllegalArgumentException("Login ou senha inválidos");
            }
        }
    }

    public List<Object[]> findAll() throws SQLException {
        String sql = "SELECT \n"
                + "    tipo.descricao as tipo_usuario,\n"
                + "    usuario.matricula,\n"
                + "    usuario.nome\n"
                + "FROM \n"
                + "    usuario\n"
                + "JOIN \n"
                + "    tipo ON usuario.tipo = tipo.id;";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Object[]> retorno = new ArrayList<>();

            while (resultSet.next()) {

                Object[] linha = new Object[3];
                linha[0] = resultSet.getString("tipo_usuario");
                linha[1] = resultSet.getString("matricula");
                linha[2] = resultSet.getString("nome");

                retorno.add(linha);
            }

            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao consultar os dados do usuário.", e);
        }
    }

    public List<Object[]> findAllTipo(String tipo) throws SQLException {
        String sql = "SELECT \n"
                + "    tipo.descricao as tipo_usuario,\n"
                + "    usuario.matricula,\n"
                + "    usuario.nome\n"
                + "FROM \n"
                + "    usuario\n"
                + "JOIN \n"
                + "    tipo ON usuario.tipo = tipo.id\n"
                + " where tipo.descricao = ?;";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            
            preparedStatement.setString(1, tipo);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Object[]> retorno = new ArrayList<>();
            
            while (resultSet.next()) {

                Object[] linha = new Object[3];
                linha[0] = resultSet.getString("tipo_usuario");
                linha[1] = resultSet.getString("matricula");
                linha[2] = resultSet.getString("nome");

                retorno.add(linha);
            }

            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao consultar os dados do usuário.", e);
        }
    }
}
