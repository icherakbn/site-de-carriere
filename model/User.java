package ma.enset.careerwebsite.model;

import ma.enset.careerwebsite.model.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user",uniqueConstraints = @UniqueConstraint(columnNames = "username"))

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name ="password")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(
                    name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name="role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User(Long id, String username, String password, Collection<Role> roles) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(String username, String password, Collection<Role> roles) {
        //zdt hadi ela jal hadik samta -_-
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

}
