package app.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity//(name = "UserEntity")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "user_roles")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "id", scope     = Integer.class)
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_owner_id")
    private Integer ownerId;

    @Column(name = "user_login")
    private String userName;

    @Column(name = "user_password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<RoleEntity> roles;

    public UserEntity(){}

    public UserEntity(Integer ownerId, String userName, String password){
        this();
        this.ownerId = ownerId;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void addRole(RoleEntity role) {
        //role.addUser(this);
        roles.add(role);
    }

    public Integer getOwnerId(){
        return this.ownerId;
    }

    public void setOwnerId(Integer ownerId){
        this.ownerId = ownerId;
    }

    public Integer getId(){
        return this.id;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
