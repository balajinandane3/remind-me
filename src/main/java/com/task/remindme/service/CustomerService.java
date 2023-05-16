package com.task.remindme.service;

import com.task.remindme.dto.ReminderResponse;
import com.task.remindme.entity.Customer;
import com.task.remindme.entity.Reminder;
import com.task.remindme.repository.CustomerRepository;
import com.task.remindme.repository.ReminderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer saveCustomer(Customer customer) {
        log.info("Inside saveReminder () of ReminderService ");
        return customerRepository.save(customer);
    }

    public Customer  findByCustomerId(int id) {
        return customerRepository.findByCustomerId(id);
    }

    public List<Customer> findAllReminder() {
        return customerRepository.findAll();
    }

    public List<ReminderResponse>getInfo(){
        return customerRepository.getUserNameJoinReminderDecscription();
    }
}
