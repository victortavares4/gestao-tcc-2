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
@Table(name = "arquivo")
@NamedQueries({
    @NamedQuery(name = "Arquivo.findAll", query = "SELECT a FROM Arquivo a"),
    @NamedQuery(name = "Arquivo.findByIdArquivo", query = "SELECT a FROM Arquivo a WHERE a.idArquivo = :idArquivo"),
    @NamedQuery(name = "Arquivo.findByDataEnvio", query = "SELECT a FROM Arquivo a WHERE a.dataEnvio = :dataEnvio")})
public class Arquivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_arquivo")
    private Integer idArquivo;
    @Lob
    @Column(name = "arquivo")
    private byte[] arquivo;
    @Column(name = "data_envio")
    @Temporal(TemporalType.DATE)
    private Date dataEnvio;
    @OneToMany(mappedBy = "idArquivo")
    private Collection<ReuniaoArquivo> reuniaoArquivoCollection;
    @JoinColumn(name = "id_documento", referencedColumnName = "id_documento")
    @ManyToOne
    private Documento idDocumento;

    public Arquivo() {
    }

    public Arquivo(Integer idArquivo) {
        this.idArquivo = idArquivo;
    }

    public Integer getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(Integer idArquivo) {
        this.idArquivo = idArquivo;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Collection<ReuniaoArquivo> getReuniaoArquivoCollection() {
        return reuniaoArquivoCollection;
    }

    public void setReuniaoArquivoCollection(Collection<ReuniaoArquivo> reuniaoArquivoCollection) {
        this.reuniaoArquivoCollection = reuniaoArquivoCollection;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArquivo != null ? idArquivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquivo)) {
            return false;
        }
        Arquivo other = (Arquivo) object;
        if ((this.idArquivo == null && other.idArquivo != null) || (this.idArquivo != null && !this.idArquivo.equals(other.idArquivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.Arquivo[ idArquivo=" + idArquivo + " ]";
    }
    
}
