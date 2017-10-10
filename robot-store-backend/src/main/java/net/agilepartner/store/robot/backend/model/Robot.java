package net.agilepartner.store.robot.backend.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Robot entity.
 */
@Entity
@Table(name = "ROBOT")
public class Robot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = " price", nullable = false)
    private Integer price;

    /**
     * Getter for the id.
     *
     * @return a Long
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for the id.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for the name.
     *
     * @return a String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of the price.
     *
     * @return an int
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Setter for the price.
     *
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (!id.equals(robot.id)) return false;
        if (!name.equals(robot.name)) return false;
        return price.equals(robot.price);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
