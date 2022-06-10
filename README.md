# Manage Tickets
This project follows an MVC design pattern, implementing SpringSecurity, JavaValidations and BCrypt. The app has the ability to restrict access according to the user's, role, It has 4 roles, admin, user, supervisor and seller. Role admin has privileges to assign tickets to users with seller role, Users with role seller can assign comments and change the status of the ticket. 
Users who register will be automatically created with a user role and will be able to track the ticket
# INSTRUCTIONS
1. Inside the db folder src/main/resources you can find the .sql file so you can run it in your MySQL database manager. You will also find the Entity Relationship diagram
2. If you have a password for your database manager you can place it in the application.properties file to be able to connect correctly.
3. Download the MAVEN dependencies for the correct operation of the project.
4. Run the application.
# LOGIN USERS
username: admin
password: 123

Username: chepe, aguilar
Password for other users:123

