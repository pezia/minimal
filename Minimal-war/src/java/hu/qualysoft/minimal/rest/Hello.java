package hu.qualysoft.minimal.rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author zsolt
 */
@Path("hello")
public class Hello {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public World hello(@QueryParam("name") String name) {
        return new World(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public World hello2(@PathParam("name") String name) {
        return new World(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public World helloPost(World world) {
        world.setName("Hello " + world.getName());
        return world;
    }
}
