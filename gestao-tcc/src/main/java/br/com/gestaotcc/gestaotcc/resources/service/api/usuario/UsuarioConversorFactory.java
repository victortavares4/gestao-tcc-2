/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.usuario;

import java.util.function.Function;

/**
 *
 * @author Nicolas
 */
public class UsuarioConversorFactory {

    public static Function<Object[], UsuarioDtoConsultaFront> criarConversorDtoUsuarrio() {

        return (source) -> UsuarioDtoConsultaFront.builder()
                .tipo_descricao((String) source[0])
                .matricula((String) source[1])
                .nome((String) source[2])
                .build();
    }
    

}
