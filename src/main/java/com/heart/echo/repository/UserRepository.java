package com.heart.echo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heart.echo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}