package entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "User")
@Table(name = "User")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPass")
    private String userPass;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Egg> eggs = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Role> role = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", userName='" + getUserName() + '\'' +
                ", userPass='" + getUserPass() + '\'' +
                '}';
    }

    public void addRole(Role role){
        getRole().add(role);
    }
}
