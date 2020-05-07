/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

/**
 *
 * @author SHINJIRU
 */
import java.util.List;
 
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
import models.Semesters;
import services.SemesterService;

@Path("SemesterService")
@Produces(MediaType.APPLICATION_JSON)
public class SemesterResource {
    
    	SemesterService semesterService = new SemesterService();
 
	@Path("/semesters")
	@GET 
	public Response getSemesters() {
		List<Semesters> listOfSemesters;
                listOfSemesters = SemesterService.getAllSemesters();
		if (listOfSemesters.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(listOfSemesters).build();
	}
 
 
	@Path("/semesters/{id}")
	@GET 
	public Semesters getSemesterById(@PathParam(value = "id") int id) {
		return semesterService.getSemesters(id);
	}
 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/semesters")
	@POST 
	public Semesters addBook(Semesters Semesters) {
		return semesterService.addSemesters(Semesters);
	}
 
	@Path("/semesters")
	@PUT 
	@Consumes(MediaType.APPLICATION_JSON)
	public Semesters updateSemesters(Semesters Semesters) {
		return semesterService.updateSemesters(Semesters);
 
	}
 
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Semesters/{id}")
	@DELETE
	public void deleteBook(@PathParam(value = "id")int id) {
		semesterService.deleteSemesters(id);
 
	} 
}
    

