package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired	
	private IEmployeeService ies;
	
	
     @GetMapping("/") 
	  public String home()
	  {
		  return "welcome"; 
	  }
	  
	  @GetMapping("/report") 
	  public String showAllEmp(Map<String,Object>map,@ModelAttribute("employee") Employee employee) 
	  {
		  try {
	                List<Employee> list = ies.showAllEmp();
	                map.put("empList", list);
	                return "show_all_emp"; 
		  }
		  catch(Exception ex)
		  {
			    map.put("msg",ex.getMessage());
			    return "error_page";
		  }
	     }
	  
	  @GetMapping("/register")
	  public String registerEmp(@ModelAttribute("emp") Employee emp)
	  {
		  return "add_emp_page";
	  }
	  
	  @PostMapping("/register")
	  public String addEmp(RedirectAttributes attrs,@ModelAttribute Employee emp)
	  {
		  try 
		  {
		     String msg1 = ies.addEmployee(emp);
		     attrs.addFlashAttribute("msg",msg1);
		     return "redirect:report";
		  }
		  catch(Exception ex)
		  {
			     attrs.addFlashAttribute("msg",ex.getMessage());
			    return "error_page";
		  }
	  }
	  
	  @GetMapping("/edit")
	  public String editEmployeeById(@RequestParam("empId") Integer empId,@ModelAttribute("emp") Employee emp)
	  {
			  Employee emp1 = ies.editEmpById(empId);
			  BeanUtils.copyProperties(emp1, emp);
		      return "update_form_page";  
	  }
	 
	  @PostMapping("/edit")
	  public String updateEmpById(RedirectAttributes attrs , @ModelAttribute("emp") Employee emp)
	  {
		      try
		      {
		           String msg = ies.updatedEmployee(emp);
		           attrs.addFlashAttribute("msg", msg);
		           return "redirect:report";
		      }
			  catch(Exception ex)
			  {
				    return "error_page";
			  }
	  }
	  
	  @GetMapping("/delete")
	  public String deleteEmployeeById(@RequestParam("empId") Integer empId,RedirectAttributes attrs)
	  {
		  String msg = ies.deleteEmpById(empId);
		  attrs.addFlashAttribute("msg",msg);
		  return "redirect:report";
	  }
	  
	  @GetMapping("/search")
	  public String searchEmpDynamicallyFormPage(@ModelAttribute ("employee") Employee employee) 
	  {
		  return "search_form_page";
	  }
	  
	  @PostMapping("/search")
	  public String SearchEmpByDynamically(@ModelAttribute ("employee") Employee employee,Map<String,Object>map)
	  {
		  try
		  {
		           List<Employee> empList = ies.findAllEmpByDynamically(employee);
                   map.put("empList", empList);
                   return "show_all_emp";
		  }
		  catch(Exception ex)
		  {
			    map.put("msg",ex.getMessage());
			    return "error_page";
		  }
	  }
}
