package hu.qualysoft.minimal.rest;

import hu.qualysoft.minimal.entity.Category;
import hu.qualysoft.minimal.entity.Product;
import hu.qualysoft.minimal.service.AsyncServiceLocal;
import hu.qualysoft.minimal.service.CategoryHandlerLocal;
import hu.qualysoft.minimal.service.ProductHandlerLocal;
import hu.qualysoft.minimal.worker.AsyncWorker;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJBAccessException;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author zsolt
 */
@Path("hello")
@RequestScoped
public class Hello {

    @Inject
    CategoryHandlerLocal categoryHandler;

    @Inject
    ProductHandlerLocal productHandler;

    @Inject
    AsyncServiceLocal asyncService;

    @Resource
    ManagedExecutorService executorService;

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
        try {
            return categoryHandler.findAll();
        } catch(EJBAccessException ex) {
            throw new NotAuthorizedException("Not authorized", "all");
        }
    }

    @GET
    @Path("category/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategory(@PathParam("id") long id) {
        return categoryHandler.findById(id);
    }

    @GET
    @Path("category/{id}/products")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getCategoryProducts(@PathParam("id") long id) {
        Category category = categoryHandler.findById(id);

        if (category == null) {
            throw new NotFoundException("Category does not exist");
        }

        return productHandler.findByCategory(category);
    }

    @GET
    @Path("addTestData")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> addTestData() {
        return productHandler.addTestData();
    }

    @GET
    @Path("async")
    public String asyncTest() throws InterruptedException, ExecutionException {
        Future<String> futureResult;

        Logger.getLogger("Async test").log(Level.INFO, "Before call");

        futureResult = asyncService.doJob();

        Logger.getLogger("Async test").log(Level.INFO, "After call");

        String result = futureResult.get();

        Logger.getLogger("Async test").log(Level.INFO, "Future.get finished");

        return result;
    }

    @GET
    @Path("executor")
    public String executorTest() throws InterruptedException, ExecutionException {
        Future<String> futureResult;

        Logger.getLogger("Async test").log(Level.INFO, "Before executor submit");

        futureResult = executorService.submit(new AsyncWorker());

        Logger.getLogger("Async test").log(Level.INFO, "After executor submit");

        String result = futureResult.get();

        Logger.getLogger("Async test").log(Level.INFO, "Future.get finished");

        return result;
    }
}
