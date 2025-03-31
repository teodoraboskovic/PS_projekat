1. Project Setup
This project is a Java client-server application developed in NetBeans. The application consists of three modules:
Client – The client-side application.
Server – The server-side application.
CommonLib – A shared library used by both Client and Server applications.
1.1 Prerequisites
1.1.1 Java Development Kit (JDK)
The project was developed using JDK 21, but it may be compatible with earlier versions.
1.1.2 MySQL Server
This project requires MySQL Server for database management.Start the MySQL server before running the project.
1.2 Project Installation
1.2.1 Clone or Download the Project
1.2.2 Open the Project
1.2.3 Add Required Libraries
Each module requires specific dependencies:
Client and Server:
CommonLib (included in both)
jCalendar 1.4 (included in both)
Server only:
MySQL Connector j 8.1.0
JUnit 4.13.2 (for testing purposes)
1.3 Database Setup
1.3.1 Install a MySQL Client
You can use MySQL Workbench, SQLyog, or any other MySQL-compatible database tool.
1.3.2 Run the SQL Script
The SQL script nova_baza.sql is provided in the repository to create the initial database schema, execute it to create the necessary database structure.
1.4 Running the Application
1.4.1 Start the MySQL Server
Ensure that the MySQL Server is running before launching the application.
1.4.2 Run the Server Application
In NetBeans, right-click the Server project. Select Run to start the server.
1.4.3 Run the Client Application
In NetBeans, right-click the Client project. Select Run to start the client-side application.
2.Features
The application provides the following key functionalities:
Supports user authentication and role-based access control.
Enables the preschool director to create, edit, and search for children, employees, and parents in the system.
Allows the director to create, modify, or delete elective programs for children.
Supports the creation of attendance records, linking children to selected elective program with the ability to update them later.
Built using the Model-View-Controller (MVC Architecture) pattern, improving code structure, readability, and long-term maintainability.
GUI developed using Java Swing, providing an intuitive and user-friendly interface.
Implements form validation and error handling to enhance data integrity.
Includes JUnit 4.13.2 in the server application for unit testing.
