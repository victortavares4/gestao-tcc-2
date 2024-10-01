/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import br.com.gestaotcc.gestaotcc.resources.service.api.documento.DocumentoDto;
import br.com.gestaotcc.gestaotcc.utils.StandardResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Nicolas
 */
@Path("/projeto")
public class ProjetoController {

    @POST
    @Path("/criar")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarProjeto(
            @FormDataParam("id_aluno") int idAluno,
            @FormDataParam("id_orientador") int idOrientador,
            @FormDataParam("nome") String nome,
            @FormDataParam("descricao") String descricao,
            @FormDataParam("arquivo") InputStream arquivoInputStream,
            @FormDataParam("arquivo") FormDataContentDisposition fileDetail) {

        try {
            if (nome == null || descricao == null || arquivoInputStream == null) {
                throw new IllegalArgumentException("Campos obrigatórios estão faltando.");
            }

            String baseDirectory = "C:/uploads/";
            String uploadedFileLocation = baseDirectory + fileDetail.getFileName();
            saveToFile(arquivoInputStream, uploadedFileLocation);

            ProjetoDto projetoDto = new ProjetoDto();
            projetoDto.setId_aluno(idAluno);
            projetoDto.setId_orientador(idOrientador);
            projetoDto.setNome(nome);
            projetoDto.setDescricao(descricao);

            java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());
            projetoDto.setData_inicio(dataAtual);
            projetoDto.setData_fim(dataAtual);

            DocumentoDto documentoDto = DocumentoDto.builder()
                    .tipo_documento(1)
                    .data_envio(dataAtual)
                    .prazo_final(dataAtual)
                    .build();

            ProjetoServicoEjb servico = new ProjetoServicoEjb();
            servico.create(projetoDto, documentoDto);

            return Response.ok(new StandardResponse("Projeto e documento criados com sucesso")).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StandardResponse("Erro de validação: " + e.getMessage()))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new StandardResponse("Erro interno ao criar projeto: " + e.getMessage()))
                    .build();
        }
    }

    private void saveToFile(InputStream uploadedInputStream, String targetLocation) throws IOException {
        File file = new File(targetLocation);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            if (parentDir.mkdirs()) {
                System.out.println("Diretório criado: " + parentDir.getAbsolutePath());
            } else {
                throw new IOException("Falha ao criar o diretório: " + parentDir.getAbsolutePath());
            }
        }

        // Salvar o arquivo
        try (OutputStream out = new FileOutputStream(file)) {
            byte[] bytes = new byte[1024];
            int read;
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
        }
    }

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProjetos() {
        try {
            ProjetoServicoEjb servico = new ProjetoServicoEjb();
            List<ProjetoDto> projetos = servico.getAll();
            return Response.ok(projetos).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
    
    @POST
    @Path("/comentario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setComenterio(ProjetoDto projetoDto) {
        try {
            ProjetoServicoEjb servico = new ProjetoServicoEjb();
            servico.create(projetoDto);
            return Response.ok(new StandardResponse("Projeto cadastrado com sucesso")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StandardResponse(e.getMessage())).build();
        }
    }
    

    
    
    
    
    //comentario 
    //reunião
    
    // apresentação tcc 
    
    
    // documento
}
