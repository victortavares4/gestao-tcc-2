package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import java.util.List;

public class ProjetoServicoEjb {

    public void create(ProjetoDto projetoDto) throws Exception {
        try {
            ProjetoDaoJpa dao = new ProjetoDaoJpa(); 
            dao.create(projetoDto);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<ProjetoDto> getAll() throws Exception {
        try {
            ProjetoDaoJpa dao = new ProjetoDaoJpa();
            return dao.getAll();
        } catch (Exception e) {
            throw e;
        }
    }
}
