package com.task.remindme.controller;


import com.task.remindme.dto.ReminderRequest;
import com.task.remindme.dto.ReminderResponse;
import com.task.remindme.entity.Customer;
import com.task.remindme.entity.Reminder;
import com.task.remindme.exception.CustomerNotFoundException;
//import com.task.remindme.service.UserService;
import com.task.remindme.exception.ReminderNotFoundException;
import com.task.remindme.service.CustomerService;
import com.task.remindme.service.ReminderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@Slf4j
public class ReminderController {
    Logger logger = LoggerFactory.getLogger(ReminderController.class);

    @Autowired
    private CustomerService customerService;

   @Autowired
    private ReminderService reminderService;

    @PostMapping("/reminder/")
    public Reminder addReminder(@RequestBody Reminder reminder){
        log.info("Inside saveDepartment() of Department Controller"+reminder.toString());
        return reminderService.saveReminder(reminder);

    }
    @GetMapping("reminder/{id}")
    public  ResponseEntity<Object> findReminderById(@PathVariable("id") int reminderId) throws Exception {
        Optional<Reminder> reminder=reminderService.findByReminderId(reminderId);
        if( reminder==null){
            throw new ReminderNotFoundException("Reminder Id "+reminderId+" Is not present");
        }
        return ResponseEntity.ok(reminder);
    }
    @GetMapping("/reminder")
    public List<Reminder> findAllDepartment(){
        return reminderService.findAllReminder();
    }


    @PostMapping("customer")
    public Customer addCustomer(@RequestBody ReminderRequest request){
        logger.info("Inside addCustomer()....{}",request.toString());
        return customerService.saveCustomer(request.getCustomer());
    }
    @GetMapping("customer/{id}")
    public ResponseEntity<Object> findCustomerById(@PathVariable("id") int id) throws Exception {
        Customer customer=customerService.findByCustomerId(id);
        if( customer==null){
            throw new CustomerNotFoundException("Customer Id "+id+" Is not present");
        }
        return ResponseEntity.ok(customer);
    }
    @GetMapping("customer/")
    public List<Customer> findAllCustomer(){
        return customerService.findAllCustomer();
    }
    @GetMapping("/getInfo")
    public List<ReminderResponse> getJoinInformation(){
        return customerService.getInfo();
    }

}
