/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.utils;

import br.com.gestaotcc.gestaotcc.resources.service.api.usuario.UsuarioDaoJpa;
import br.com.gestaotcc.gestaotcc.utils.dao.TokenDao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class Token {
    
    
    // Método para validar o token
    public boolean isValidToken(int userId, String token) {
        TokenDao tokenDao = new TokenDao();
        return tokenDao.isValidToken(userId, token);
    }
    
    public boolean isValidToken(String token) {
        TokenDao tokenDao = new TokenDao();
        return tokenDao.isValidToken(token);
    }

    // Método para obter a chave API com base no token
    public String getChaveApiByToken(String token) {
        TokenDao tokenDao = new TokenDao();
        return tokenDao.getChaveApiByToken(token);
    }

    // Método para obter o ID do usuário com base no token
    public int getUserIdByToken(String token) {
        TokenDao tokenDao = new TokenDao();
        return tokenDao.getUserIdByToken(token);
    }
    

    public String generateToken(String login) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDaoJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] hash = digest.digest(login.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
    
    public void storeToken(int userId, String token){
        TokenDao tokenDao = new TokenDao();
        try {
            tokenDao.storeToken(userId, token);
        } catch (SQLException ex) {
            Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String removeBearerPrefix(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            return token.replace("Bearer ", "").trim();
        }
        return token;
    }
}
