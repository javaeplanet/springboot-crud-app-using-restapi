package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Employee;


public interface EmployeeService {
public int saveEmployee(Employee emp);
public List<Employee> getEmployees();
public Employee getEmployeeById(Integer empId);
//public void updateEmployee(Employee emp);
public void deleteEmployee(Integer empId);

}
