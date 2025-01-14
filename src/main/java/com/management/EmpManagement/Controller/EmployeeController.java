package com.management.EmpManagement.Controller;


import com.management.EmpManagement.DTO.EmployeeDto;
import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Service.EmployeeService;
import com.management.EmpManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/v1/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping("/save")
    public CommonResponse save(@RequestBody EmployeeDto dto) throws ParseException {
        return empService.saveEmp(dto);
    }

    @GetMapping("/get/{id}")
    public EmployeeEntity getById(@PathVariable Long id){
        return empService.getByEmpId(id);
    }

    @GetMapping("/get")
    public List<EmployeeEntity> get(){
        return empService.getAllEmp();
    }

    @PostMapping("/update/{id}")
    public EmployeeEntity update(@PathVariable Long id ,@RequestBody EmployeeDto dto){
        return empService.updateEmp(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        empService.deleteEmp(id);
        return "Emp is Deleted";
    }
}
