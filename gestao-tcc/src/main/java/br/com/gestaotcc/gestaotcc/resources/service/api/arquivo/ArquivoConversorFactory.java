/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.arquivo;

import java.util.function.Function;

/**
 *
 * @author Nicolas
 */
public class ArquivoConversorFactory {
    public static Function<Object[], ArquivoDto> criarConversorDto() {
         
        return (source) -> ArquivoDto.builder()
                .idArquivo((Integer) source[0])
                .build();
    }
}
