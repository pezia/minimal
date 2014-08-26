package hu.qualysoft.minimal.ejb;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author zsolt
 */

@Stateless
public class HelloEjb implements HelloEjbLocal {

    @Override
    public String createHello(String name) {
        StringBuilder sb = new StringBuilder("Hello ");

        sb.append(this.getName(name));

        sb.append("!");

        return sb.toString();
    }

    public String getName(String name) {
        if (name == null) {
            return "World";
        }

        return name;
    }
}
