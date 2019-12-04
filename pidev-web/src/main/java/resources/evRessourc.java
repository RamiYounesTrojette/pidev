package resources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import Entities.EvaluationSheet;
import ServiceImpl.EvaluationSheetService;

@Path("evaluation")
@RequestScoped
public class evRessourc {
	public static List<EvaluationSheet> Listeevaluationsheet = new ArrayList<EvaluationSheet>();
 
@Context 
private UriInfo uriinfo;

@EJB
EvaluationSheetService Evaluationservice;

@DELETE
@Path("{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response deleteEval(@PathParam("id") int id) {
	 
	Evaluationservice.removeEval(id);
		return Response.status(Status.OK).entity("Evaluation deleted").build();
		

}

}
