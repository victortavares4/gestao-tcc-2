/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "banca_professor")
@NamedQueries({
    @NamedQuery(name = "BancaProfessor.findAll", query = "SELECT b FROM BancaProfessor b"),
    @NamedQuery(name = "BancaProfessor.findByIdBancaProfessor", query = "SELECT b FROM BancaProfessor b WHERE b.idBancaProfessor = :idBancaProfessor")})
public class BancaProfessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banca_professor")
    private Integer idBancaProfessor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBancaProfessor")
    private Collection<Avaliacao> avaliacaoCollection;
    @JoinColumn(name = "id_banca", referencedColumnName = "id_banca")
    @ManyToOne
    private Banca idBanca;
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    @ManyToOne
    private Usuario idProfessor;

    public BancaProfessor() {
    }

    public BancaProfessor(Integer idBancaProfessor) {
        this.idBancaProfessor = idBancaProfessor;
    }

    public Integer getIdBancaProfessor() {
        return idBancaProfessor;
    }

    public void setIdBancaProfessor(Integer idBancaProfessor) {
        this.idBancaProfessor = idBancaProfessor;
    }

    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    public Banca getIdBanca() {
        return idBanca;
    }

    public void setIdBanca(Banca idBanca) {
        this.idBanca = idBanca;
    }

    public Usuario getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Usuario idProfessor) {
        this.idProfessor = idProfessor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBancaProfessor != null ? idBancaProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BancaProfessor)) {
            return false;
        }
        BancaProfessor other = (BancaProfessor) object;
        if ((this.idBancaProfessor == null && other.idBancaProfessor != null) || (this.idBancaProfessor != null && !this.idBancaProfessor.equals(other.idBancaProfessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.BancaProfessor[ idBancaProfessor=" + idBancaProfessor + " ]";
    }
    
}
