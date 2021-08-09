package com.denamyte.example.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressesConfig {

    @Bean("green")  // The name of the bean is "green"
    public String greenAddress() {
        return "Green Street, 102";
    }

    @Bean("red")  // The name of the bean is "red"
    public String redAddress() {
        return "Red Street, 30";
    }

    @Bean  // The name of the bean is "yellowStreet"
    public String yellowAddress() {
        return "Yellow Street, 230";
    }

    @Bean("with_autowire")
    public Customer customer1(@Autowired @Qualifier("green") String address) {
        Customer customer = new Customer("Clara Foster", address);
//        System.out.println(customer);
        return customer;
    }

    @Bean("no_autowire")
    public Customer customer2(@Qualifier("red") String address) {
        Customer customer = new Customer("Ken Abend", address);
//        System.out.println(customer);
        return customer;
    }

    @Bean
    public Customer yellowCustomer(@Qualifier("yellowAddress") String address) {
        Customer customer = new Customer("Carl Binner", address);
//        System.out.println(customer);
        return customer;
    }

    @Bean
    public Customer temporary(@Qualifier("yellowCustomer") Customer customer) {
        System.out.println(customer);
        return customer;
    }
}
