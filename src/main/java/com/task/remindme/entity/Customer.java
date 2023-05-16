package com.task.remindme.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int customerId;
    private String name;
    private String email;
    private String gender;
    @OneToMany(targetEntity = Reminder.class,cascade = CascadeType.ALL)
    @JoinColumn(name="cr_fk",referencedColumnName = "customerId")
    private List<Reminder> reminders;
}
