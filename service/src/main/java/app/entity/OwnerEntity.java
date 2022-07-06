package app.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Integer id;

    @Column(name="owner_name")
    private String name;

    @Column(name = "owner_birthday")
    private LocalDate dateOfBirth;

    public OwnerEntity() {
    }

    public OwnerEntity(String owner_name, LocalDate dateOfBirth) {
        this();
        this.name = owner_name;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
