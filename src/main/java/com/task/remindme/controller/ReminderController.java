package com.task.remindme.controller;


import com.task.remindme.entity.Reminder;
import com.task.remindme.service.ReminderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Reminder findDepartmentById(@PathVariable("id") Long reminderId) throws Exception {
        return reminderService.findByReminderId(reminderId);
    }
    @GetMapping("/")
    public List<Reminder> findAllDepartment(){
        return reminderService.findAllReminder();
    }

}
