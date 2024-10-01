package br.com.gestaotcc.gestaotcc.resources.service.api.documento;

import br.com.gestaotcc.gestaotcc.utils.StandardResponse;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/documento")
public class DocumentoController {

    private DocumentoServicoEjb documentoServico = new DocumentoServicoEjb();

    @POST
    @Path("/avaliar/{id_documento}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response avaliarDocumento(@PathParam("id_documento") int idDocumento, DocumentoDto documentoDto) {
        try {
            if (documentoDto.getNotaProposta() == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(new StandardResponse("Nota da proposta não fornecida"))
                        .build();
            }

            documentoServico.avaliarDocumento(idDocumento, documentoDto.getNotaProposta());

            return Response.ok(new StandardResponse("Documento avaliado com sucesso")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new StandardResponse("Erro ao avaliar documento: " + e.getMessage()))
                    .build();
        }
    }

    @POST
    @Path("/rejeitar/{id_documento}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response rejeitarDocumento(@PathParam("id_documento") int idDocumento) {
        try {
            documentoServico.rejeitarDocumento(idDocumento);

            return Response.ok(new StandardResponse("Documento rejeitado, Reelaboração de Proposta requerida")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new StandardResponse("Erro ao rejeitar documento: " + e.getMessage()))
                    .build();
        }
    }
}
