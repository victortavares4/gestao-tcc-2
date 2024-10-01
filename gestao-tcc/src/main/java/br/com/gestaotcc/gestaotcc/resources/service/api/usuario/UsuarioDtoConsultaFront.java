/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.usuario;

import lombok.Builder;

/**
 *
 * @author Nicolas
 */
@Builder
public class UsuarioDtoConsultaFront {
    
    private String nome;
    private String matricula;
    private String tipo_descricao;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo_descricao() {
        return tipo_descricao;
    }

    public void setTipo_descricao(String tipo_descricao) {
        this.tipo_descricao = tipo_descricao;
    }
}
