/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;


/**
 *
 * @author Nicolas
 */
public class BancaDaoJpa {
    private ConnectionDB connectionDB;

    public void create(BancaDto bancaDto) throws SQLException {
        String sql = "INSERT INTO banca (id_coordenador) VALUES (?)";

        try ( Connection connection = connectionDB.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, bancaDto.getIdCoordenador());
            preparedStatement.executeUpdate();
        }
    }
}
