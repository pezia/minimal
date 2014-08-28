package hu.qualysoft.minimal.service;

import hu.qualysoft.minimal.entity.Category;
import hu.qualysoft.minimal.entity.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zsolt
 */
@Local
public interface ProductHandlerLocal {

    List<Product> findByCategory(Category category);

}
