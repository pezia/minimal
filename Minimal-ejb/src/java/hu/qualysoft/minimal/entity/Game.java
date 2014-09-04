package hu.qualysoft.minimal.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author zsolt
 */
@Entity
//@DiscriminatorValue(value = "game")
public class Game extends Product {

    @Column(nullable = true)
    private int ageFrom;

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }
}
