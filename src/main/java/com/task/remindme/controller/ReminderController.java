package com.task.remindme.controller;


import com.task.remindme.dto.ReminderRequest;
import com.task.remindme.dto.ReminderResponse;
import com.task.remindme.entity.Customer;
import com.task.remindme.entity.Reminder;
import com.task.remindme.exception.ReminderNotFoundException;
import com.task.remindme.repository.CustomerRepository;
//import com.task.remindme.service.UserService;
import com.task.remindme.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminders")
@Slf4j
public class ReminderController {

    @Autowired
    private CustomerService customerService;

   /* @Autowired
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
    }*/


    @PostMapping("/")
    public Customer placeOrder(@RequestBody ReminderRequest request){
        return customerService.saveCustomer(request.getCustomer());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findDepartmentById(@PathVariable("id") int id) throws Exception {
        Customer customer=customerService.findByCustomerId(id);
        if( customer==null){
            throw new ReminderNotFoundException("Reminder Id "+id+" Is not present");
        }
        return ResponseEntity.ok(customer);
    }
    @GetMapping("/")
    public List<Customer> findAllDepartment(){
        return customerService.findAllReminder();
    }
    @GetMapping("/getInfo")
    public List<ReminderResponse> getJoinInformation(){
        return customerService.getInfo();
    }

}
