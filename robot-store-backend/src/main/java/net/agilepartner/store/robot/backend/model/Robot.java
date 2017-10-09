package net.agilepartner.store.robot.backend.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Robot entity.
 */
@Entity
@Table(name = "ROBOT")
public class Robot implements Serializable {

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (!id.equals(robot.id)) return false;
        return name.equals(robot.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
