### Desafio de Backend

Desenvolvimento e consumo da API https://09441c3d-9208-4fa9-a576-ba237af6b17c.mock.pstmn.io/ utilizando Java, Spring Boot e banco de dados H2.

#### Instruções para teste:

- **Pré-requisitos:**
  - JDK instalado na máquina.
  - Fork do projeto.
  - Importação via IntelliJ ou Eclipse.
  - Iniciar a aplicação principal `ApiChallengeApplication`.
  - Acessar a URL do H2: http://localhost:8080/h2
    - Credenciais de acesso (username e password) estão disponíveis em `src/main/resources/application.yml`.

#### Endpoints CRUD:

- **Criação de Cliente**
  - **POST:** http://localhost:8080/customer/create
    - **Corpo (JSON):**
      ```json
      {
          "nome": "Nome do Cliente",
          "disponivel": true
      }
      ```

- **Deleção de Cliente**
  - **DELETE:** http://localhost:8080/customer/delete/{id}

- **Listagem de Clientes**
  - **GET:** http://localhost:8080/customer

- **Detalhes de um Cliente por ID**
  - **GET:** http://localhost:8080/customer/id/{id}
    - **Exemplo de Uso:** `/customer/id/1` (onde `1` é o ID do cliente desejado).

- **Atualização de Cliente**
  - **PUT:** http://localhost:8080/customer/update/{id}
    - **Corpo (JSON):**
      ```json
      {
        "nome": "Novo Nome do Cliente",
        "disponivel": false
      }
      ```
