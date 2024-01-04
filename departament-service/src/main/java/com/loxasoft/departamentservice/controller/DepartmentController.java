package com.loxasoft.departamentservice.controller;

import com.loxasoft.departamentservice.entity.Department;
import com.loxasoft.departamentservice.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService= departmentService;
    }

    @PostMapping
    public Department createDepartament(@RequestBody Department department){
        return departmentService.createDepartment(department);

    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Integer id){
        return departmentService.getDepartmentById(id);
    }

    @GetMapping
    public List<Department> findAll(){
        return departmentService.findAll();
    }



}
