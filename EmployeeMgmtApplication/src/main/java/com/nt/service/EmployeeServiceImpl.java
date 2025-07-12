package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Component
public class EmployeeServiceImpl implements IEmployeeService {
  
	@Autowired
	private IEmployeeRepo ier;

	@Override
	public List<Employee> showAllEmp() {
		List<Employee> list = ier.findAll();
		return list;
	}

	@Override
	public String addEmployee(Employee emp) {
		try
		{
        		Employee emp1=ier.save(emp);
		         return  "Employee Saved With The Id Value "+emp1.getEmpId();
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
		
	}

	@Override
	public Employee editEmpById(Integer id) {
		Employee emp = ier.findById(id).orElseThrow(()-> new IllegalArgumentException());
	    return emp;
	}

	@Override
	public String updatedEmployee(Employee emp) {
		Optional<Employee> op = ier.findById(emp.getEmpId());
		if(op.isPresent())
		{
		     Integer id = ier.save(emp).getEmpId();
		     return "employee updated with the id value "+id;
		}
		return "Employee is not found in database";
	}

	@Override
	public String deleteEmpById(Integer id) {
		Optional<Employee> op = ier.findById(id);
		if(op.isPresent())
		{
			ier.deleteById(id);
			return "Employee Deleted By The Given Id "+id;
		}
		return "Employee Not Found In DataBase";
	}

	@Override
	public List<Employee> findAllEmpByDynamically(Employee emp) {
			if(emp.getEmpName().isBlank())
			{
				emp.setEmpName(null);
			}
			if(emp.getEmpDesg().isBlank())
			{
				emp.setEmpDesg(null);
			}
			if(emp.getEmpAddrs().isBlank())
			{
				emp.setEmpAddrs(null);
			}
			
			Example  ex = Example.of(emp);
			List<Employee> empList = ier.findAll(ex);
		   return empList;
	}
	
	

}
