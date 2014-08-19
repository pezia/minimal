package hu.qualysoft.minimal.rest;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsolt
 */
@XmlRootElement(name = "vilag")
public class World {

    private String name;
    
    public World() {
        this("Hello");
    }
    
    public World(String name) {
        this.name = name;
    }

    @XmlElement(name = "nev")
    public String getName() {
        return name;
    }

   public void setName(String name) {
        this.name = name;
    }
}
