package app.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "all_roles")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "id", scope     = Integer.class)
public class RoleEntity implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    public RoleEntity(){}

    public RoleEntity(String roleName){
        this();
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return roleName;
    }

    public void setName(String name) {
        this.roleName = name;
    }
/*
    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public void addUser(UserEntity user) {
        users.add(user);
    }
*/
    @Override
    public String getAuthority() {
        return null;
    }
}
