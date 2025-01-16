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
