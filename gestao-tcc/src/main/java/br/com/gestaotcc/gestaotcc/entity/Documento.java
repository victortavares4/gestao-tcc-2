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
@Table(name = "documento")
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByIdDocumento", query = "SELECT d FROM Documento d WHERE d.idDocumento = :idDocumento"),
    @NamedQuery(name = "Documento.findByDataEnvio", query = "SELECT d FROM Documento d WHERE d.dataEnvio = :dataEnvio"),
    @NamedQuery(name = "Documento.findByPrazoFinal", query = "SELECT d FROM Documento d WHERE d.prazoFinal = :prazoFinal")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento")
    private Integer idDocumento;
    @Column(name = "data_envio")
    @Temporal(TemporalType.DATE)
    private Date dataEnvio;
    @JoinColumn(name = "id_projeto", referencedColumnName = "id_projeto")
    @ManyToOne
    private Projeto idProjeto;
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne
    private TipoDocumento tipoDocumento;
    @OneToMany(mappedBy = "idDocumento")
    private Collection<Arquivo> arquivoCollection;

    public Documento() {
    }

    public Documento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Projeto getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Projeto idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Collection<Arquivo> getArquivoCollection() {
        return arquivoCollection;
    }

    public void setArquivoCollection(Collection<Arquivo> arquivoCollection) {
        this.arquivoCollection = arquivoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.Documento[ idDocumento=" + idDocumento + " ]";
    }
    
}
