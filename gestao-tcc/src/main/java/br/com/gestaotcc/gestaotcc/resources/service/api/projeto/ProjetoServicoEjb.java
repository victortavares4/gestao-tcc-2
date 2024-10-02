package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import br.com.gestaotcc.gestaotcc.resources.service.api.documento.DocumentoDto;
import br.com.gestaotcc.gestaotcc.utils.Mapper;
import java.sql.SQLException;
import java.util.List;

public class ProjetoServicoEjb {

    private ProjetoDaoJpa projectDao;

    public ProjetoServicoEjb() {
        this.projectDao = new ProjetoDaoJpa();
    }
    
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
    
    public List<TipoDto> findAllTipos() throws SQLException {
        try {
            List<Object[]> resultados = projectDao.findAllTipos();
            TipoConversorFactory conversorFactory = new TipoConversorFactory();
            Mapper mapper = new Mapper();

            return mapper.comFunction(conversorFactory.criarConversorTipo(), resultados);
        } catch (SQLException e) {
            throw e;
        }
    }
}
