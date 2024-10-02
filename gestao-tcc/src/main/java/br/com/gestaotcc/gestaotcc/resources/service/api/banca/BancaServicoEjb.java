/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import br.com.gestaotcc.gestaotcc.utils.Mapper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class BancaServicoEjb {
    public void create(BancaCommand bancaCommand) throws SQLException {
        BancaDaoJpa dao = new BancaDaoJpa();
            dao.create(bancaCommand);        
    }

   

    List<BancaRetonoFrontDto> findByIdProjeto(Integer idProjeto) throws Exception {
        
        BancaDaoJpa dao = new BancaDaoJpa();
            
       BancaConversorFactory fac = new BancaConversorFactory();
       Mapper map = new Mapper();

        List<BancaRetonoFrontDto> retorno = map.
                comFunction(fac.criarConversorDto(),
                 dao.findByIdProjeto(idProjeto));
        
        return retorno;
    }
}
