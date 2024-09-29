/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.documento;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Nicolas
 */
@Builder
public class DocumentoDto {

    private Integer id_documento;
    private Integer tipo_documento;
    private Integer id_projeto;
    private Data data_envio;
    private Data prazo_final;

    public Integer getId_documento() {
        return id_documento;
    }

    public void setId_documento(Integer id_documento) {
        this.id_documento = id_documento;
    }

    public Integer getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(Integer tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Integer getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(Integer id_projeto) {
        this.id_projeto = id_projeto;
    }

    public Data getData_envio() {
        return data_envio;
    }

    public void setData_envio(Data data_envio) {
        this.data_envio = data_envio;
    }

    public Data getPrazo_final() {
        return prazo_final;
    }

    public void setPrazo_final(Data prazo_final) {
        this.prazo_final = prazo_final;
    }
    
    
    
}
