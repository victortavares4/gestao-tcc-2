/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.entity;

import br.com.gestaotcc.gestaotcc.entity.AlunoOrientador;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByMatricula", query = "SELECT u FROM Usuario u WHERE u.matricula = :matricula"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "senha")
    private String senha;
    @Lob
    @Column(name = "token")
    private String token;
    @Lob
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<ReuniaoArquivo> reuniaoArquivoCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Comentario> comentarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<AlunoOrientador> alunoOrientadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrientador")
    private Collection<AlunoOrientador> alunoOrientadorCollection1;
    @OneToMany(mappedBy = "idProfessor")
    private Collection<BancaProfessor> bancaProfessorCollection;
    @OneToMany(mappedBy = "idAluno")
    private Collection<Projeto> projetoCollection;
    @OneToMany(mappedBy = "idOrientador")
    private Collection<Projeto> projetoCollection1;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne
    private Tipo tipo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private UserToken userToken;
    @OneToMany(mappedBy = "idCoordenador")
    private Collection<Banca> bancaCollection;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<ReuniaoArquivo> getReuniaoArquivoCollection() {
        return reuniaoArquivoCollection;
    }

    public void setReuniaoArquivoCollection(Collection<ReuniaoArquivo> reuniaoArquivoCollection) {
        this.reuniaoArquivoCollection = reuniaoArquivoCollection;
    }

    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    public Collection<AlunoOrientador> getAlunoOrientadorCollection() {
        return alunoOrientadorCollection;
    }

    public void setAlunoOrientadorCollection(Collection<AlunoOrientador> alunoOrientadorCollection) {
        this.alunoOrientadorCollection = alunoOrientadorCollection;
    }

    public Collection<AlunoOrientador> getAlunoOrientadorCollection1() {
        return alunoOrientadorCollection1;
    }

    public void setAlunoOrientadorCollection1(Collection<AlunoOrientador> alunoOrientadorCollection1) {
        this.alunoOrientadorCollection1 = alunoOrientadorCollection1;
    }

    public Collection<BancaProfessor> getBancaProfessorCollection() {
        return bancaProfessorCollection;
    }

    public void setBancaProfessorCollection(Collection<BancaProfessor> bancaProfessorCollection) {
        this.bancaProfessorCollection = bancaProfessorCollection;
    }

    public Collection<Projeto> getProjetoCollection() {
        return projetoCollection;
    }

    public void setProjetoCollection(Collection<Projeto> projetoCollection) {
        this.projetoCollection = projetoCollection;
    }

    public Collection<Projeto> getProjetoCollection1() {
        return projetoCollection1;
    }

    public void setProjetoCollection1(Collection<Projeto> projetoCollection1) {
        this.projetoCollection1 = projetoCollection1;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public UserToken getUserToken() {
        return userToken;
    }

    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }

    public Collection<Banca> getBancaCollection() {
        return bancaCollection;
    }

    public void setBancaCollection(Collection<Banca> bancaCollection) {
        this.bancaCollection = bancaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.Usuario[ id=" + id + " ]";
    }
    
}
