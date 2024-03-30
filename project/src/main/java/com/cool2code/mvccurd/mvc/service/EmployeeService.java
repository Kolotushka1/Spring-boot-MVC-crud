package com.cool2code.mvccurd.mvc.service;

import com.cool2code.mvccurd.mvc.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
