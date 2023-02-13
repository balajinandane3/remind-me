package com.task.remindme.service;

import com.task.remindme.entity.Reminder;
import com.task.remindme.repository.ReminderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public Reminder saveReminder(Reminder reminder) {
        log.info("Inside saveReminder () of ReminderService ");
        return reminderRepository.save(reminder);
    }

    public Reminder  findByReminderId(Long reminderId) {
        return reminderRepository.findByReminderId(reminderId);
    }

    public List<Reminder> findAllReminder() {
        return reminderRepository.findAll();
    }
}
