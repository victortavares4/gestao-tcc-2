/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.usuario;

import br.com.gestaotcc.gestaotcc.resources.service.api.usuario.login.LoginRetornoFrontDto;
import java.util.function.Function;
/**
 *
 * @author Nicolas
 */
import lombok.Builder;

@Builder
public class UsuarioConversorFactory {

    public static Function<Object[], UsuarioDtoConsultaFront> criarConversorDtoUsuarrio() {
    return (source) -> UsuarioDtoConsultaFront.builder()
            .tipo_descricao((String) source[0])
            .matricula((String) source[1])
            .nome((String) source[2])
            .imagem((String) source[3])
            .build();
}

    public static Function<Object[], LoginRetornoFrontDto> criarConversorDtoUsuarrioAuthenticate() {
    return (source) -> LoginRetornoFrontDto.builder()
            .userID((Integer) source[0])
            .matricula((String) source[1])
            .nome((String) source[2])
            .userType((String) source[3])
            .build();
    }

}
