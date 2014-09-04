package hu.qualysoft.minimal.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author zsolt
 */
@Entity
//@DiscriminatorValue("instrument")
public class Instrument extends Product {
    
    @Column
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
