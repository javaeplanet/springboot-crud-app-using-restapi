package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.EmployeeNotFoundException;
import com.example.demo.entity.Employee;
import com.example.demo.repos.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repos;

	@Override
	public int saveEmployee(Employee emp) {
		return repos.save(emp).getEmpId();
	}

	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) repos.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Optional<Employee> opt = repos.findById(empId);
		Employee emp = opt.orElseThrow(() -> new EmployeeNotFoundException("Employee " + empId + "not found"));

		return emp;
	}

//	@Override
//	public void updateEmployee(Employee emp) {
//		repos.save(emp).getEmpId();
//	}

	@Override
	public void deleteEmployee(Integer empId) {
		Employee emp = getEmployeeById(empId);
		repos.delete(emp);

	}

}
