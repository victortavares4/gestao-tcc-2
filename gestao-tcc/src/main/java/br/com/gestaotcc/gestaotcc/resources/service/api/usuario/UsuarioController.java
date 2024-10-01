/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.resources.service.api.usuario;

import br.com.gestaotcc.gestaotcc.resources.service.api.usuario.login.LoginDto;
import br.com.gestaotcc.gestaotcc.resources.service.api.usuario.login.LoginRetornoFrontDto;
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
@Path("/user")
public class UsuarioController {
    
    @GET
    @Path("/findall")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        try {
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            List<UsuarioDtoConsultaFront> users = servico.findAll();
            return Response.ok(users).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
    @GET
    @Path("/findall/{tipo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTipo(@PathParam("tipo") String tipo) {

        try {
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            List<UsuarioDtoConsultaFront> users = servico.findAllTipo(tipo);
            return Response.ok(users).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(UsuarioDto usuarioDto) {
//  Json que devo receber do front
//    {
//    "nome": "Nome do Usuário",
//    "login": "login_do_usuario",
//    "senha": "senha_secreta"
//    }
        try {
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            servico.create(usuarioDto);
            return Response.ok(new StandardResponse("Usuario cadastrado")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDto loginDto) {
//  Json que devo receber do front
//    {
//    "login": "login_do_usuario",
//    "senha": "senha_secreta"
//    }
//Retorno para o front
//{
//    "token": "token_secreto"
//    "tipo_user": "aluno"
//    "nome_user": "Teste da Silva"
//    "id_user": 1
//    "id_orientador": 1
//    "nome_orientador": "Teste da Silva dorivaldo"
//}
        try { 
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            LoginRetornoFrontDto retorno = servico.authenticate(loginDto);
            
            return Response.ok(retorno).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new StandardResponse(e.getMessage())).build();
        }
    }
    
    @POST
    @Path("/verificar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificarUser(@Context HttpHeaders headers) {
        
        String token = headers.getHeaderString("Authorization");

        if (token == null || token.isEmpty()) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Token is missing").build();
        }

        try {
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            if(servico.verificarToken(token)){
               return Response.ok(new StandardResponse("Token valido")).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity(new StandardResponse("Token Invalido")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new StandardResponse(e.getMessage())).build();
        }
    }
}
