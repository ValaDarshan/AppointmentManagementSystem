package com.apointmentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apointmentManagementSystem.entity.BlockedUser;

public interface IBlockedUserRepository extends JpaRepository<BlockedUser, Integer> {

}
