/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.reiniao.reuniaoArquivo;

import java.io.InputStream;
import lombok.Builder;
import lombok.Data;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

/**
 *
 * @author Nicolas
 */
@Data
@Builder
public class ReuniaoArquivoDto {
    private Integer idReuniaoArquivo;
    private Integer idReuniao;
    private Integer idArquivo;
    private Integer idUsuario;
 
    private InputStream arquvoStrem;
    private FormDataContentDisposition arquivoFormData;
}
