package com.cool2code.mvccurd.mvc.dao;

import com.cool2code.mvccurd.mvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
