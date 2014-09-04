package minimalclient;

import hu.qualysoft.minimal.entity.Product;
import hu.qualysoft.minimal.service.ProductHandlerRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author zsolt
 */
public class LookupExample {

    public void doStuff() {
        ProductHandlerRemote productHandlerLookedUp;

        try {
            InitialContext ic = new InitialContext();
            productHandlerLookedUp = (ProductHandlerRemote) ic.lookup("java:global/Minimal/Minimal-ejb/ProductHandler!hu.qualysoft.minimal.service.ProductHandlerRemote");

            List<Product> products = productHandlerLookedUp.findAll();

            System.out.println("Looked up product handler returned:");
            for (Product product : products) {
                System.out.println(product.getName() + " " + product.getClass().getCanonicalName());
            }
        } catch (NamingException ex) {
            Logger.getLogger(LookupExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
