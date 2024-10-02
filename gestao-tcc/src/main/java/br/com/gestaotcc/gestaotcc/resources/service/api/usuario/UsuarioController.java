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
    @Path("/orientador/{idAluno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrientadorByAlunoId(@PathParam("idAluno") int idAluno) {
        try {
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            Integer idOrientador = servico.getOrientadorIdByAlunoId(idAluno);

            if (idOrientador != null) {
                Map<String, Integer> response = new HashMap<>();
                response.put("idOrientador", idOrientador);
                return Response.ok(response).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new StandardResponse("Orientador não encontrado para o aluno especificado")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StandardResponse(e.getMessage())).build();
        }
    }

    @POST
    @Path("/vincular")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response vincularAlunoOrientador(VinculoAlunoOrientadorDto vinculoDto) {
        try {
            if (vinculoDto == null || vinculoDto.getIdAluno() == 0 || vinculoDto.getMatriculaOrientador() == null || vinculoDto.getMatriculaOrientador().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(new StandardResponse("Dados inválidos para vinculação.")).build();
            }

            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            servico.vincularAlunoOrientador(vinculoDto.getIdAluno(), vinculoDto.getMatriculaOrientador());
            return Response.status(Response.Status.CREATED)
                    .entity(new StandardResponse("Aluno vinculado ao orientador com sucesso")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new StandardResponse(e.getMessage())).build();
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
        // Json que devo receber do front
        // {
        // "nome": "Nome do Usuário",
        // "matricula": "login_do_usuario",
        // "senha": "senha_secreta",
        // "tipo": 1,
        // "imagem": "data:image/png;base64,iVBORw0KGgoAAAANS..."
        // }
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
        try {
            UsuarioServicoEjb servico = new UsuarioServicoEjb();
            LoginRetornoFrontDto loginRetorno = servico.authenticate(loginDto);
            return Response.ok(loginRetorno).build();
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
            if (servico.verificarToken(token)) {
                return Response.ok(new StandardResponse("Token valido")).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity(new StandardResponse("Token Invalido")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new StandardResponse(e.getMessage())).build();
        }
    }
}
