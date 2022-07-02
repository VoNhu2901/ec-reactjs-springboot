package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    Optional<Role> findRolesByRoleName(String roleName);

}
