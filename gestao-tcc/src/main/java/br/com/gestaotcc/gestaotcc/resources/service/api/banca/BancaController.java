/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.banca;

import br.com.gestaotcc.gestaotcc.resources.service.api.usuario.UsuarioServicoEjb;
import br.com.gestaotcc.gestaotcc.utils.StandardResponse;
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
@Path("/banca")
public class BancaController {
    
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(BancaCommand bancaCommand) {
//  Json que devo receber do front
//    {
//    "id_coordenador": 1,
//    "id_professor": 2
//    }
        try {
            BancaServicoEjb servico = new BancaServicoEjb();
            servico.create(bancaCommand);
            return Response.ok(new StandardResponse("Banca criada com Sucesso")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
    
    @GET
    @Path("/findall")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(BancaCommand bancaCommand) {
//  Json que devo receber do front
//    {
//    "id_coordenador": 1,
//    "id_professor": 2,
//    "id_projeto":
//    }
        try {
            BancaServicoEjb servico = new BancaServicoEjb();
            servico.create(bancaCommand);
            return Response.ok(new StandardResponse("Banca criada com Sucesso")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
}
