package br.com.gestaotcc.gestaotcc.resources.service.api.nota;

import lombok.Data;

@Data
public class Criterio {
    private int idCriterio; 
    private String nome;
    private String descricaoCriterio; 
    private float pesoMaximo;
}
