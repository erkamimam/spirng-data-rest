package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    //define field for entity manager

    private EntityManager entityManager;
    //setup constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees = query.getResultList();
        //return the results
        return employees;

    }

    @Override
    public Employee findById(int theId) {
        //get employee
        //Employee employee=entityManager.find(Employee.class,theId);
        //return employee
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save or update the employee
        //Employee dbEmployee=entityManager.merge(theEmployee);

        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        //delete object with primary key
        //find the employee
        Employee employee = entityManager.find(Employee.class, theId);
        //delete employee
        entityManager.remove(employee);


    }
}
