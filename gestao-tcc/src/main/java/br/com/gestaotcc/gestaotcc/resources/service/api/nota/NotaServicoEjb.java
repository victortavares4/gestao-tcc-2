package br.com.gestaotcc.gestaotcc.resources.service.api.nota;

import java.sql.SQLException;
import java.util.List;

public class NotaServicoEjb {

    private NotaDaoJpa notaDao;
    private CriterioDaoJpa criterioDao;

    public NotaServicoEjb() {
        this.notaDao = new NotaDaoJpa();
        this.criterioDao = new CriterioDaoJpa();
    }

    public void criarCriterio(Criterio criterio) throws SQLException {
        criterioDao.create(criterio);
    }

    public void criarNota(Avaliacao avaliacao) throws SQLException { 
        notaDao.create(avaliacao); 
    }

    public List<Criterio> listarCriterios() throws SQLException {
        return criterioDao.findAll();
    }

    public List<Avaliacao> listarNotasPorAluno(int idAluno) throws SQLException { 
        return notaDao.findByAluno(idAluno); 
    }
}
