/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "reuniao")
@NamedQueries({
    @NamedQuery(name = "Reuniao.findAll", query = "SELECT r FROM Reuniao r"),
    @NamedQuery(name = "Reuniao.findByIdReuniao", query = "SELECT r FROM Reuniao r WHERE r.idReuniao = :idReuniao"),
    @NamedQuery(name = "Reuniao.findByDataHora", query = "SELECT r FROM Reuniao r WHERE r.dataHora = :dataHora")})
public class Reuniao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reuniao")
    private Integer idReuniao;
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idReuniao")
    private Collection<ReuniaoArquivo> reuniaoArquivoCollection;
    @JoinColumn(name = "id_projeto", referencedColumnName = "id_projeto")
    @ManyToOne
    private Projeto idProjeto;

    public Reuniao() {
    }

    public Reuniao(Integer idReuniao) {
        this.idReuniao = idReuniao;
    }

    public Integer getIdReuniao() {
        return idReuniao;
    }

    public void setIdReuniao(Integer idReuniao) {
        this.idReuniao = idReuniao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<ReuniaoArquivo> getReuniaoArquivoCollection() {
        return reuniaoArquivoCollection;
    }

    public void setReuniaoArquivoCollection(Collection<ReuniaoArquivo> reuniaoArquivoCollection) {
        this.reuniaoArquivoCollection = reuniaoArquivoCollection;
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
        hash += (idReuniao != null ? idReuniao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reuniao)) {
            return false;
        }
        Reuniao other = (Reuniao) object;
        if ((this.idReuniao == null && other.idReuniao != null) || (this.idReuniao != null && !this.idReuniao.equals(other.idReuniao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.Reuniao[ idReuniao=" + idReuniao + " ]";
    }
    
}
