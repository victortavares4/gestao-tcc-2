/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Nicolas
 */
@Data
@Builder
public class BancaRetonoFrontDto {

    private int idProjeto;
    private String nomeProjeto;
    private int idBanca;
    private int idProfessor;
    private String nomeProfessor;
}
