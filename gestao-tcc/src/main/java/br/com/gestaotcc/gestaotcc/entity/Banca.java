/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "banca")
@NamedQueries({
    @NamedQuery(name = "Banca.findAll", query = "SELECT b FROM Banca b"),
    @NamedQuery(name = "Banca.findByIdBanca", query = "SELECT b FROM Banca b WHERE b.idBanca = :idBanca")})
public class Banca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banca")
    private Integer idBanca;
    @OneToMany(mappedBy = "idBanca")
    private Collection<BancaProfessor> bancaProfessorCollection;
    @JoinColumn(name = "id_coordenador", referencedColumnName = "id")
    @ManyToOne
    private Usuario idCoordenador;

    public Banca() {
    }

    public Banca(Integer idBanca) {
        this.idBanca = idBanca;
    }

    public Integer getIdBanca() {
        return idBanca;
    }

    public void setIdBanca(Integer idBanca) {
        this.idBanca = idBanca;
    }

    public Collection<BancaProfessor> getBancaProfessorCollection() {
        return bancaProfessorCollection;
    }

    public void setBancaProfessorCollection(Collection<BancaProfessor> bancaProfessorCollection) {
        this.bancaProfessorCollection = bancaProfessorCollection;
    }

    public Usuario getIdCoordenador() {
        return idCoordenador;
    }

    public void setIdCoordenador(Usuario idCoordenador) {
        this.idCoordenador = idCoordenador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanca != null ? idBanca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banca)) {
            return false;
        }
        Banca other = (Banca) object;
        if ((this.idBanca == null && other.idBanca != null) || (this.idBanca != null && !this.idBanca.equals(other.idBanca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.Banca[ idBanca=" + idBanca + " ]";
    }
    
}
