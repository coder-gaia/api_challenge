package com.alexandreG.ApiChallenge.repository;

import com.alexandreG.ApiChallenge.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByNome(String nome);
}

