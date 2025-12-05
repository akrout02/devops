package tn.esprit.studentmanagement.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String address;

    // ATTENTION : Cette ligne DOIT être modifiée.
    // L'ajout de CascadeType.PERSIST permet la création du département
    // en même temps que l'étudiant.
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Department department;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
}
