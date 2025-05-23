Database onnectivity in java

# Alien Repository - Spring Boot JDBC Example

This repository demonstrates the usage of **Spring Boot** with **JDBC** for basic CRUD operations using a relational database. It provides an example of how to integrate **JDBC Template** for performing operations like saving and retrieving data from a database.

## Table of Contents
- [Overview](#overview)
- [Technology Stack](#technology-stack)
- [Setup and Installation](#setup-and-installation)
- [Database Configuration](#database-configuration)
- [Repository Implementation](#repository-implementation)
  - [Save Alien](#save-alien)
  - [Find All Aliens](#find-all-aliens)
- [Run the Application](#run-the-application)
- [Contributing](#contributing)

## Overview

The project implements a **Spring Boot application** to interact with a database using **JDBC** for performing basic operations on an `Alien` entity. The application allows for inserting new records into the database and retrieving them.

## Technology Stack

- **Spring Boot**: Framework used for building the application
- **JDBC Template**: Used for interacting with the relational database
- **MySQL** (or other relational databases): Data storage for the aliens
- **Java**: Programming language
- **Maven**: Dependency management and build tool

## Setup and Installation

To get started with the project, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/alien-repository.git
   ```

2. **Navigate to the project directory:**

   ```bash
   cd alien-repository
   ```

3. **Set up the database:**

   - Ensure that you have a running MySQL instance (or other relational databases).
   - Create a new database for the application, for example: `alien_db`.

4. **Update application properties:**

   Update the `application.properties` or `application.yml` file in `src/main/resources` with your database details. Example:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/alien_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```

## Database Configuration

In the `alien` table, the following columns are required:

- **id** (integer): Unique identifier for each alien.
- **name** (string): Name of the alien.
- **tech** (string): The technology the alien specializes in.

### Example SQL to create the table:

```sql
CREATE TABLE alien (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    tech VARCHAR(255)
);
```

## Repository Implementation

### Save Alien

The `AlienRepo` class provides a method to save an alien to the database using the `JdbcTemplate`'s `update` method.

```java
public void save(Alien alien) {
    String sql = "insert into alien (id, name, tech) values(?, ?, ?)";
    template.update(sql, alien.getId(), alien.getName(), alien.getTech());
}
```

### Find All Aliens

The `findAll` method retrieves all aliens from the database. It uses a custom `RowMapper` to map the `ResultSet` into an `Alien` object.

```java
public List<Alien> findAll() {
    String sql = "select * from alien";
    RowMapper<Alien> mapper = new RowMapper<Alien>() {
        public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
            Alien a = new Alien();
            a.setId(rs.getInt(1));
            a.setName(rs.getString(2));
            a.setTech(rs.getString(3));
            return a;
        }
    };
    return template.query(sql, mapper);
}
```

## Run the Application

1. **Build the application** using Maven:

   ```bash
   mvn clean install
   ```

2. **Run the Spring Boot application**:

   ```bash
   mvn spring-boot:run
   ```

3. The application will now be accessible on [http://localhost:8080](http://localhost:8080), and it will interact with the configured database to perform CRUD operations.

## Contributing

Feel free to fork the repository, create a branch, and submit a pull request with improvements, bug fixes, or new features. Please ensure that your contributions align with the project's goals and follow standard Java coding practices.
