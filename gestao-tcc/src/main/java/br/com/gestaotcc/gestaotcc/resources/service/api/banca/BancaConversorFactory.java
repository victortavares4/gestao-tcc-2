/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import java.util.function.Function;

/**
 *
 * @author Nicolas
 */
public class BancaConversorFactory {
    public static Function<Object[], BancaRetonoFrontDto> criarConversorDto() {
         
        return (source) -> BancaRetonoFrontDto.builder()
                .build();
    }
}
