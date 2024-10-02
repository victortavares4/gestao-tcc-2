/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.reiniao;

import br.com.gestaotcc.gestaotcc.resources.service.api.arquivo.ArquivoDto;
import br.com.gestaotcc.gestaotcc.resources.service.api.reiniao.reuniaoArquivo.ReuniaoArquivoDto;
import br.com.gestaotcc.gestaotcc.utils.StandardResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author Nicolas
 */
@Path("/reuniao")
public class ReuniaoController {

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(ReuniaoArquivoDto reuniaoArquivoDto) {

        try {
            
            ReuniaoServicoEjb servico = new ReuniaoServicoEjb();

            String baseDirectory = "C:/uploads/";
            String uploadedFileLocation = baseDirectory + reuniaoArquivoDto.getArquivoFormData().getFileName();
            saveToFile(reuniaoArquivoDto.getArquvoStrem(), uploadedFileLocation);
            
            
            
            servico.create();

            return Response.ok("").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
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
        try ( OutputStream out = new FileOutputStream(file)) {
            byte[] bytes = new byte[1024];
            int read;
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
        }
    }
    
    @GET
    @Path("/findall/{id_Projeto}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaReuniao(@PathParam("id_Projeto") Integer idProjeto) {

        try { 
            ReuniaoServicoEjb servico = new ReuniaoServicoEjb();
            
            List<ReuniaoDto> retorno = servico.findByIdProjeto(idProjeto);

            return Response.ok(retorno).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
    @GET
    @Path("/find/arquivo/{id_Arquivo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArquivo(@PathParam("id_Arquivo") Integer idArquivo) {
        
        try { 
            ReuniaoServicoEjb servico = new ReuniaoServicoEjb();
            
           ArquivoDto retorno = servico.findByIdArquivo(idArquivo);

            return Response.ok(retorno).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
        }
    }

}
