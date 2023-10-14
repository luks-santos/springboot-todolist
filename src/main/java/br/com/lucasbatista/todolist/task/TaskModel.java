package br.com.lucasbatista.todolist.task;

import br.com.lucasbatista.todolist.user.UserModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "tasks_id")
    private UUID id;

    @Column(name = "tasks_description")
    private String description;

    @Column(name = "tasks_title", length = 50)
    private String title;

    @Column(name = "tasks_start_at")
    private LocalDateTime startAt;

    @Column(name = "tasks_end_at")
    private LocalDateTime endAt;

    @Column(name = "tasks_priority")
    private String priority;

    private UUID idUser;

    @CreationTimestamp
    @Column(name = "tasks_created_at")
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception {
        if(title.length() > 50) {
            throw new Exception("O campo title deve conter no máximo 50 caracteres");
        }
        this.title = title;
    }
}
