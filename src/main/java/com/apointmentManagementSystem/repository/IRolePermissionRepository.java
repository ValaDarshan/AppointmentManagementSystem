package com.apointmentManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.apointmentManagementSystem.entity.RolePermission;

public interface IRolePermissionRepository extends JpaRepository<RolePermission, Integer> {

	List<RolePermission> findAllByRoleIdAndIsActiveTrue(int roleId);

	@Modifying
	@Query(value = "update role_permission rp set is_active=false where rp.role_id=:roleId", nativeQuery = true)
	void deleteByRoleId(int roleId , int loggedUser);

	boolean existsByRoleIdAndPermissionIdAndIsActiveTrue(int roleId, int permissionId);

}
