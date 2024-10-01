package br.com.gestaotcc.gestaotcc.resources.service.api.documento;

import java.util.Date;
import lombok.Builder;

@Builder
public class DocumentoDto {

    private Integer id_documento;
    private Integer tipo_documento;
    private Integer id_projeto;
    private Double notaProposta;
    private Date data_envio;
    private Date prazo_final;

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
    
    public Double getNotaProposta() {
        return notaProposta;
    }

    public void setNotaProposta(Double notaProposta) {
        this.notaProposta = notaProposta;
    }

    public void setId_projeto(Integer id_projeto) {
        this.id_projeto = id_projeto;
    }

    public Date getData_envio() {
        return data_envio;
    }

    public void setData_envio(Date data_envio) {
        this.data_envio = data_envio;
    }

    public Date getPrazo_final() {
        return prazo_final;
    }

    public void setPrazo_final(Date prazo_final) {
        this.prazo_final = prazo_final;
    }
}
