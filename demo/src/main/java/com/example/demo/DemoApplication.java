package com.example.demo;

import com.example.demo.entities.Customer;
import com.example.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepo customerRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepo.save(new Customer(null,"ElHoussine","44 Stanford street","+212_12_12_88_90",new Date()));
        customerRepo.save(new Customer(null,"Ahmed","43 Stanford street","+212_12_12_88_90",new Date()));
        customerRepo.save(new Customer(null,"yassine","40 Stanford street","+212_12_12_88_90",new Date()));

    }
}
