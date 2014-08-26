package hu.qualysoft.minimal.rest;

import hu.qualysoft.minimal.entity.Category;
import hu.qualysoft.minimal.service.CategoryHandlerLocal;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
    
    @Inject
    CategoryHandlerLocal categoryHandler;
    
    @GET
    @Produces({"application/xml; qs=1.0", "application/json; qs=0.5"})
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
    
    @GET
    @Path("category")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories() {
        return categoryHandler.findAll();
    }
    
    @GET
    @Path("category/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategory(@PathParam("id") long id) {
        return categoryHandler.findById(id);
    }
}
