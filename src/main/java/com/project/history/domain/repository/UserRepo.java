package com.project.history.domain.repository;

import com.project.history.domain.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
