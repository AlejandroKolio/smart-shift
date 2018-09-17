package com.scheduler.app.smartshift;

import com.scheduler.app.smartshift.model.Account;
import com.scheduler.app.smartshift.model.Employee;
import com.scheduler.app.smartshift.model.Location;
import com.scheduler.app.smartshift.model.Role;
import com.scheduler.app.smartshift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@SpringBootApplication
public class SmartShiftApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SmartShiftApplication.class, args);
    }

    /**
     * Bootstrapping the database with dummy user.
     */
    @Bean
    public CommandLineRunner init() {
        return args -> {
            Account account =
                    Account.builder()
                            .username("tom.ford")
                            .password(passwordEncoder.encode("test"))
                            .enabled(true)
                            .credentialsNonExpired(true)
                            .lastLogin(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm:ss")))
                            .accountNonExpired(true)
                            .accountNonLocked(true)
                            .authorities(Collections.singletonList(Role.builder().authority("USER").build()))
                            .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm:ss")))
                            .employee(
                                    Employee.builder()
                                            .firstName("Tom")
                                            .lastName("Ford")
                                            .location(Location.builder().address("Los Angeles; Lane street 223").build())
                                            .build())
                            .build();

            Account accountByUsername = this.userRepository.findByUsername(account.getUsername());
            if (accountByUsername == null) {
                this.userRepository.save(account);
            }
        };
    }
}
