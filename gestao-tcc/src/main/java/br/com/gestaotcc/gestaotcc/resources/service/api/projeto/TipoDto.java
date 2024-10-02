/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author LarissaJoanaHelfer
 */
@Data
@Builder
public class TipoDto {
        private Integer id;
        private String descricao;
}
