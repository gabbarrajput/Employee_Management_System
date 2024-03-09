package com.gabbar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gabbar.entity.Employee;
import com.gabbar.service.EmpService;


import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController 
{
	@Autowired
	private EmpService es;
	
	
	@GetMapping("/")
	public String index (Model m)
	{
		List<Employee> list = es.getAllEmployee();
		m.addAttribute("emplist", list);
		return "index";
	}
	
	@GetMapping("/save")
	public String loadsaveEmp ()
	{
		return "Emp_save";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmp (@PathVariable int id, Model m)
	{
		Employee emp = es.getEmpById(id);
		m.addAttribute("emp", emp);
		return "Edit_emp";
	}
	
	@PostMapping("/emplsave")
	public String saveEmp(@ModelAttribute Employee ep,HttpSession session)
	{
		//System.out.println(emp);
		
		Employee newemp = es.saveEmployee(ep);
		if (newemp!=null)
		{
			//System.out.println("Data Successfully Save");
			session.setAttribute("msg", "Data Successfully Save");
		}
		else
		{
			//System.out.println("Data not Save");
			session.setAttribute("msg", "Data not Save");
		}
		return "redirect:/save";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee ep,HttpSession session)
	{
		//System.out.println(emp);
		
		Employee updateemp = es.saveEmployee(ep);
		if (updateemp!=null)
		{
			//System.out.println("Data Successfully Save");
			session.setAttribute("msg", "Updata Successfully Save");
		}
		else
		{
			//System.out.println("Data not Save");
			session.setAttribute("msg", "Data not Update");
		}
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee (@PathVariable int id, HttpSession session)
	{
		boolean b = es.deleteEmployee(id);
		if (b)
		{
			session.setAttribute("msg", "Delete Successfully");
		}
		else
		{
			session.setAttribute("msg", "Data dos not Delete");
		}
		return "redirect:/";
	}
		
}
