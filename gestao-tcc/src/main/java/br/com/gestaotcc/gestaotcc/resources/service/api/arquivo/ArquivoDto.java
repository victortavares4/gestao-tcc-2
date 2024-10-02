/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.arquivo;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Nicolas
 */
@Data
@Builder
public class ArquivoDto {
//    id_arquivo INT PRIMARY KEY AUTO_INCREMENT,
//    arquivo LONGBLOB,
//    data_envio DATE,
//    id_documento INT, 
    
    private Integer idArquivo;
    private Date dataEnvio;
    private Integer idDocumento;
}
