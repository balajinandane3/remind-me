package com.task.remindme.service;

import com.task.remindme.entity.Reminder;
import com.task.remindme.repository.ReminderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ReminderService {
    private String serviceName;

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    public ReminderService(@Value("${service.name}") final String serviceName) {
        this.serviceName = serviceName;
    }

    public Reminder saveReminder(Reminder reminder) {
        log.info("Inside saveReminder () of ReminderService ");
        return reminderRepository.save(reminder);
    }

    public Optional<Reminder> findByReminderId(int reminderId) {
        return reminderRepository.findById(reminderId);
    }

    public List<Reminder> findAllReminder() {
        return reminderRepository.findAll();
    }
}
