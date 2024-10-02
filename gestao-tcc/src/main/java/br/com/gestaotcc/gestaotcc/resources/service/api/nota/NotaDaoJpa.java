package br.com.gestaotcc.gestaotcc.resources.service.api.nota;

import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotaDaoJpa {

    private ConnectionDB connectionDB;

    public NotaDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public void create(Avaliacao avaliacao) throws SQLException { 
        String sql = "INSERT INTO avaliacao (id_banca_professor, id_projeto, id_criterio, nota) VALUES (?, ?, ?, ?)";

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, avaliacao.getIdBancaProfessor()); 
            preparedStatement.setInt(2, avaliacao.getIdProjeto()); 
            preparedStatement.setInt(3, avaliacao.getIdCriterio());
            preparedStatement.setFloat(4, avaliacao.getNota()); 
            preparedStatement.executeUpdate();
        }
    }

    public List<Avaliacao> findByAluno(int idAluno) throws SQLException { 
        String sql = "SELECT id_avaliacao, id_banca_professor, id_projeto, id_criterio, nota FROM avaliacao WHERE id_banca_professor = ?"; // Supondo que o ID do aluno está relacionado ao id_banca_professor
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idAluno);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Avaliacao> avaliacoes = new ArrayList<>();

            while (resultSet.next()) {
                Avaliacao avaliacao = new Avaliacao(); 
                avaliacao.setIdAvaliacao(resultSet.getInt("id_avaliacao"));
                avaliacao.setIdBancaProfessor(resultSet.getInt("id_banca_professor")); 
                avaliacao.setIdProjeto(resultSet.getInt("id_projeto")); 
                avaliacao.setIdCriterio(resultSet.getInt("id_criterio"));
                avaliacao.setNota(resultSet.getFloat("nota")); 

                avaliacoes.add(avaliacao);
            }
            return avaliacoes;
        }
    }
}
