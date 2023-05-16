package com.task.remindme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ReminderResponse {
    private String firstName;
    private String reminderDescription;
    private String reminderType;

    public ReminderResponse(String firstName, String reminderDescription) {
        this.firstName = firstName;
        this.reminderDescription = reminderDescription;
    }
}
