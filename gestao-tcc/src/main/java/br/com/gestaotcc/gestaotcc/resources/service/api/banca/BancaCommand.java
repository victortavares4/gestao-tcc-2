/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import java.util.ArrayList;

import lombok.Data;

/**
 *
 * @author Nicolas
 */
@Data
public class BancaCommand {
    private Integer id_coordenador;
    private ArrayList<Integer> id_professor;
    private Integer id_projeto;
}
