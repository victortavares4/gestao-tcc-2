package br.com.gestaotcc.gestaotcc.resources.service.api.documento;

import java.sql.SQLException;

public class DocumentoServicoEjb {

    private DocumentoDaoJpa documentoDao = new DocumentoDaoJpa();

    public void avaliarDocumento(int idDocumento, double notaProposta) throws SQLException {
        int tipoDocumentoAvaliacao = 3;
        
        documentoDao.atualizarTipoDocumento(idDocumento, tipoDocumentoAvaliacao);

        documentoDao.atualizarNotaDocumento(idDocumento, notaProposta);
    }

    public void rejeitarDocumento(int idDocumento) throws SQLException {
        documentoDao.rejeitarDocumento(idDocumento);
    }
}
