package com.apointmentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apointmentManagementSystem.dto.ErrorMessageResponseDto;
import com.apointmentManagementSystem.dto.MessageResponseDto;
import com.apointmentManagementSystem.dto.RoleDto;
import com.apointmentManagementSystem.dto.RolePermissionDto;
import com.apointmentManagementSystem.service.RolePermissionService;
import com.apointmentManagementSystem.utils.SuccessMessageConstant;

@RestController
@RequestMapping("/role-permission")
public class RolePermissionController {
	
	@Autowired
	private RolePermissionService rolePemissionService;
	
	
	@PostMapping
	public ResponseEntity<?> assignPermissionToRole(@RequestBody RolePermissionDto rolePermissionDto , @RequestAttribute("X-user-id") int loggedInUser) {
		try {
			rolePemissionService.assignPermissionToRole(rolePermissionDto, loggedInUser) ;
			return ResponseEntity
					.ok(new MessageResponseDto(SuccessMessageConstant.ROLE_FETCHED, null,200));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessageResponseDto(e.getMessage(), 400));
		}
	}

	@GetMapping("/role/{roleId}")
	public ResponseEntity<?> getAllPermissionOfRole(@PathVariable(name = "roleId") int roleId ) {
		try {
			
			return ResponseEntity
					.ok(new MessageResponseDto(SuccessMessageConstant.ROLE_UPDATED, rolePemissionService.getAllPermissionOfRole(roleId) ,200));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessageResponseDto(e.getMessage(), 400));
		}
	}

	@DeleteMapping("/role/{roleId}/permission/{permissionId}")
	public ResponseEntity<?> removePermissionFromRole(@PathVariable(name = "roleId") int roleId, @PathVariable(name = "permissionId") int permissionId , @RequestAttribute("X-user-id") int loggedInUser) {
		try {
			rolePemissionService.removePermissionFromRole(permissionId, roleId, loggedInUser);
			return ResponseEntity
					.ok(new MessageResponseDto(SuccessMessageConstant.ROLE_DELETED, null ,200));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessageResponseDto(e.getMessage(), 400));
		}
	}

}
