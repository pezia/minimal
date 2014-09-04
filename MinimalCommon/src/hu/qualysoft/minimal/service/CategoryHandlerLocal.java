package hu.qualysoft.minimal.service;

import hu.qualysoft.minimal.entity.Category;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zsolt
 */
@Local
public interface CategoryHandlerLocal {

    List<Category> findAll();

    Category findById(Long id);

}
