/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.usuario;

import br.com.gestaotcc.gestaotcc.utils.Token;
import java.sql.SQLException;
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

    public String authenticate(LoginDto loginDto) {
        try {
            UsuarioDaoJpa dao = new UsuarioDaoJpa();
            Object[] retorno = dao.authenticate(loginDto);
            
            Token t = new Token();
            String token = t.generateToken(retorno[1].toString());
            t.storeToken((int) retorno[0], token);
            return token;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicoEjb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean verificarToken(String token) {
        Token t = new Token();
        return t.isValidToken(t.removeBearerPrefix(token));
    }

}
