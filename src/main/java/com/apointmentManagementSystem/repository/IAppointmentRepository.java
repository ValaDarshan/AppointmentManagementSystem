package com.apointmentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apointmentManagementSystem.entity.AppointmentEntity;

public interface IAppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {

}
