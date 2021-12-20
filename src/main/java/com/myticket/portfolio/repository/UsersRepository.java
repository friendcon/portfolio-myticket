package com.myticket.portfolio.repository;

import com.myticket.portfolio.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsByUserId(String userId);
}
