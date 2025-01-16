**RestApiApplication**

This project implements a simple RESTful API for a basic banking system using Spring Boot, Spring Data JPA, and PostgreSQL.

**Key Features:**

**Customer Management:**
Register new customers with basic personal details and an initial balance.
Retrieve customer details by ID.

**Transaction Management:**
Perform debit transactions, deducting funds from the customer's balance.
Perform credit transactions, adding funds to the customer's balance.
Record transaction details (type, amount, description) for each transaction.

**Transaction Filtering:**
Filter transactions by customer ID, type ("debit" or "credit"), and amount range.

**Data Persistence:**
Utilizes PostgreSQL as the underlying database.
Uses JPA and Hibernate for object-relational mapping.

**RESTful API:**
Exposes endpoints for customer registration, retrieval, and transaction operations.
Uses HTTP methods (POST, GET) for CRUD operations.
Returns JSON responses for API requests.

**Technologies Used:**

**Spring Boot:** Framework for building Spring-based applications.

**Spring Data JPA:** Simplifies JPA data access with Spring.

**Hibernate:** Object-relational mapping (ORM) framework.

**PostgreSQL:** Relational database system.

**Java:** Programming language.

**Maven:** Build automation and dependency management tool.

**Project Structure:**

src/main/java: Contains Java source code (entities, repositories, services, controllers).

src/main/resources: Contains configuration files (application.properties).

src/test/java: Contains ....

**Getting Started:**

Clone the repository: git clone https://github.com/ssudhanshus/RestApiApplication

Build the project: mvn clean install

Run the application:1 mvn spring-boot:run   

Access the API: Use a REST client (e.g., Postman, cURL) to interact with the API endpoints.

**Sample Request** 

**1. Register a New Customer**
HTTP Method: **POST**
**URL:** http://localhost:8080/api/bank/register
**Body (JSON):**
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "balance": 1000.0
}
This will create a new customer with the specified name, email, and balance.

**2. Get Customer Details by Customer ID**
HTTP Method: GET
URL: http://localhost:8080/api/bank/customers/{customerId}
Example URL: http://localhost:8080/api/bank/customers/1
This will fetch the details of the customer with ID 1.

**3. Debit from Customer Account**
HTTP Method: POST
URL: http://localhost:8080/api/bank/customers/{customerId}/debit
Example URL: http://localhost:8080/api/bank/customers/1/debit
Query Parameters:

amount = 100.0
description = ATM Withdrawal
Example URL with query params:
**http://localhost:8080/api/bank/customers/1/debit?amount=100.0&description=ATM%20Withdrawal**

This will debit 100.0 from the customer with ID 1 and create a transaction with the given description.

**4. Credit to Customer Account**
HTTP Method: POST
URL: http://localhost:8080/api/bank/customers/{customerId}/credit
Example URL: http://localhost:8080/api/bank/customers/1/credit
Query Parameters:

amount = 200.0
description = Salary Credit
Example URL with query params:
http://localhost:8080/api/bank/customers/1/credit?amount=200.0&description=Salary%20Credit

This will credit 200.0 to the customer with ID 1 and create a transaction with the provided description.

**5. Get Transactions by Criteria (Customer ID, Type, Min Amount, Max Amount)**
HTTP Method: GET
URL: http://localhost:8080/api/bank/customers/{customerId}/transactions
Example URL: http://localhost:8080/api/bank/customers/1/transactions
Query Parameters:

type = debit (optional)
minAmount = 50.0 (optional)
maxAmount = 500.0 (optional)
Example URL with query params:
http://localhost:8080/api/bank/customers/1/transactions?type=debit&minAmount=50.0&maxAmount=500.0

This will return a list of transactions for the customer with ID 1 that match the given criteria (debit type, and amount between 50.0 and 500.0).
