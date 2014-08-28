package hu.qualysoft.minimal.service;

import hu.qualysoft.minimal.entity.Category;
import hu.qualysoft.minimal.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zsolt
 */
@Stateless
public class ProductHandler implements ProductHandlerLocal {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Product> findByCategory(Category category) {
        return em
                .createNamedQuery(Product.QUERY_FIND_BY_CATEGORY_ID, Product.class)
                .setParameter("categoryId", category.getId())
                .getResultList();
    }

}
