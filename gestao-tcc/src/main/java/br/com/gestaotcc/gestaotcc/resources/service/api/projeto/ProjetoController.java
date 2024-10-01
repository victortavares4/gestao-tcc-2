/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.projeto;

import br.com.gestaotcc.gestaotcc.utils.StandardResponse;
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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarProjeto(ProjetoDto projetoDto) {
        try {
            ProjetoServicoEjb servico = new ProjetoServicoEjb();
            servico.create(projetoDto);
            return Response.ok(new StandardResponse("Projeto cadastrado com sucesso")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StandardResponse(e.getMessage())).build();
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
