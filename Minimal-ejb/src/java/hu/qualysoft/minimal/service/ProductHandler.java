package hu.qualysoft.minimal.service;

import hu.qualysoft.minimal.entity.Category;
import hu.qualysoft.minimal.entity.Game;
import hu.qualysoft.minimal.entity.Instrument;
import hu.qualysoft.minimal.entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zsolt
 */
@Stateless
public class ProductHandler implements ProductHandlerLocal, ProductHandlerRemote {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Product> findByCategory(Category category) {
        return em
                .createNamedQuery(Product.QUERY_FIND_BY_CATEGORY_ID, Product.class)
                .setParameter("categoryId", category.getId())
                .getResultList();
    }

    @Override
    public List<Product> addTestData() {
        List<Product> addedProducts = new ArrayList<>();
        
        Category category = em.find(Category.class, new Long(1L));
        
        Game game = new Game();
        game.setName("Game 1");
        game.setDescription("Game");
        game.setPrice(new BigDecimal(123));
        game.setAgeFrom(12);
        game.setCategory(category);
        
        Instrument instrument = new Instrument();
        instrument.setName("Instrument 1");
        instrument.setDescription("Instrument");
        instrument.setPrice(new BigDecimal(1230));
        instrument.setMaterial("Brass");
        instrument.setCategory(category);
        
        em.persist(game);
        em.persist(instrument);
        em.flush();
        
        addedProducts.add(game);
        addedProducts.add(instrument);
        
        return addedProducts;
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

}
