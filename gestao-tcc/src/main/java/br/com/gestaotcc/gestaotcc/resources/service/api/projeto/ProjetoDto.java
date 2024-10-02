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
    private Integer id_documento;
    private String alunoNome;
    private String orientadorNome;
    private String nome;
    private String descricao;
    private Date data_inicio;
    private Date data_fim;
    private Integer tipo_documento;
    private String status;
    private String alunoImagem;
    private String orientadorImagem;
    private double notaProposta;

    public ProjetoDto() {
    }

    public ProjetoDto(Integer id_projeto, Integer id_aluno, Integer id_orientador, Integer id_documento, String alunoNome, String orientadorNome, String nome, String descricao, Date data_inicio, Date data_fim, Integer tipo_documento, String status, String alunoImagem, String orientadorImagem, double notaProposta) {
        this.id_projeto = id_projeto;
        this.id_aluno = id_aluno;
        this.id_orientador = id_orientador;
        this.id_documento = id_documento;
        this.alunoNome = alunoNome;
        this.orientadorNome = orientadorNome;
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.tipo_documento = tipo_documento;
        this.status = status;
        this.alunoImagem = alunoImagem;
        this.orientadorImagem = orientadorImagem;
        this.notaProposta = notaProposta;
    }
    public double getNotaProposta() {
        return notaProposta;
    }

    public void setNotaProposta(double notaProposta) {
        this.notaProposta = notaProposta;
    }

    public String getAlunoImagem() {
        return alunoImagem;
    }

    public void setAlunoImagem(String alunoImagem) {
        this.alunoImagem = alunoImagem;
    }

    public String getOrientadorImagem() {
        return orientadorImagem;
    }

    public void setOrientadorImagem(String orientadorImagem) {
        this.orientadorImagem = orientadorImagem;
    }

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

    public Integer getId_documento() {
        return id_documento;
    }

    public void setId_documento(Integer id_documento) {
        this.id_documento = id_documento;
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

    public Integer getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(Integer tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
