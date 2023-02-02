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
TODOs CRUD: Each to-do item has its ID, 

## Class Diagram

![diagram](/src/main/java/com/example/simpletodosmanager/uml/ModelDiagram.png)


## Room for improvement

1. Lack Authentication features. 
2. DevOps
3. To-do item assignment to refine. 
4. Front-end sites. 
5. Tests
## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details