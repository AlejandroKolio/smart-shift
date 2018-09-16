package com.scheduler.app.smartshift.repository;

import com.scheduler.app.smartshift.model.Account;
import com.scheduler.app.smartshift.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alexander Shakhov.
 * User: alexandershakhov
 * Date: 09 Сентябрь 2018
 * Time: 14:35
 */
public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

    Account findByAuthorities(Role... role);

}
