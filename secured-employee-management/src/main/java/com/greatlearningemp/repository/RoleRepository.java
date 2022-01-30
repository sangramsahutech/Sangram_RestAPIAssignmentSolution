package com.greatlearningemp.repository;

import org.springframework.stereotype.Repository;

import com.greatlearningemp.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
