package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class ProjetoDaoJpa {

    private ConnectionDB connectionDB;

    public ProjetoDaoJpa() {
        this.connectionDB = new ConnectionDB();
    }

    public void create(ProjetoDto projetoDto) throws SQLException {
        String sql = "INSERT INTO projeto (id_aluno, id_orientador, nome, descricao, data_inicio) VALUES (?, ?, ?, ?, ?, now())";

        try (Connection connection = connectionDB.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, projetoDto.getId_aluno());
            preparedStatement.setInt(2, projetoDto.getId_orientador());
            preparedStatement.setString(3, projetoDto.getNome());
            preparedStatement.setString(4, projetoDto.getDescricao());
            preparedStatement.setDate(5, new java.sql.Date(projetoDto.getData_inicio().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(projetoDto.getData_fim().getTime()));
            preparedStatement.executeUpdate();
        }
    }
    
    public List<ProjetoDto> getAll() throws SQLException {
    List<ProjetoDto> projetos = new ArrayList<>();
    String sql = "SELECT p.id_projeto, p.nome AS projeto_nome, p.descricao, "
               + "p.id_aluno, p.id_orientador, "
               + "a.nome AS aluno_nome, o.nome AS orientador_nome "
               + "FROM projeto p "
               + "JOIN usuario a ON p.id_aluno = a.id "
               + "JOIN usuario o ON p.id_orientador = o.id";

    try (Connection connection = connectionDB.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
            ProjetoDto projetoDto = ProjetoDto.builder()
                    .id_projeto(resultSet.getInt("id_projeto"))
                    .id_aluno(resultSet.getInt("id_aluno")) 
                    .id_orientador(resultSet.getInt("id_orientador")) 
                    .nome(resultSet.getString("projeto_nome"))
                    .descricao(resultSet.getString("descricao"))
                    .alunoNome(resultSet.getString("aluno_nome"))
                    .orientadorNome(resultSet.getString("orientador_nome"))
                    .build();
            projetos.add(projetoDto);
        }
    }

    return projetos;
}

}
