/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.reiniao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.function.Function;

/**
 *
 * @author Nicolas
 */
public class ReuniaoConversorFactory {
     public static Function<Object[], ReuniaoDto> criarConversorDto() {
         
        return (source) -> ReuniaoDto.builder()
                .idReuniao((Integer) source[0])
                .idProjeto((Integer) source[1])
                .dataHora((Timestamp) source[2])
                .descricao((String) source[3])
                .idArquivo((Integer) source[4])
                .build();
    }
}
