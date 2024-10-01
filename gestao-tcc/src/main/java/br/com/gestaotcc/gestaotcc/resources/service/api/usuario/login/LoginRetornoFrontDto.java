/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.usuario.login;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Nicolas
 */
@Data
@Builder
public class LoginRetornoFrontDto {
    private int id;
    private String login;
    private String nome;
    private String tipoUsuario;
    private int idOrientador;
    private String nomeOrientador;
    private String Token;
}
