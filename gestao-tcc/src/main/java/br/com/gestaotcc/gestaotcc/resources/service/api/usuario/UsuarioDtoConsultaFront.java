/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.usuario;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Nicolas
 */
@Data
@Builder
public class UsuarioDtoConsultaFront {
    
    private String nome;
    private String matricula;
    private String tipo_descricao;
    private int userID;
    private String imagem;
}
