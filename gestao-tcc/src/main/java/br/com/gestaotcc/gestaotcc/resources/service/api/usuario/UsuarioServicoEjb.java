/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.usuario;

import br.com.gestaotcc.gestaotcc.resources.service.api.usuario.login.LoginDto;
import br.com.gestaotcc.gestaotcc.resources.service.api.usuario.login.LoginRetornoFrontDto;
import br.com.gestaotcc.gestaotcc.utils.Mapper;
import br.com.gestaotcc.gestaotcc.utils.Token;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class UsuarioServicoEjb {
    
    private UsuarioDaoJpa usuarioDao;

    public UsuarioServicoEjb() {
        this.usuarioDao = new UsuarioDaoJpa();
    }

    public void create(UsuarioDto usuarioDto) throws Exception {
        try {
            if (usuarioDto.getImagem() != null && usuarioDto.getImagem().startsWith("data:image")) {
                String base64Image = usuarioDto.getImagem().substring(usuarioDto.getImagem().indexOf(",") + 1);
                usuarioDto.setImagem(base64Image);
            }
            
            usuarioDao.create(usuarioDto);
        } catch (Exception e) {
            throw e;
        }
    }

    public LoginRetornoFrontDto authenticate(LoginDto loginDto) {
        try {
            UsuarioDaoJpa dao = new UsuarioDaoJpa();
            Object[] retorno = dao.authenticate(loginDto);

            Token t = new Token();
            String token = t.generateToken(retorno[1].toString());
            t.storeToken((int) retorno[0], token);

            // Map Object[] to LoginRetornoFrontDto
            Function<Object[], LoginRetornoFrontDto> converter = UsuarioConversorFactory.criarConversorDtoUsuarrioAuthenticate();
            LoginRetornoFrontDto loginRetorno = converter.apply(retorno);
            loginRetorno.setToken(token);

            return loginRetorno;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicoEjb.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao autenticar o usuário.", ex);
        }
    }

    public void vincularAlunoOrientador(int idAluno, String matriculaOrientador) throws Exception {
        try {
            // Verificar se o usuário é um aluno
            if (!usuarioDao.isAluno(idAluno)) {
                throw new Exception("O usuário com ID " + idAluno + " não é um aluno válido.");
            }

            // Buscar o ID do orientador pela matrícula
            Integer idOrientador = usuarioDao.findOrientadorIdByMatricula(matriculaOrientador);

            if (idOrientador == null) {
                throw new Exception("Orientador com matrícula " + matriculaOrientador + " não encontrado.");
            }

            // Realizar a vinculação
            AlunoOrientadorDaoJpa dao = new AlunoOrientadorDaoJpa();
            dao.vincularAlunoOrientador(idAluno, idOrientador);
        } catch (SQLException e) {
            throw new Exception("Erro ao vincular aluno ao orientador.", e);
        }
    }
    
    public Integer getOrientadorIdByAlunoId(int idAluno) throws Exception {
        try {
            UsuarioDaoJpa usuarioDao = new UsuarioDaoJpa();
            if (!usuarioDao.isAluno(idAluno)) {
                throw new Exception("O usuário com ID " + idAluno + " não é um aluno válido.");
            }

            AlunoOrientadorDaoJpa dao = new AlunoOrientadorDaoJpa();
            return dao.getOrientadorIdByAlunoId(idAluno);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar o orientador do aluno.", e);
        }
    }
    public boolean verificarToken(String token) {
        Token t = new Token();
        return t.isValidToken(t.removeBearerPrefix(token));
    }

    public List<UsuarioDtoConsultaFront> findAll() throws SQLException {
        UsuarioDaoJpa dao = new UsuarioDaoJpa();
        UsuarioConversorFactory usuarioFactory = new UsuarioConversorFactory();
        Mapper map = new Mapper();

        List<UsuarioDtoConsultaFront> teste = map.comFunction(usuarioFactory.criarConversorDtoUsuarrio(), dao.findAll());

        return teste;
    }

    public List<UsuarioDtoConsultaFront> findAllTipo(String tipo) throws SQLException {
        UsuarioDaoJpa dao = new UsuarioDaoJpa();
        UsuarioConversorFactory usuarioFactory = new UsuarioConversorFactory();
        Mapper map = new Mapper();

        List<UsuarioDtoConsultaFront> teste = map.
                comFunction(usuarioFactory.criarConversorDtoUsuarrio(),
                        dao.findAllTipo(tipo));

        return teste;
    }

}
