package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeService {
public List<Employee> showAllEmp();
public String addEmployee(Employee emp);
public Employee editEmpById(Integer id);
public String updatedEmployee(Employee emp);
public String deleteEmpById(Integer Id);
public List<Employee> findAllEmpByDynamically(Employee emp);
}
