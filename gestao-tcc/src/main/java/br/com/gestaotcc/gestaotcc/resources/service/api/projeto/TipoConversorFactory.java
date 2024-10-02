/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import java.util.function.Function;

/**
 *
 * @author LarissaJoanaHelfer
 */
public class TipoConversorFactory {
    public Function<Object[], TipoDto> criarConversorTipo() {
        return (source) -> TipoDto.builder()
                .id((Integer) source[0])
                .descricao((String) source[1])
                .build();
    }
}
