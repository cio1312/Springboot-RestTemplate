package com.spring.service;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.spring.constants.DepartmentConstants;
import com.spring.entity.Department;

@Service
public class RestTemplateService {

	private static final String GET_ALL_DEPARTMENTS = "http://localhost:8082/departments/";
	private static final String ADD_DEPARTMENT = "http://localhost:8082/add/";
	private static final String FIND_DEPARTMENT = "http://localhost:8082/getOnId/{id}";
	private static final String UPDATE_DEPARTMENT = "http://localhost:8082/update/{id}";
	private static final String DELETE_DEPARTMENT = "http://localhost:8082/delete/{id}";

	RestTemplate resttemp = new RestTemplate(); // predefined class

	// FindALL
	public ResponseEntity<String> allDepartments() {

		HttpHeaders header = new HttpHeaders(); // setting different parameters of header
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// header.add("Authorization", headervalue); // if you have authorizaton

		HttpEntity<String> entity = new HttpEntity<String>("parameters", header);

		ResponseEntity<String> response = resttemp.exchange(GET_ALL_DEPARTMENTS, HttpMethod.GET, entity, String.class);

		return response;

	}

	// create
	public ResponseEntity<Department> addNewDepartment(Department dept) {
		// URL //Request // expect response
		return resttemp.postForEntity(ADD_DEPARTMENT, dept, Department.class); // we could use exchange method too

	}

	// Get Single Entity
	public Department GetDeptById(Long departmentId) {
		Map<String, Long> param = new HashMap<String, Long>();
		param.put("id", departmentId);
		return resttemp.getForObject(FIND_DEPARTMENT, Department.class, param);

	}

	public void UpdateDept(Department department, Long departmentId) {
		
        Map < String, Long > params = new HashMap < String, Long > ();
        params.put("id", departmentId);

        resttemp.put(UPDATE_DEPARTMENT, department, params);
    	System.out.println("UPDATE SUCCESSFUL");
    	

	}

	// delete
	public String Deletedept(Long deptID) {

		
	     Map < String, Long > params = new HashMap < String, Long > ();
	        params.put("id", deptID);
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.delete(DELETE_DEPARTMENT, params);
	        System.out.println("DELETE SUCCESSFUL");
	        return "Delete Success";
		

	}

}
