package com.gabbar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gabbar.entity.Employee;
import com.gabbar.repository.EmpRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpServiceImpl implements EmpService
{
	@Autowired
	private EmpRepository emprepo;

	@Override
	public Employee saveEmployee(Employee emp) {
		Employee save = emprepo.save(emp);
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return emprepo.findAll();
	}

	@Override
	public Employee getEmpById(int id) {
		
		return emprepo.findById(id).get();
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee delete = emprepo.findById(id).get();
		if (delete!=null)
		{
			emprepo.delete(delete);
			return true;
		}
		return false;
	}
	
	public void removeSessionMessage()	
	{
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes()))
				.getRequest().getSession();
		session.removeAttribute("msg");
	}

}
