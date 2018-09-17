package com.scheduler.app.smartshift.service;

import com.scheduler.app.smartshift.model.Account;
import com.scheduler.app.smartshift.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Alexander Shakhov.
 * <p>
 * User: alexandershakhov
 * <p>
 * Date: 17 Сентябрь 2018
 * <p>
 * Time: 22:04
 */
@Service
public class AccountDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AccountDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account accountByUsername = this.userRepository.findByUsername(username);
        if (accountByUsername == null) {
            throw new UsernameNotFoundException(username);
        }
        return accountByUsername;
    }
}
