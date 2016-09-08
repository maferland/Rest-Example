package maferland.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("home")
public class Resource {
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello, world!";
	}

	@GET
	@Path("param")
	@Produces(MediaType.TEXT_PLAIN)
	public String paramMethod(@QueryParam("Name") String name) {
		return helloName(name);
	}

	@GET
	@Path("path/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String pathMethod(@PathParam("name") String name) {
		return helloName(name);
	}

	@POST
	@Path("post")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String postMethod(@FormParam("name") String name) {
		return "<h2>Hello, " + name + "</h2>";
	}

	private String helloName(String name) {
		return String.format("Hello %s", name);
	}

}
