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

import Entities.JobFamily;
import Services.GenericService;


@Path("/families")
public class FamiliesResource {
	
	@EJB
	GenericService _service;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJobFamilies() {		
		return Response.status(200).entity(_service.getAll(JobFamily.class)).build();
	}
	
/*
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response addEmployee(Employe emp) {
		boolean result = employes.add(emp);
		if (result) {
			return Response.status(Status.CREATED).entity("Employee added successfully!").build();
		}
		return Response.status(500).entity("Record already exists!").build();
	}

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
