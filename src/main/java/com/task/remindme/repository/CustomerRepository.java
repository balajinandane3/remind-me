package com.task.remindme.repository;

import com.task.remindme.dto.ReminderResponse;
import com.task.remindme.entity.Customer;
import com.task.remindme.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByCustomerId(int id);


    @Query("SELECT new com.task.remindme.dto.ReminderResponse (u.name,r.reminderDescription) from Customer u JOIN u.reminders r")
    public List<ReminderResponse> getUserNameJoinReminderDecscription();
}
