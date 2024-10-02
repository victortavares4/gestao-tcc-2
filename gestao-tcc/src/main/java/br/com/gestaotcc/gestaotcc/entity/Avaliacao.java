/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "avaliacao")
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByIdAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.idAvaliacao = :idAvaliacao"),
    @NamedQuery(name = "Avaliacao.findByNota", query = "SELECT a FROM Avaliacao a WHERE a.nota = :nota")})
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_avaliacao")
    private Integer idAvaliacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "nota")
    private BigDecimal nota;
    @JoinColumn(name = "id_banca_professor", referencedColumnName = "id_banca_professor")
    @ManyToOne(optional = false)
    private BancaProfessor idBancaProfessor;
    @JoinColumn(name = "id_criterio", referencedColumnName = "id_criterio")
    @ManyToOne(optional = false)
    private Criterios idCriterio;
    @JoinColumn(name = "id_projeto", referencedColumnName = "id_projeto")
    @ManyToOne(optional = false)
    private Projeto idProjeto;

    public Avaliacao() {
    }

    public Avaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Avaliacao(Integer idAvaliacao, BigDecimal nota) {
        this.idAvaliacao = idAvaliacao;
        this.nota = nota;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public BancaProfessor getIdBancaProfessor() {
        return idBancaProfessor;
    }

    public void setIdBancaProfessor(BancaProfessor idBancaProfessor) {
        this.idBancaProfessor = idBancaProfessor;
    }

    public Criterios getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Criterios idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Projeto getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Projeto idProjeto) {
        this.idProjeto = idProjeto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvaliacao != null ? idAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.idAvaliacao == null && other.idAvaliacao != null) || (this.idAvaliacao != null && !this.idAvaliacao.equals(other.idAvaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.Avaliacao[ idAvaliacao=" + idAvaliacao + " ]";
    }
    
}
