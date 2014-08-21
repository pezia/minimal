package hu.qualysoft.minimal.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author zsolt
 */
@Stateless
@Szia
public class SziaEjb implements HelloEjbLocal {

    @Override
    public String createHello(String name) {
        StringBuilder sb = new StringBuilder("Szia ");

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
