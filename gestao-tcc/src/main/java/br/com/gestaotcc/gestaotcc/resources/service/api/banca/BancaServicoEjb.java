/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import java.sql.SQLException;

/**
 *
 * @author Nicolas
 */
public class BancaServicoEjb {
    public void create(BancaCommand bancaCommand) throws SQLException {
        BancaDaoJpa dao = new BancaDaoJpa();
            dao.create(bancaCommand);        
    }
}
