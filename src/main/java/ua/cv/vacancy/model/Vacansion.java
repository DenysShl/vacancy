package ua.cv.vacancy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Department number should not be empty")
    private String department;

    @Column(name = "dyrekcija")
    @NotEmpty(message = "Dyrekcija number should not be empty")
    private String dyrekcija;

    @Column(name = "viddil")
    @NotEmpty(message = "Viddil number should not be empty")
    private String viddil;

    @Column(name = "posada")
    @NotEmpty(message = "Posada number should not be empty")
    private String posada;

    @Column(name = "quantity")
    @NotEmpty(message = "Quantity number should not be empty")
    @Min(value = 1, message = "Quantity should be min 1")
    private int count;

    @Column(name = "created_on")
    private LocalDateTime created_on;

    @Column(name = "status")
    private boolean status;
}