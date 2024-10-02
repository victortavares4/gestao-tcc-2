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
@Table(name = "aluno_orientador")
@NamedQueries({
    @NamedQuery(name = "AlunoOrientador.findAll", query = "SELECT a FROM AlunoOrientador a"),
    @NamedQuery(name = "AlunoOrientador.findByIdAlunoOrientador", query = "SELECT a FROM AlunoOrientador a WHERE a.idAlunoOrientador = :idAlunoOrientador")})
public class AlunoOrientador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aluno_orientador")
    private Integer idAlunoOrientador;
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idAluno;
    @JoinColumn(name = "id_orientador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idOrientador;

    public AlunoOrientador() {
    }

    public AlunoOrientador(Integer idAlunoOrientador) {
        this.idAlunoOrientador = idAlunoOrientador;
    }

    public Integer getIdAlunoOrientador() {
        return idAlunoOrientador;
    }

    public void setIdAlunoOrientador(Integer idAlunoOrientador) {
        this.idAlunoOrientador = idAlunoOrientador;
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
        hash += (idAlunoOrientador != null ? idAlunoOrientador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoOrientador)) {
            return false;
        }
        AlunoOrientador other = (AlunoOrientador) object;
        if ((this.idAlunoOrientador == null && other.idAlunoOrientador != null) || (this.idAlunoOrientador != null && !this.idAlunoOrientador.equals(other.idAlunoOrientador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.AlunoOrientador[ idAlunoOrientador=" + idAlunoOrientador + " ]";
    }
    
}
