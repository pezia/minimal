package hu.qualysoft.minimal;

import hu.qualysoft.minimal.ejb.HelloEjbLocal;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class HelloController {

    @Inject
    HelloEjbLocal helloEjb;

    private String name = "World";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = helloEjb.createHello(name);
    }
}
