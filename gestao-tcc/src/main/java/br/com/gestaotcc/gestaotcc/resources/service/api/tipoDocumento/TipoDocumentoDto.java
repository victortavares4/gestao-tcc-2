package br.com.gestaotcc.gestaotcc.resources.service.api.tipoDocumento;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoDocumentoDto {
    private Integer id_tipo_documento;
    private String descricao;
    private Date prazo_final;
}
