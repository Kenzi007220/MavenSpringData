package example.domain;

import javax.persistence.*;
import javax.sound.midi.Sequence;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person")
public class Person {

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @NotNull
    @Column(name = "actor_id")
    private Long actor_id;


    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;


    ////////////////////////////


    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Long getActorId() {
        return actor_id;
    }

    public Person setActorId(Long actorId) {
        this.actor_id = actorId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}