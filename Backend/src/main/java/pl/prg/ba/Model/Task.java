package pl.prg.ba.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.prg.ba.Enums.Taks.TaskStatus;
@Entity
@Table(name = "tasks")
@Getter
@Setter

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private TaskStatus taskStatus;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
