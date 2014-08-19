package hu.qualysoft.minimal.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author zsolt
 */
@ApplicationPath("/rest")
public class HelloRest extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classSet = new HashSet<>();

        classSet.add(Hello.class);

        return classSet;
    }

}
