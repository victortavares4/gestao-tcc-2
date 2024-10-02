/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.reiniao;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Nicolas
 */
@Data
@Builder
public class ReuniaoDto {
    private Integer idReuniao;
    private Integer idProjeto;
    private LocalDateTime dataHora;
    private String descricao;
}
