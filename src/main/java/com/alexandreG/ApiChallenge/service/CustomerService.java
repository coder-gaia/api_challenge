package com.alexandreG.ApiChallenge.service;

import com.alexandreG.ApiChallenge.model.Customer;
import com.alexandreG.ApiChallenge.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ICustomerRepository customerRepository;

    private final String apiUrl = "https://09441c3d-9208-4fa9-a576-ba237af6b17c.mock.pstmn.io/";

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> readCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Optional<Customer> readCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public ResponseEntity<String> findCustomerById(Long id) {
        Optional<Customer> customer = readCustomerById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok("Sucesso ao Encontrar usuário: " + customer.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado com ID: " + id);
    }

    public ResponseEntity<String> delete(long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Usuário deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado com ID: " + id);
    }

    public ResponseEntity<String> updateCustomer(Long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            customerRepository.save(customer);
            return ResponseEntity.ok("Informações do usuário foram alteradas com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado com ID: " + id);
    }

}
