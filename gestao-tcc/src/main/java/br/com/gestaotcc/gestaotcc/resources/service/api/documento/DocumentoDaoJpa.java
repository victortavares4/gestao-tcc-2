package br.com.gestaotcc.gestaotcc.resources.service.api.documento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;

public class DocumentoDaoJpa {

    private ConnectionDB connectionDB;

    public DocumentoDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public void atualizarNotaDocumento(int idDocumento, double notaProposta) throws SQLException {
        String sql = "UPDATE documento SET nota_proposta = ? WHERE id_documento = ?";

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1, notaProposta);
            preparedStatement.setInt(2, idDocumento);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("Nenhum documento encontrado com o id " + idDocumento);
            }
        }
    }

    public void atualizarTipoDocumento(int idDocumento, int tipoDocumento) throws SQLException {
        String sql = "UPDATE documento SET tipo_documento = ? WHERE id_documento = ?";

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, tipoDocumento);
            preparedStatement.setInt(2, idDocumento);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("Nenhum documento encontrado com o id " + idDocumento);
            }
        }
    }

    public void rejeitarDocumento(int idDocumento) throws SQLException {
        atualizarTipoDocumento(idDocumento, 2);
    }
}
