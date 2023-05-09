package com.task.remindme.controller;


import com.task.remindme.entity.Reminder;
import com.task.remindme.exception.ReminderExceptionController;
import com.task.remindme.exception.ReminderNotFoundException;
import com.task.remindme.service.ReminderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reminders")
@Slf4j
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping("/")
    public Reminder saveDepartment(@RequestBody Reminder reminder){
        log.info("Inside saveDepartment() of Department Controller"+reminder.toString());
        return reminderService.saveReminder(reminder);

    }
    @GetMapping("/{id}")
    public  ResponseEntity<Object> findDepartmentById(@PathVariable("id") Long reminderId) throws Exception {
        Reminder reminder=reminderService.findByReminderId(reminderId);
        if( reminder==null){
            throw new ReminderNotFoundException("Reminder Id "+reminderId+" Is not present");
        }
        return ResponseEntity.ok(reminder);
    }
    @GetMapping("/")
    public List<Reminder> findAllDepartment(){
        return reminderService.findAllReminder();
    }

}
