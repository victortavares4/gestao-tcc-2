/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "criterios")
@NamedQueries({
    @NamedQuery(name = "Criterios.findAll", query = "SELECT c FROM Criterios c"),
    @NamedQuery(name = "Criterios.findByIdCriterio", query = "SELECT c FROM Criterios c WHERE c.idCriterio = :idCriterio"),
    @NamedQuery(name = "Criterios.findByNome", query = "SELECT c FROM Criterios c WHERE c.nome = :nome"),
    @NamedQuery(name = "Criterios.findByPesoMaximo", query = "SELECT c FROM Criterios c WHERE c.pesoMaximo = :pesoMaximo")})
public class Criterios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterio")
    private Integer idCriterio;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "descricao_criterio")
    private String descricaoCriterio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "peso_maximo")
    private BigDecimal pesoMaximo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterio")
    private Collection<Avaliacao> avaliacaoCollection;

    public Criterios() {
    }

    public Criterios(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Criterios(Integer idCriterio, String nome, BigDecimal pesoMaximo) {
        this.idCriterio = idCriterio;
        this.nome = nome;
        this.pesoMaximo = pesoMaximo;
    }

    public Integer getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoCriterio() {
        return descricaoCriterio;
    }

    public void setDescricaoCriterio(String descricaoCriterio) {
        this.descricaoCriterio = descricaoCriterio;
    }

    public BigDecimal getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(BigDecimal pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterio != null ? idCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterios)) {
            return false;
        }
        Criterios other = (Criterios) object;
        if ((this.idCriterio == null && other.idCriterio != null) || (this.idCriterio != null && !this.idCriterio.equals(other.idCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.Criterios[ idCriterio=" + idCriterio + " ]";
    }
    
}
