package com.task.remindme.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reminder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long reminderId;
    private String reminderDescription;
    private String reminderFrequency;
    private String reminderType;
    private String reminderStatus;

}
