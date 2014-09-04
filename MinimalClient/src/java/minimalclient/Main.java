package minimalclient;

import hu.qualysoft.minimal.entity.Product;
import hu.qualysoft.minimal.service.ProductHandlerRemote;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author zsolt
 */
public class Main {

    @EJB
    public static ProductHandlerRemote productHandlerInjected;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LookupExample lookupExample = new LookupExample();

        lookupExample.doStuff();

        List<Product> products = productHandlerInjected.findAll();

        System.out.println("\nInjected product handler returned:");

        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getClass().getCanonicalName());
        }
    }

}
