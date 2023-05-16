package com.task.remindme.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reminder {
    @Id
    private int reminderId;
    private String reminderDescription;
    private String reminderFrequency;
    private String reminderType;
    private String reminderStatus;

}
