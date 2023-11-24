# Employee Data Manipulation Project
Uses a CSV file full of employee records including fields such as employee ID number, date of birth and name. The application uses this CSV file to parse the data and display requested information to the user such as getting an employee by their ID or searching for employees by their last name.
This group project was assigned to us as part of our Java development training to allow us to demonstrate our collaborative git skills and Java development skills.
The main aims of the project include:
-	Parsing a csv file into an appropriate data structure.
-	Implementing the DAO and DTO design patterns.
-	Using the MVC (Model, View, Controller) design pattern.
-	Create a user interface and searching functionality.

## Project Structure
The project was divided into multiple packages based on the MVC design pattern.
 The model package contains all classes and methods pertaining to the data set and manipulating it into a more accessible format, this is where the DTO pattern was implemented under the file name EmployeeStore.java.
The controller package contains the logic to query the DTO and return the appropriate information regarding the employee records. This package contains the implementation of the DAO design pattern.
The view package contains the user interface and calls the DAO methods. Any time information is printed, this logic should be handled in the view package.

## Project Workflow 
This project was run as a SCRUM project, with daily standups and code reviews. This made the collaboration aspect of the project much simpler as all members were on the same page when going into coding sessions throughout the day. Using scrum methodology also made the delegation of work much easier as the use of user stories allowed the challenge to be broken down into much smaller, digestible chunks that could be worked on during the sprints. Pair programming was also used throughout the project to allow for cleaner code and collaborative problem solving.

## Test-Driven Development
Test-driven development involves writing extensive unit tests for the application before writing any of the code. This methodology helps with assuring that code achieves its desired functionality and does not get broken with future alterations.
Our testing was quite extensive, however, using Junit tests sometimes became quite difficult and manual testing through print statements and log files was a more efficient way to go about this problem.

## Running the code
The code includes an App.java file in the view package which is the main launch point for the application, run this file and the rest of the application should follow.

