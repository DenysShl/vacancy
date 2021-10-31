package ua.cv.vacancy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vacansions")
@Data
@NoArgsConstructor
public class Vacansion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "department")
    private String department;

    @Column(name = "dyrekcija")
    private String dyrekcija;

    @Column(name = "viddil")
    private String viddil;

    @Column(name = "posada")
    private String posada;

    @Column(name = "quantity")
    private int count;

    @Column(name = "created_on")
    private LocalDateTime created_on;

    @Column(name = "status")
    private boolean status;
}