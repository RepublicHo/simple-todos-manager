# Simple-ToDos-Manager

This project is to implement a simple ToDos Manager that 
performs CRUD (Create, Read, Update and Delete) operations 
based on Spring Framework. 

## Steps to set up this project
1. **Clone the application**

   ```bash
   git clone https://github.com/RepublicHo/simple-todos-manager.git
   ```
   
2. **Create MySQL database**

   ```bash
   create database todos_manager
   ```
3. **Change MySQL username and password as per your MySQL installation**

    + open `src/main/resources/application.properties` file.

    + change `spring.datasource.username` and `spring.datasource.password` properties as per your mysql installation

4. **Run the app**

   You can run the spring boot app by typing the following command -

   ```bash
   mvn spring-boot:run
   ```

   The server will start on port 5000.

## Features
1. Each to-do item has its own ID (as primary key), name, description, due date, status (Completed, Overdue, or In progress), as well as creator name and owner (who is assigned to finish this to-do item).
2. To-do item sorting and filtering. 
3. Passcode Encoder based on Spring Security. 
4. To-do task assignment for team cooperation. 

## Class Diagram

![diagram](/src/main/java/com/example/simpletodosmanager/uml/ModelDiagram.png)


## Room for improvement

1. Need more Authentication features, apart from PasswordEncoder.
2. To-do item assignment yet to refine. 
3. Front-end sites. 
4. Tests on this rest api with postman, apart from tests on the model. 

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details