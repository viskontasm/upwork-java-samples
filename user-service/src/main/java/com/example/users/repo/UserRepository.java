package com.example.users.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.users.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}