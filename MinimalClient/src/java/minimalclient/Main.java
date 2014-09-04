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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductHandlerRemote productHandler;
        
        try {
            InitialContext ic = new InitialContext();
            productHandler = (ProductHandlerRemote) ic.lookup("java:global/Minimal/Minimal-ejb/ProductHandler!hu.qualysoft.minimal.service.ProductHandlerRemote");
            
            List<Product> products = productHandler.findAll();
            for(Product product : products) {
                System.out.println(product.getName() + " " + product.getClass().getCanonicalName());
            }
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
