package com.demo.CT;

import com.demo.CT.SpringEmailDemo.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Customer_Product {


	public static void main(String[] args) {

		SpringApplication.run(Customer_Product.class, args);
	}



}
