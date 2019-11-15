package lvat.springbootsecurity01.module04.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Table(name = "roles")
@Entity
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<UserRole> userRoleList;


    public Role() {

    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
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

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public List<User> getUsers() {
        List<User> userList = new LinkedList<>();
        for (UserRole userRole : this.userRoleList) {
            userList.add(userRole.getUser());
        }
        return userList;
    }
}
