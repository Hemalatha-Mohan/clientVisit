package com.example.SearchEmployee.Service;

import com.example.SearchEmployee.Repository.EmployeeRepository;
import com.example.SearchEmployee.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> listAll() {
        return repo.findAll();
    }



    /*public Employee get(int id) {
        return repo.findById(id).get();

    }*/

    public Employee getByEname(String ename){
        Optional<Employee> optional = repo.getByEname(ename);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }
            else{
              throw new RuntimeException(" Employee not found for the ename :: " + ename);
        }
        return employee;
        }




}
