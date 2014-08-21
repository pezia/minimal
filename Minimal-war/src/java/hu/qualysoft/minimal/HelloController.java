package hu.qualysoft.minimal;

import hu.qualysoft.minimal.ejb.HelloEjbLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloController {
    
    @EJB
    HelloEjbLocal helloEjb;

    private String name = "World";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = helloEjb.createHello(name);
    }
}
