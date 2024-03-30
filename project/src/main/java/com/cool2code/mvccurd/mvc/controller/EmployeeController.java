package com.cool2code.mvccurd.mvc.controller;

import com.cool2code.mvccurd.mvc.entity.Employee;
import com.cool2code.mvccurd.mvc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for the "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // get the employee from BD
        List<Employee> theEmployees = employeeService.findAll();
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    // add mapping for form add

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create a model attribute to bind form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        // set employee in the model to prepopulate the form
        theModel.addAttribute("employee", theEmployee);
        // send over to our form
        return "employees/employee-form";
    }

    @PostMapping("save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        // save the employee
        employeeService.save(theEmployee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {
        // delete the employee
        employeeService.deleteById(theId);
        // redirect to the list
        return "redirect:/employees/list";
    }
}
