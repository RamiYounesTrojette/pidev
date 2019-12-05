package Resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Competency;
import Entities.Job;
import Services.GenericService;


@Path("/competencies")
public class CompetencyResource {
	
	@EJB
	GenericService _service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompetencies() {		
		try 
		{	
		List<Competency> comps = _service.getAll(Competency.class);
		ArrayList<Object> res = new ArrayList<Object>();
		Iterator<Competency> itr = comps.iterator();
		while(itr.hasNext()) {
			Competency comp = itr.next();
			res.add(new Object() {public int id=comp.getId(); public String name = comp.getName() + " level " + comp.getLevel();});
		}
		return Response.status(200).entity(res).build();
	} catch(Exception e) {
		return Response.status(500).entity("An error has occurred. Please verify the data!").build();
	}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCompetency(Competency c) {
		try {
		int result = _service.add(c);
		if (result>=0) {
			return Response.status(Status.CREATED).entity("Competency added successfully!").build();
		}
	} catch(Exception e) {
		return Response.status(500).entity("An error has occurred. Please verify the data!").build();
	}

		return Response.status(500).entity("An error has occurred. Please verify the data!").build();
	}
	
	@DELETE
	@Path("/{Id}")
	public Response deleteEmployee(@PathParam("Id") int Id) {
		_service.delete(_service.get(Id, Competency.class), Competency.class);

			return Response.status(Status.GONE).entity("").build();
	}
	
/*
	@GET
	@Path("/{Id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response searchEmployee(@PathParam("Id") String Id) {
		Iterator<Employe> itr = employes.iterator();
		Employe result = null;
		while (itr.hasNext() && result == null) {
			Employe temp = itr.next();
			if (temp.getCin().equals(Id)) {
				result = temp;
			}
		}
		if (result != null) {
			return Response.status(Status.FOUND).entity(result).build();
		}
		return Response.status(Status.NOT_FOUND).entity("Record does not exist!").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayEmployeesList() {
		ArrayList<Employe> list = new ArrayList<Employe>(employes);
		return Response.status(200).entity(list).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(Employe emp) {
		if (employes.contains(emp)) {
			employes.remove(emp);
			employes.add(emp);
			return Response.status(Status.ACCEPTED).entity(emp).build();
		}
		return Response.status(500).entity("Record does not exist!").build();
	}

	@DELETE
	@Path("/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("Id") String Id) {
		Iterator<Employe> itr = employes.iterator();
		boolean found = false;
		while (itr.hasNext() && !found) {
			Employe temp = itr.next();
			if (temp.getCin().equals(Id)) {
				found = true;
				employes.remove(temp);
			}
		}
		if (found) {
			return Response.status(Status.GONE).entity(employes).build();
		}
		return Response.status(Status.NOT_FOUND).entity("Record does not exist!").build();
	}
	
	/*@GET
	@Path("/query")
	public Response getUsers(
		@QueryParam("from") int from,
		@QueryParam("to") int to,
		@QueryParam("orderBy") List<String> orderBy) {

		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();

	}*/
}
