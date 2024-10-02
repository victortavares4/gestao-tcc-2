package br.com.gestaotcc.gestaotcc.resources.service.api.nota;

import br.com.gestaotcc.gestaotcc.utils.StandardResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/nota")
public class NotaController {

    private NotaServicoEjb servico = new NotaServicoEjb();

    @POST
    @Path("/criterio")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarCriterio(Criterio criterio) {
        
        try {
            servico.criarCriterio(criterio);
            return Response.ok(new StandardResponse("Critério criado com sucesso")).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(new StandardResponse("Erro ao criar critério: " + e.getMessage()))
                           .build();
        }
    }

    @POST
    @Path("/lancar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response lancarNota(Avaliacao avaliacao) {
        
        try {
            servico.criarNota(avaliacao);
            return Response.status(Response.Status.CREATED)
                           .entity(new StandardResponse("Nota lançada com sucesso"))
                           .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(new StandardResponse("Erro ao lançar nota: " + e.getMessage()))
                           .build();
        }
    }

    @GET
    @Path("/criterios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCriterios() {
        try {
            List<Criterio> criterios = servico.listarCriterios();
            return Response.ok(criterios).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(new StandardResponse("Erro ao listar critérios: " + e.getMessage()))
                           .build();
        }
    }

    @GET
    @Path("/aluno/{idAluno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarNotasPorAluno(@PathParam("idAluno") int idAluno) {
        if (idAluno <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(new StandardResponse("ID de aluno inválido"))
                           .build();
        }
        try {
            List<Avaliacao> notas = servico.listarNotasPorAluno(idAluno);
            return Response.ok(notas).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(new StandardResponse("Erro ao listar notas: " + e.getMessage()))
                           .build();
        }
    }
}
