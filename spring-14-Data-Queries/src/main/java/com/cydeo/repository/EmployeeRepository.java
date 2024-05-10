package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display all employees with email address ""
    List<Employee> findByEmail(String email);

    //Display all employees with firstname "" and lastname "",
    //also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastname, String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstname);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate date1, LocalDate date2);

    //Display all employees where salaries greater and equal to "" i order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    @Query("Select employee from Employee employee where employee.email = 'amcnee1@google.es'")
    Employee retrieveEmployeeDetail();
    @Query("SELECT e.salary from Employee e where e.email = 'amcnee1@google.es'")
    Integer retrieveEmployeeSalary();

    //Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like/Contains/Startswith/Endswith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less than
    @Query("SELECT e FROM Employee e where e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //Greater than
    @Query("SELECT e.firstName FROM Employee e where e.salary > ?1")
    List<String> retrieveEmployeeFirstnameSalaryGreaterThan(int salary);

    //BETWEEN
    @Query("SELECT e FROM Employee e where e.salary between ?1 and ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //BEFORE
    @Query("SELECT e from Employee e where e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);








}
