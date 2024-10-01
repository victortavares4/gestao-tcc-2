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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class UsuarioServicoEjb {

    public void create(UsuarioDto usuarioDto) throws Exception {
        try {
            UsuarioDaoJpa dao = new UsuarioDaoJpa();
            dao.create(usuarioDto);
        } catch (Exception e) {
            throw e;
        }
    }

    public LoginRetornoFrontDto authenticate(LoginDto loginDto) {
        try {
            UsuarioDaoJpa dao = new UsuarioDaoJpa();
            UsuarioConversorFactory usuarioFactory = new UsuarioConversorFactory();
            Mapper map = new Mapper();
            
            LoginRetornoFrontDto retorno =  map.
                    comFunction(usuarioFactory.criarConversorDtoUsuarrioAuthenticate(),
                            dao.authenticate(loginDto));

            Token t = new Token();
            String token = t.generateToken(retorno.getLogin());
            t.storeToken(retorno.getId(), token);

            retorno.setToken(token);

            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicoEjb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
