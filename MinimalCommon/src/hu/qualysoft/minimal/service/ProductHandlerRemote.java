package hu.qualysoft.minimal.service;

import hu.qualysoft.minimal.entity.Category;
import hu.qualysoft.minimal.entity.Product;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author zsolt
 */
@Remote
public interface ProductHandlerRemote {
    List<Product> findByCategory(Category category);
    List<Product> findAll();
}
