package com.eemrezcn.example.repository;

import com.eemrezcn.example.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository is a JPA specific extension of Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
    Role findByName(String name);
}