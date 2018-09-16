package com.scheduler.app.smartshift;

import com.scheduler.app.smartshift.model.Account;
import com.scheduler.app.smartshift.model.Employee;
import com.scheduler.app.smartshift.model.Location;
import com.scheduler.app.smartshift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SmartShiftApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SmartShiftApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Account account =
                    Account.builder()
                            .accountNonExpired(true)
                            .accountNonLocked(true)
                            .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm:ss")))
                            .employee(Employee.builder()
                                            .firstName("Tom")
                                            .lastName("Ford")
                                            .location(Location.builder().address("Los Angeles; Lane street 223").build())
                                            .build())
                            .build();

            Account accountByUsername = this.userRepository.findByUsername(account.getUsername());
            if(accountByUsername == null) {
                this.userRepository.save(account);
            }
        };
    }
}
