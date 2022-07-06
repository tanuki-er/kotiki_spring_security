package app.entity;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class FriendsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendship_id")
    private Integer id;

    @Column(name = "first_cat_id")
    private Integer id1;

    @Column(name = "second_cat_id")
    private Integer id2;

    public FriendsEntity() {
    }

    public FriendsEntity(Integer id1, Integer id2) {
        this();
        this.id1 = id1;
        this.id2 = id2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public Integer getId2() {
        return id2;
    }

    public void setId2(Integer id2) {
        this.id2 = id2;
    }
}
