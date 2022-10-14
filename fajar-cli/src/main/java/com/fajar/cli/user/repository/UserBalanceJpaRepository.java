package com.fajar.cli.user.repository;

import com.fajar.cli.user.model.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBalanceJpaRepository extends JpaRepository<UserBalance, Long> {

}
