package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import br.com.gestaotcc.gestaotcc.resources.service.api.documento.DocumentoDto;
import java.sql.SQLException;
import java.util.List;

public class ProjetoServicoEjb {

    public void create(ProjetoDto projetoDto, DocumentoDto documentoDto) throws Exception {
        try {
            ProjetoDaoJpa dao = new ProjetoDaoJpa();
            dao.create(projetoDto, documentoDto);
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
    
    public List<ProjetoDto> getProjetosByAlunoId(int idAluno) throws SQLException {
        ProjetoDaoJpa dao = new ProjetoDaoJpa();
        return dao.getProjetosByAlunoId(idAluno);
    }
}
