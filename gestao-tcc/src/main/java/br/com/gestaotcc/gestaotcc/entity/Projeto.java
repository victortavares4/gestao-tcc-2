/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "projeto")
@NamedQueries({
    @NamedQuery(name = "Projeto.findAll", query = "SELECT p FROM Projeto p"),
    @NamedQuery(name = "Projeto.findByIdProjeto", query = "SELECT p FROM Projeto p WHERE p.idProjeto = :idProjeto"),
    @NamedQuery(name = "Projeto.findByNome", query = "SELECT p FROM Projeto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Projeto.findByDataInicio", query = "SELECT p FROM Projeto p WHERE p.dataInicio = :dataInicio"),
    @NamedQuery(name = "Projeto.findByDataFim", query = "SELECT p FROM Projeto p WHERE p.dataFim = :dataFim")})
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_projeto")
    private Integer idProjeto;
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @OneToMany(mappedBy = "idProjeto")
    private Collection<Documento> documentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProjeto")
    private Collection<Avaliacao> avaliacaoCollection;
    @OneToMany(mappedBy = "idProjeto")
    private Collection<Comentario> comentarioCollection;
    @OneToMany(mappedBy = "idProjeto")
    private Collection<Reuniao> reuniaoCollection;
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    @ManyToOne
    private Usuario idAluno;
    @JoinColumn(name = "id_orientador", referencedColumnName = "id")
    @ManyToOne
    private Usuario idOrientador;

    public Projeto() {
    }

    public Projeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    public Collection<Reuniao> getReuniaoCollection() {
        return reuniaoCollection;
    }

    public void setReuniaoCollection(Collection<Reuniao> reuniaoCollection) {
        this.reuniaoCollection = reuniaoCollection;
    }

    public Usuario getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Usuario idAluno) {
        this.idAluno = idAluno;
    }

    public Usuario getIdOrientador() {
        return idOrientador;
    }

    public void setIdOrientador(Usuario idOrientador) {
        this.idOrientador = idOrientador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProjeto != null ? idProjeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projeto)) {
            return false;
        }
        Projeto other = (Projeto) object;
        if ((this.idProjeto == null && other.idProjeto != null) || (this.idProjeto != null && !this.idProjeto.equals(other.idProjeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.Projeto[ idProjeto=" + idProjeto + " ]";
    }
    
}
