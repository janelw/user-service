package com.user.user.model;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

@Entity
@Table(name = "tasks")
public class tasks {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "task_sequence", schema = "task_sequence")
    @Column(name = "task_id")
    private int task_id;
    @Column(name = "task")
    private String task;
    @Column(name = "status")
    private String status;



    public tasks() {
    }

    public tasks(int task_id, String task, String status) {
        this.task_id = task_id;
        this.task = task;
        this.status = status;
    }

    public int getTask_id() {
        return this.task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask() {
        return this.task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public tasks task_id(int task_id) {
        this.task_id = task_id;
        return this;
    }

    public tasks task(String task) {
        this.task = task;
        return this;
    }

    public tasks status(String status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof tasks)) {
            return false;
        }
        tasks tasks = (tasks) o;
        return task_id == tasks.task_id && Objects.equals(task, tasks.task) && Objects.equals(status, tasks.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task_id, task, status);
    }

    @Override
    public String toString() {
        return "{" +
            " task_id='" + getTask_id() + "'" +
            ", task='" + getTask() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }


}
