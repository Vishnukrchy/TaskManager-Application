# Task Manager Application

## Description
The ToDo Application is a web-based tool for managing tasks. It allows users to add, edit, delete, and view tasks. This project is implemented using Java and various web technologies.

## Technologies Used
- **Java**: The primary programming language used.
- **Jakarta Servlet**: For handling HTTP requests and responses.
- **JSP (JavaServer Pages)**: For rendering dynamic web content.
- **Bootstrap**: For styling the web pages.
- **JDBC (Java Database Connectivity)**: For connecting to the MySQL database.
- **MySQL**: The database used to store ToDo items.

## Features
- **Add ToDo**: Users can add new tasks.
- **Edit ToDo**: Users can edit existing tasks.
- **Delete ToDo**: Users can delete tasks.
- **View ToDo**: Users can view the list of all tasks.

## Project Structure
- **Controller**: Contains servlets for handling requests and responses.
  - `ToDoAdd.java`
  - `ToDo_updateController.java`
- **DAO (Data Access Object)**: Contains classes for database operations.
  - `ToDoDao.java`
- **DTO (Data Transfer Object)**: Contains classes representing data.
  - `Entity.java`
- **Connection**: Contains the database connection class.
  - `EntityConnection.java`
- **Web Pages**: JSP files for different functionalities.
  - `index.jsp`
  - `edit.jsp`
  - `addToDo.jsp`
- **Components**: Shared JSP components like navbar and CSS.
  - `navbar.jsp`
  - `allCSS.jsp`

## How to Run
1. **Set up MySQL Database**:
   - Create a database named `project`.
   - Create a table named `todo` with the following structure:
     ```sql
     CREATE TABLE todo (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       todo VARCHAR(255) NOT NULL,
       status VARCHAR(50) NOT NULL
     );
     ```
2. **Configure Database Connection**:
   - Update the `EntityConnection.java` file with your MySQL database username and password.
     ```java
     String url = "jdbc:mysql://localhost:3306/project";
     String user = "root";
     String pass = "your_password";
     ```
3. **Deploy the Application**:
   - Deploy the project on a servlet container like Apache Tomcat.
   - Access the application via `http://localhost:8080/your_project_name`.

## Contribution
Feel free to fork this repository and contribute by submitting a pull request. Any contributions, issues, and feature requests are welcome.


## Contact
For any questions or feedback, please contact vishnukrkamat@gmail.com
