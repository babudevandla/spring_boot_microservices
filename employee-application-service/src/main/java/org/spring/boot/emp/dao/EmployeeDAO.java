package org.spring.boot.emp.dao;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.spring.boot.emp.model.Employee;
import org.spring.boot.emp.model.Employees;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO
{
    private static Employees list = new Employees();
     
    static
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
        list.getEmployeeList().add(new Employee(4, "Babu", "Test", "babu@gmail.com"));
    }
     
    public Employees getAllEmployees()
    {
    	//Map<Integer,Employee> mapEmp=list.getEmployeeList().stream().collect(Collectors.toMap(Employee::getId,Function.identity()));
    	//System.out.println(mapEmp);
        return list;
    }
     
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }

	public Employee getEmployeeById(Integer empId) {
		Employee emp=list.getEmployeeList().stream().filter( e -> e.getId() == empId).findAny().orElse(null);
		return emp;
	}
}