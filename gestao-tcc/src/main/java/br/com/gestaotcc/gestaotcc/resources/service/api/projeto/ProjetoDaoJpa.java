package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import br.com.gestaotcc.gestaotcc.resources.service.api.documento.DocumentoDto;
import br.com.gestaotcc.gestaotcc.utils.ConnectionDB;
import java.math.BigDecimal;
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

    public void create(ProjetoDto projetoDto, DocumentoDto documentoDto) throws SQLException {
        String sqlProjeto = "INSERT INTO projeto (id_aluno, id_orientador, nome, descricao, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlDocumento = "INSERT INTO documento (tipo_documento, id_projeto, data_envio) VALUES (?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatementProjeto = null;
        PreparedStatement preparedStatementDocumento = null;
        ResultSet generatedKeys = null;

        try {
            connection = connectionDB.getConnection();
            connection.setAutoCommit(false);

            preparedStatementProjeto = connection.prepareStatement(sqlProjeto, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatementProjeto.setInt(1, projetoDto.getId_aluno());
            preparedStatementProjeto.setInt(2, projetoDto.getId_orientador());
            preparedStatementProjeto.setString(3, projetoDto.getNome());
            preparedStatementProjeto.setString(4, projetoDto.getDescricao());
            preparedStatementProjeto.setDate(5, new java.sql.Date(projetoDto.getData_inicio().getTime()));
            preparedStatementProjeto.setDate(6, new java.sql.Date(projetoDto.getData_fim().getTime()));
            preparedStatementProjeto.executeUpdate();

            generatedKeys = preparedStatementProjeto.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idProjeto = generatedKeys.getInt(1);

                preparedStatementDocumento = connection.prepareStatement(sqlDocumento);
                preparedStatementDocumento.setInt(1, documentoDto.getTipo_documento());
                preparedStatementDocumento.setInt(2, idProjeto);
                preparedStatementDocumento.setDate(3, new java.sql.Date(documentoDto.getData_envio().getTime()));
                preparedStatementDocumento.executeUpdate();
            }

            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw e;
        } finally {
            if (generatedKeys != null) {
                generatedKeys.close();
            }
            if (preparedStatementProjeto != null) {
                preparedStatementProjeto.close();
            }
            if (preparedStatementDocumento != null) {
                preparedStatementDocumento.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<ProjetoDto> getAll() throws SQLException {
        List<ProjetoDto> projetos = new ArrayList<>();

        String sql = "SELECT p.id_projeto, p.nome AS projeto_nome, p.descricao, "
                + "p.id_aluno, p.id_orientador, "
                + "a.nome AS aluno_nome, o.nome AS orientador_nome, "
                + "d.id_documento, d.tipo_documento "
                + "td.prazo_final "
                + "FROM projeto p "
                + "JOIN usuario a ON p.id_aluno = a.id "
                + "JOIN usuario o ON p.id_orientador = o.id "
                + "LEFT JOIN documento d ON p.id_projeto = d.id_projeto "
                + "LEFT JOIN tipo_documento td ON d.tipo_documento = td.id_tipo_documento";

        try (Connection connection = connectionDB.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                ProjetoDto projetoDto = ProjetoDto.builder()
                        .id_projeto(resultSet.getInt("id_projeto"))
                        .id_aluno(resultSet.getInt("id_aluno"))
                        .id_orientador(resultSet.getInt("id_orientador"))
                        .nome(resultSet.getString("projeto_nome"))
                        .descricao(resultSet.getString("descricao"))
                        .alunoNome(resultSet.getString("aluno_nome"))
                        .orientadorNome(resultSet.getString("orientador_nome"))
                        .id_documento(resultSet.getInt("id_documento"))
                        .tipo_documento(resultSet.getInt("tipo_documento"))
                        .build();
                projetos.add(projetoDto);
            }
        }

        return projetos;
    }
    
    public void atribuirNota(Long idProjeto, BigDecimal notaProposta, BigDecimal notaTcc) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = connectionDB.getConnection();

            String sql = "UPDATE documento SET nota_proposta = ?, nota_tcc = ? WHERE id_projeto = ?";
            statement = connection.prepareStatement(sql);

            statement.setBigDecimal(1, notaProposta);
            statement.setBigDecimal(2, notaTcc);
            statement.setLong(3, idProjeto);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new IllegalArgumentException("Projeto não encontrado para o ID: " + idProjeto);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao atribuir notas: " + e.getMessage(), e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    public void atualizarNotas(Long idProjeto, BigDecimal notaProposta, BigDecimal notaTcc) throws SQLException {
        String sql = "UPDATE projeto SET nota_proposta = ?, nota_tcc = ? WHERE id_projeto = ?";

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setBigDecimal(1, notaProposta);
            preparedStatement.setBigDecimal(2, notaTcc);
            preparedStatement.setLong(3, idProjeto);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("Nenhum projeto encontrado com o id " + idProjeto);
            }
        }
    }
    
    public List<ProjetoDto> getProjetosByAlunoId(int idAluno) throws SQLException {
        String sql = "SELECT * FROM projeto WHERE id_aluno = ?";

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idAluno);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<ProjetoDto> projetos = new ArrayList<>();

            while (resultSet.next()) {
                ProjetoDto projeto = new ProjetoDto();
                projeto.setId_projeto(resultSet.getInt("id_projeto"));
                projeto.setId_aluno(resultSet.getInt("id_aluno"));
                projeto.setId_orientador(resultSet.getInt("id_orientador"));
                projeto.setNome(resultSet.getString("nome"));
                projeto.setDescricao(resultSet.getString("descricao"));
                projeto.setData_inicio(resultSet.getDate("data_inicio"));
                projeto.setData_fim(resultSet.getDate("data_fim"));

                projetos.add(projeto);
            }

            return projetos;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao consultar projetos do aluno.", e);
        }
    }
    
    public List<Object[]> findAllTipos() throws SQLException {
        String sql = "SELECT id, descricao FROM tipo;";

        try (Connection connection = connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Object[]> tipos = new ArrayList<>();

            while (resultSet.next()) {
                Object[] tipo = new Object[2];
                tipo[0] = resultSet.getInt("id");
                tipo[1] = resultSet.getString("descricao");
                tipos.add(tipo);
            }

            return tipos;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao consultar os tipos de usuário.", e);
        }
    }


}
