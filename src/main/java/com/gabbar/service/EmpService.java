package com.gabbar.service;

import java.util.List;

import com.gabbar.entity.Employee;

public interface EmpService 
{
  public Employee saveEmployee (Employee emp);
  
  public List<Employee> getAllEmployee ();
  
  public Employee getEmpById (int id);
  
  public boolean deleteEmployee (int id);
}
