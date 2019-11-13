package lvat.springbootsecurity01.module03.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "name", length = 60)
    private RoleName name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            uniqueConstraints = {@UniqueConstraint(name = "UQ_role_id_user_id", columnNames = {"role_id", "user_id"})})
    private List<Role> roles = new LinkedList<>();

    public Role() {

    }

    public Role(RoleName name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public enum RoleName {
        ROLE_USER,
        ROLE_ADMIN
    }
}
