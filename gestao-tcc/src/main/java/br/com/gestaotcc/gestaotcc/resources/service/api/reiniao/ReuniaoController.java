/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.reiniao;

import br.com.gestaotcc.gestaotcc.utils.StandardResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Nicolas
 */
@Path("/reuniao")
public class ReuniaoController {
    
    @GET
    @Path("/findall/{tipo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTipo(@PathParam("tipo") String tipo) {

        try {
           
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
        }
    }
}
