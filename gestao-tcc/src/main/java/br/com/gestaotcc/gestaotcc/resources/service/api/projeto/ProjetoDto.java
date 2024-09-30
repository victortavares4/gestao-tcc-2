/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import java.sql.Date;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Nicolas
 */
@Builder
public class ProjetoDto {

    private Integer id_projeto;
    private Integer id_aluno;
    private Integer id_orientador;
    private String alunoNome;
    private String orientadorNome;
    private String nome;
    private String descricao;
    private Date data_inicio;
    private Date data_fim;

    public Integer getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(Integer id_projeto) {
        this.id_projeto = id_projeto;
    }

    public Integer getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Integer id_aluno) {
        this.id_aluno = id_aluno;
    }

    public Integer getId_orientador() {
        return id_orientador;
    }

    public void setId_orientador(Integer id_orientador) {
        this.id_orientador = id_orientador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getOrientadorNome() {
        return orientadorNome;
    }

    public void setOrientadorNome(String orientadorNome) {
        this.orientadorNome = orientadorNome;
    }

}
