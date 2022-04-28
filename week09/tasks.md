# For today's lab we will create and connect to our own DB instance. You will create a simple tables with appropriate entities, repositories. Them we will call them via services.

# Task 0
Setup a PostgreSQL DB on your machine. If you have problem you can use the following [guide](https://github.com/GeorgiMinkov/web-development-with-Java/blob/main/week09/postgresql.md)

(***NB***) you can use MySQL DB too or your preferable DB.

```
spring.datasource.url=jdbc:postgresql://localhost:5433/postgres
spring.datasource.username=postgres
spring.datasource.password=pgadmin
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.database=postgresql
spring.jpa.hibernate.ddl-auto=update
```

# Task 1
Setup a connection from Ticket system to your newly created DB.

```
Abstract steps:
1. add necessary dependencies
2. add properties inside the application property file (.properties or .yml) for your DB connection (connection string, driver, dialect, etc)
```
For the configurations you can  use the example from [lecture week08](https://github.com/GeorgiMinkov/web-development-with-Java/tree/main/week08/FMI_DB_JPA).

---
### *For the next steps we will use only Events and Users controller/service/repository/entity  as there is no relations for now*
---

# Task 2
Define your entity DB structure for Event and User inside the TicketSystem project

Using Hibernate create the DB tables


# Task 3
Modify your repository classes for Event and User to use the real DB

# Task 4
Using REST APIs for Events and Users test your application via Postman.

To accomplish it change the necessary services.
