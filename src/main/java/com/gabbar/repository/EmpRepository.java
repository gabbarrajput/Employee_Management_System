package com.gabbar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabbar.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>
{

}
