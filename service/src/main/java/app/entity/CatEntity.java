package app.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cats")
public class CatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer id;

    @Column(name="cat_name")
    private String name;

    @Column(name = "cat_birthday")
    private LocalDate dateOfBirth;

    @Column(name="cat_family")
    private String family;

    @Column(name = "cat_color")
    private String color;

    @OneToOne
    @JoinColumn(name = "cat_owner_id")
    private OwnerEntity owner;


    public CatEntity() {
    }

    public CatEntity(Integer id, String name, String family, String color, LocalDate dateOfBirth, OwnerEntity owner) {
        this();
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.family = family;
        this.color = color;
        this.owner = owner;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getOwnerId() {
        return owner.getId();
    }
}
