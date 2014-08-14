package hu.qualysoft.minimal;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloController {

    private String name = "World";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
