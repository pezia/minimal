package hu.qualysoft.minimal.service;

import hu.qualysoft.minimal.entity.Category;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.interceptor.Interceptor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zsolt
 */
@Stateless
public class CategoryHandler implements CategoryHandlerLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    @RolesAllowed({"user"})
    public List<Category> findAll() {
        return em.createNamedQuery(Category.QUERY_FIND_ALL, Category.class).getResultList();
    }

    @Override
    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

}
