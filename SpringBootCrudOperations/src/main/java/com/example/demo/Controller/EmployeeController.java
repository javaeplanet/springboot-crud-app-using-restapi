package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmployeeService;
import com.example.demo.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {

		Integer id = empService.saveEmployee(emp);
		return new ResponseEntity<String>("Employee '" + id + "'saved", HttpStatus.OK);
	}

	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = empService.getEmployees();

		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

	}

	@GetMapping("/getOne/{empId}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable("empId") Integer empId) {
		Employee emp = empService.getEmployeeById(empId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmployee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Integer empId) {
		empService.deleteEmployee(empId);
		return new ResponseEntity<String>("Employee with" + empId + "deleted", HttpStatus.OK);
	}

	@PutMapping("/updateEmployee/{empId}")
	public ResponseEntity<String> updateEmployee( @PathVariable ("empId") Integer empId,@RequestBody Employee emp){
		Employee oneEmp = empService.getEmployeeById(empId);
		oneEmp.setEmpName(emp.getEmpName());
		oneEmp.setEmpSal(emp.getEmpSal());
		oneEmp.setEmpAddress(emp.getEmpAddress());
		empService.saveEmployee(oneEmp);
		
		return new ResponseEntity<String>("Employee with"+empId+"has been updated",HttpStatus.OK);
		
		
	}

}
