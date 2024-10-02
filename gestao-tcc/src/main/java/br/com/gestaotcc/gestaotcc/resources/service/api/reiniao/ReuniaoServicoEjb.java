/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.reiniao;

import br.com.gestaotcc.gestaotcc.resources.service.api.arquivo.ArquivoConversorFactory;
import br.com.gestaotcc.gestaotcc.resources.service.api.arquivo.ArquivoDto;
import br.com.gestaotcc.gestaotcc.utils.Mapper;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class ReuniaoServicoEjb {

    void create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    List<ReuniaoDto> findByIdProjeto(Integer idProjeto) throws Exception {

        ReuniaoDaoJpa dao = new ReuniaoDaoJpa();
        ReuniaoConversorFactory reuniaoConversorFactory = new ReuniaoConversorFactory();

        Mapper map = new Mapper();

        List<ReuniaoDto> retorno = map.
                comFunction(reuniaoConversorFactory.criarConversorDto(),
                dao.findByIdProjeto(idProjeto));

        return retorno;

    }

    ArquivoDto findByIdArquivo(Integer idArquivo) throws Exception {
        
        ReuniaoDaoJpa dao = new ReuniaoDaoJpa();
        ArquivoConversorFactory arquivoConversorFactory = new ArquivoConversorFactory();

        Mapper map = new Mapper();

        ArquivoDto retorno = map.
                comFunction(arquivoConversorFactory.criarConversorDto(),
                dao.findByIdArquivo(idArquivo));
        
        return retorno;
    }

}
