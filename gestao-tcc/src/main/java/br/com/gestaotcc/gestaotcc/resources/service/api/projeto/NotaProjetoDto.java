/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import java.math.BigDecimal;

/**
 *
 * @author LarissaJoanaHelfer
 */
public class NotaProjetoDto {
    private Long idProjeto;
    private BigDecimal notaProposta;
    private BigDecimal notaTcc;

    // Getters e setters
    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public BigDecimal getNotaProposta() {
        return notaProposta;
    }

    public void setNotaProposta(BigDecimal notaProposta) {
        this.notaProposta = notaProposta;
    }

    public BigDecimal getNotaTcc() {
        return notaTcc;
    }

    public void setNotaTcc(BigDecimal notaTcc) {
        this.notaTcc = notaTcc;
    }
}
