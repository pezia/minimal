package hu.qualysoft.minimal.ejb;

import javax.ejb.Local;

/**
 *
 * @author zsolt
 */
@Local
public interface HelloEjbLocal {

    String createHello(String name);

}
