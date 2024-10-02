package br.com.gestaotcc.gestaotcc.resources.service.api.nota;

import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CriterioDaoJpa {

    private ConnectionDB connectionDB;

    public CriterioDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public void create(Criterio criterio) throws SQLException {
        String sql = "INSERT INTO criterios (nome, descricao_criterio, peso_maximo) VALUES (?, ?, ?)";

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, criterio.getNome());
            preparedStatement.setString(2, criterio.getDescricaoCriterio());
            preparedStatement.setFloat(3, criterio.getPesoMaximo());
            preparedStatement.executeUpdate();
        }
    }

    public List<Criterio> findAll() throws SQLException {
        String sql = "SELECT id_criterio, nome, descricao_criterio, peso_maximo FROM criterios";
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Criterio> criterios = new ArrayList<>();

            while (resultSet.next()) {
                Criterio criterio = new Criterio();
                criterio.setIdCriterio(resultSet.getInt("id_criterio"));
                criterio.setNome(resultSet.getString("nome"));
                criterio.setDescricaoCriterio(resultSet.getString("descricao_criterio"));
                criterio.setPesoMaximo(resultSet.getFloat("peso_maximo"));

                criterios.add(criterio);
            }
            return criterios;
        }
    }
}
