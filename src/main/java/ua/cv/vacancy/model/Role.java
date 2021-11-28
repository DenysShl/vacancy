package ua.cv.vacancy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @version 1.0
 * @autor shd
 * @created 28/11/2021 - 10:15
 * @project vacancy
 * -
 */
@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nameRole;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
