package org.project.controller;

import org.project.dao.DepartmentDao;
import org.project.dao.EmployeeDao;
import org.project.domain.Department;
import org.project.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author jackqiu
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emp")
    public String getAll(Model model){
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    @GetMapping("/toAdd")
    public String ToAddView(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "emp/add";
    }

    @PostMapping("/add")
    public String addEmp(Employee employee){
        employeeDao.InsertEmployee(employee);
        return "redirect:/emp";
    }

    @RequestMapping ("/emp/{id}")
    public String toUpdateShow(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "emp/update";
    }

    @PostMapping ("/update")
    public String updateEmp(Employee employee){
        employeeDao.InsertEmployee(employee);
        return "redirect:/emp";
    }

    @RequestMapping ("/delete/{id}")
    public String toDeleteShow(@PathVariable("id")Integer id, Model model){
        employeeDao.DeleteEmployee(id);
        return "redirect:/emp";
    }
}
