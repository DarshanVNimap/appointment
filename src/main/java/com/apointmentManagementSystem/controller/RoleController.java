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
import com.apointmentManagementSystem.service.RoleService;
import com.apointmentManagementSystem.utils.SuccessMessageConstant;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping
	public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto, @RequestAttribute("X-user-id") int loggedUserId) {
		try {
			
			return ResponseEntity
					.ok(new MessageResponseDto(SuccessMessageConstant.USER_ADDED, roleService.addRole(roleDto, loggedUserId) ,200));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessageResponseDto(e.getMessage(), 400));
		}		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllRole() {
		try {
			
			return ResponseEntity
					.ok(new MessageResponseDto(SuccessMessageConstant.USER_ADDED, roleService.getAllRoles() ,200));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessageResponseDto(e.getMessage(), 400));
		}
	}

	@PutMapping("/{roleId}")
	public ResponseEntity<?> updateRole(@PathVariable(name = "roleId") int roleId, @RequestBody RoleDto roleDto,
			@RequestAttribute("X-user-id") int loggedUserId) {
		try {
			
			return ResponseEntity
					.ok(new MessageResponseDto(SuccessMessageConstant.USER_ADDED, roleService.updateRole(roleId, roleDto, loggedUserId) ,200));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessageResponseDto(e.getMessage(), 400));
		}
	}

	@DeleteMapping("/{roleId}")
	public ResponseEntity<?> deleteRole(@PathVariable(name = "roleId") int roleId , @RequestAttribute("X-user-id") int loggedUserId) {
		try {
			roleService.deleteRole(roleId, loggedUserId);
			return ResponseEntity
					.ok(new MessageResponseDto(SuccessMessageConstant.USER_ADDED, null ,200));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessageResponseDto(e.getMessage(), 400));
		}
	}

}
