package pl.prg.ba.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.prg.ba.enums.task.TaskStatus;
@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
