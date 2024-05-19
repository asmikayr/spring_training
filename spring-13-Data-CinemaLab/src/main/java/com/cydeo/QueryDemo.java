package com.cydeo;

import com.cydeo.enums.UserRole;
import com.cydeo.repository.AccountRepository;
import com.cydeo.repository.CinemaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;

    public QueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("---------------------ACCOUNT--------------------------");

        System.out.println("findAllByCountryOrState" + accountRepository.findAllByCountryOrState("United States", "New York"));
        System.out.println("findByAgeLessThanEqual" + accountRepository.findByAgeLessThanEqual(50));
        System.out.println("findByRole" + accountRepository.findByRole(UserRole.USER));
        System.out.println("findAllByOrderByAge" + accountRepository.findAllByOrderByAge());
        System.out.println("findByAgeBetween" + accountRepository.findByAgeBetween(18,40));
        System.out.println("findByAddressStartingWith" + accountRepository.findByAddressStartingWith("2"));

        System.out.println("retrieveAllAccounts" + accountRepository.retrieveAllAccounts());
        System.out.println("retrieveAllAdminAccounts" + accountRepository.retrieveAllAdminAccounts());
        System.out.println("sortAllAccountsByAge" + accountRepository.sortAllAccountsByAge());
        System.out.println("retrieveAccountsByAgeLessThan" + accountRepository.retrieveAccountsByAgeLessThan(30));
        System.out.println("retrieveAccountsContaining" + accountRepository.retrieveAccountsContaining("Jo"));
        System.out.println("retrieveAccountsByAgeMoreThan" + accountRepository.retrieveAccountsByAgeMoreThan(30));

        System.out.println("---------------------CINEMA--------------------------");
        System.out.println("findCinemaByName" + cinemaRepository.findCinemaByName("Hall 1 - EMPIRE"));
        System.out.println("findTop3BySponsoredName" + cinemaRepository.findTop3BySponsoredNameContainingOrderBySponsoredName("Kodak"));
        System.out.println("findAllByLocation_Country" + cinemaRepository.findAllByLocation_Country("United States"));
        System.out.println("findCinemaByNameOrSponsoredName" + cinemaRepository.findCinemaByNameOrSponsoredName("Abc", "Kodak"));
        System.out.println("retrieveById" + cinemaRepository.retrieveById(1L));
        System.out.println("retrieveAllByCountry" + cinemaRepository.retrieveAllByCountry("United States"));

    }
}
