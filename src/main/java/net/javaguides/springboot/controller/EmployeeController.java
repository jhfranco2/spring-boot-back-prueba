package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRespository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRespository employRepository;

    //get All employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employRepository.save(employee);
    }

    //get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employRepository.findById(id).orElse(null);
                
               return ResponseEntity.ok(employee);
    }
    //update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
        Employee employee = employRepository.findById(id).orElse(null);
        employee.setNombre(employeeDetails.getNombre());
        employee.setApellido(employeeDetails.getApellido());
        employee.setDNI(employeeDetails.getDNI());
        employee.setEmpleado(employeeDetails.isEmpleado());

        Employee updateEmployee = employRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }
    //delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employRepository.findById(id).orElse(null);
        employRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);

        return ResponseEntity.ok(response);

    }
}
