package com.example.assignment.service;

import com.example.assignment.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private static final Map<Integer, Employee> employeeMap = new HashMap<>();

    private static int autoId = 1;

    public EmployeeService() {
        employeeMap.put(autoId, new Employee(autoId++, "Nguyen Van A", "a@gmail.com", "Hanoi"));
        employeeMap.put(autoId, new Employee(autoId++, "Tran Thi B", "b@gmail.com", "Danang"));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getEmployeeById(int id) {
        return employeeMap.get(id);
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(autoId++);
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Employee updateEmployee(int id, Employee newInfo) {
        if (employeeMap.containsKey(id)) {
            Employee existingEmp = employeeMap.get(id);
            existingEmp.setName(newInfo.getName());
            existingEmp.setEmail(newInfo.getEmail());
            existingEmp.setLocation(newInfo.getLocation());
            return existingEmp;
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
            return true;
        }
        return false;
    }
}