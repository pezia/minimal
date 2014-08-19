package hu.qualysoft.minimal.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author zsolt
 */
@Path("hello")
public class Hello {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public World hello() {
        return new World();
    }
}
