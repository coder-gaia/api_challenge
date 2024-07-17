package com.alexandreG.ApiChallenge.repository;

import com.alexandreG.ApiChallenge.model.Customer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String apiUrl = "https://09441c3d-9208-4fa9-a576-ba237af6b17c.mock.pstmn.io/";

    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode root = objectMapper.readTree(responseBody);
            JsonNode dados = root.path("Dados");

            for (JsonNode node : dados) {
                Customer customer = new Customer();
                customer.setNome(node.path("Nome").asText());
                customer.setDisponivel(node.path("Disponivel").asBoolean());
                customerRepository.save(customer);
            }
        } else {
            System.out.println("Erro ao chamar a API externa para inicializar o banco de dados.");
        }
    }
}
