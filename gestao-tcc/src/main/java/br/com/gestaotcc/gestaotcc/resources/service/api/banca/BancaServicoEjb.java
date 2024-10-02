/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import br.com.gestaotcc.gestaotcc.resources.service.api.usuario.UsuarioDaoJpa;

/**
 *
 * @author Nicolas
 */
public class BancaServicoEjb {
    private void create(BancaCommand bancaCommand) {
        BancaDaoJpa dao = new BancaDaoJpa();
            dao.create(bancaCommand);        
    }
}
