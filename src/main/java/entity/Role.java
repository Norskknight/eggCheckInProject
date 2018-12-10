package entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "Role")
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "roleId", nullable = false)
    private int roleID;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "userName", referencedColumnName = "userName", nullable = false)
    private User user;

    @Override
    public String toString() {
        return name;
    }
}
