/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "user_token")
@NamedQueries({
    @NamedQuery(name = "UserToken.findAll", query = "SELECT u FROM UserToken u"),
    @NamedQuery(name = "UserToken.findByIdToken", query = "SELECT u FROM UserToken u WHERE u.idToken = :idToken"),
    @NamedQuery(name = "UserToken.findByToken", query = "SELECT u FROM UserToken u WHERE u.token = :token"),
    @NamedQuery(name = "UserToken.findByDataInsercao", query = "SELECT u FROM UserToken u WHERE u.dataInsercao = :dataInsercao"),
    @NamedQuery(name = "UserToken.findByDataValidade", query = "SELECT u FROM UserToken u WHERE u.dataValidade = :dataValidade")})
public class UserToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_token")
    private Integer idToken;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;
    @Column(name = "data_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInsercao;
    @Column(name = "data_validade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataValidade;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Usuario idUsuario;

    public UserToken() {
    }

    public UserToken(Integer idToken) {
        this.idToken = idToken;
    }

    public UserToken(Integer idToken, String token) {
        this.idToken = idToken;
        this.token = token;
    }

    public Integer getIdToken() {
        return idToken;
    }

    public void setIdToken(Integer idToken) {
        this.idToken = idToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
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
        hash += (idToken != null ? idToken.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserToken)) {
            return false;
        }
        UserToken other = (UserToken) object;
        if ((this.idToken == null && other.idToken != null) || (this.idToken != null && !this.idToken.equals(other.idToken))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestaotcc.mavenproject1.UserToken[ idToken=" + idToken + " ]";
    }
    
}
