/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nicolas
 */
public class BancaDaoJpa {
//    private ConnectionDB connectionDB;
//
//    public BancaDaoJpa() {
//        this.connectionDB = new ConnectionDB();
//    }
//
//    // Função para criar a banca
//    public int criarBanca(int idCoordenador) throws SQLException {
//        
//        String sql = "INSERT INTO banca (id_coordenador) VALUES (?)";
//        try (Connection connection = connectionDB.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//            preparedStatement.setInt(1, idCoordenador);
//            preparedStatement.executeUpdate();
//
//            // Obter o ID gerado da banca
//            ResultSet rs = preparedStatement.getGeneratedKeys();
//            if (rs.next()) {
//                return rs.getInt(1);  // Retorna o ID da banca recém-criada
//            }
//        }
//        return -1;  // Retorna -1 se a criação falhar
//    }
}
