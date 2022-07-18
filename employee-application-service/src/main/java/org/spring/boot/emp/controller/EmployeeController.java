package org.spring.boot.emp.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.spring.boot.emp.dao.EmployeeDAO;
import org.spring.boot.emp.dao.EmployeeDB;
import org.spring.boot.emp.model.Employee;
import org.spring.boot.emp.model.EmployeeVO;
import org.spring.boot.emp.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeDAO employeeDao;
     
    @GetMapping(path="/", produces = "application/json")
    public Employees getEmployees()
    {
        return employeeDao.getAllEmployees();
    }
     
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee( 
    		@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
           @Valid @RequestBody Employee employee)
    {
        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);
         
        employeeDao.addEmployee(employee);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
    
    @GetMapping(path="/{empId}", produces="application/json")
    public Employee getEmployeeById(@PathVariable("empId") Integer empId)
    {
        return employeeDao.getEmployeeById(empId);
    }
    
    //Spring hateoas example
    
    @RequestMapping(value = "/employees")
    public List<EmployeeVO> getAllEmployees()
    {
    	List<EmployeeVO> employeeList=new ArrayList<>();
    	
        for (EmployeeVO employee : EmployeeDB.getEmployeeList()){
        	
        	 //Adding self link employee 'singular' resource
            Link link = ControllerLinkBuilder
                    .linkTo(EmployeeController.class)
                    .slash(employee.getEmployeeId())
                    .withSelfRel();
     
            //Add link to singular resource
           // employee.add(link);
            employeeList.add(employee);
        }
 
        return employeeList;
    }
  
}