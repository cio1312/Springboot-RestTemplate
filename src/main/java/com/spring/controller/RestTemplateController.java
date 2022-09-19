package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Department;
import com.spring.service.RestTemplateService;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {

	@Autowired
	private RestTemplateService restTemplateService;

	@GetMapping("/getallDepartments")
	public ResponseEntity<String> getalldepartments() {

		return restTemplateService.allDepartments();

	}
	
	
	@PostMapping("AddDepartment")
	public ResponseEntity<Department> Adddepartments(@RequestBody Department dept) {

		return restTemplateService.addNewDepartment(dept);

	}
	
	@GetMapping("findDept/{id}")
	public Department getDeptById(@PathVariable("id") Long departmentId) {

		return restTemplateService.GetDeptById(departmentId);

	}
	
	
	@PutMapping("update/{id}")
	public void UpdateDept(@RequestBody Department department, @PathVariable("id") Long departmentId) {

		restTemplateService.UpdateDept(department,departmentId);

	}
	
	
	@DeleteMapping("deleteDept/{id}")
	public String deletingdept(@PathVariable("id") Long departmentId) {

		return restTemplateService.Deletedept(departmentId);

	}
	
	

}
