package com.eemrezcn.example.repository;

import com.eemrezcn.example.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository is a JPA specific extension of Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}