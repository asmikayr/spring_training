package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findAllByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(Integer age1, Integer age2);


    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String pattern);

    //Write a derived query to sort the list of accounts with age
    List<Account> findAllByOrderByAge();


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM Account a")
    List<Account> retrieveAllAccounts();


    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a where a.role = 'ADMIN'")
    List<Account> retrieveAllAdminAccounts();


    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a order by a.age")
    List<Account> sortAllAccountsByAge();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age < ?1", nativeQuery = true)
    List<Account> retrieveAccountsByAgeLessThan(int age);


    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state, city
    @Query(value = "select * from account_details  where name  like concat('%',?1,'%') or address like concat('%',?1,'%') or country like concat('%',?1,'%') or state like concat('%',?1,'%')", nativeQuery = true)
    List<Account> retrieveAccountsContaining(String pattern);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age > ?1", nativeQuery = true)
    List<Account> retrieveAccountsByAgeMoreThan(int age);
}
