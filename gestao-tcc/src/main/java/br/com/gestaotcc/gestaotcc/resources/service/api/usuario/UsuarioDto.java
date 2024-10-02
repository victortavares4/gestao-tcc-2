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
class UsuarioDto {
    
    private Integer id;
    private String nome;
    private String matricula;
    private Integer tipo;
    private String tipo_descricao;
    private String senha; 
    private String imagem;
}
