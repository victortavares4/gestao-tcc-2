/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.entity;

import java.io.Serializable;
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
@Table(name = "reuniao_arquivo")
@NamedQueries({
    @NamedQuery(name = "ReuniaoArquivo.findAll", query = "SELECT r FROM ReuniaoArquivo r"),
    @NamedQuery(name = "ReuniaoArquivo.findByIdReuniaoArquivo", query = "SELECT r FROM ReuniaoArquivo r WHERE r.idReuniaoArquivo = :idReuniaoArquivo")})
public class ReuniaoArquivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reuniao_arquivo")
    private Integer idReuniaoArquivo;
    @JoinColumn(name = "id_arquivo", referencedColumnName = "id_arquivo")
    @ManyToOne
    private Arquivo idArquivo;
    @JoinColumn(name = "id_reuniao", referencedColumnName = "id_reuniao")
    @ManyToOne
    private Reuniao idReuniao;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUsuario;

    public ReuniaoArquivo() {
    }

    public ReuniaoArquivo(Integer idReuniaoArquivo) {
        this.idReuniaoArquivo = idReuniaoArquivo;
    }

    public Integer getIdReuniaoArquivo() {
        return idReuniaoArquivo;
    }

    public void setIdReuniaoArquivo(Integer idReuniaoArquivo) {
        this.idReuniaoArquivo = idReuniaoArquivo;
    }

    public Arquivo getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(Arquivo idArquivo) {
        this.idArquivo = idArquivo;
    }

    public Reuniao getIdReuniao() {
        return idReuniao;
    }

    public void setIdReuniao(Reuniao idReuniao) {
        this.idReuniao = idReuniao;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReuniaoArquivo != null ? idReuniaoArquivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReuniaoArquivo)) {
            return false;
        }
        ReuniaoArquivo other = (ReuniaoArquivo) object;
        if ((this.idReuniaoArquivo == null && other.idReuniaoArquivo != null) || (this.idReuniaoArquivo != null && !this.idReuniaoArquivo.equals(other.idReuniaoArquivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.ReuniaoArquivo[ idReuniaoArquivo=" + idReuniaoArquivo + " ]";
    }
    
}
