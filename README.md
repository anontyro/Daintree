# Daintree
A Spring boot test site
---
#### Development - Hiatus
My first Spring Boot web application I developed after finishing the basics of Spring MVC. I did not like Spring MVC the framework had a lot of issues in my opinion and largely put me off the platform. I attempted Spring Boot and actually enjoyed it, it is much more
intuitive then Spring MVC and does a lot of the tiresome handling for you.

This web application is an employee management application which I would like to extend into a fully featured internal company web
service. The application allows CRUD operations on an employee table and uses Spring Authentication to secure the application.

Project Breakdown
---
1. The web application is written in Spring Boot.
2. Serving data from a MySQL database using the Hibernate interface.
3. The templating engine I used is JSP purly for practice.
4. Secured with Spring Authenticate.

### The Code

Using the Spring Boot packages the application have been compiled via Maven for simplicity although Gradle is growing on me and I expect
to make the switch in all future projects. The layout is a bit crazy with the main folder being the root but all the views are in
/main/webapp/WEB_INF/jsp it needs much better organisation. I am using the standard MVC model with my authentication being split into its
own section (auth), due to its size and complexity.

The models are using the standard two form with a database model e.g Employee.java which sets up the table data and then the EmployeeaDao
which sits on the top to abstract away the logic into a logical place.

The Spring Authentication limits all pages outside of the index, registration and static files with a login page being served.
Sessions are limited to only one to prevent any security concerns.

## UX

I have implemented basic bootstrap views with very little added styling as this project was mostly focused on the background technologies
I did not see the need for myself to spend a lot time styling it. I have CSS documents loaded although it has largely been an after
thought in this instance. 
