package br.com.gestaotcc.gestaotcc.resources.service.api.nota;

import lombok.Data;

@Data
public class Avaliacao {
    private int idAvaliacao; 
    private int idBancaProfessor; 
    private int idProjeto; 
    private int idCriterio; 
    private float nota; 
}
