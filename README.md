#Task 1:  Creation of a repository on Github

#Task 2:   Building a Spring Boot REST API project 
Adding an entity Author, a repository interface AuthorRepository, and a controller AuthorRestController. 

##Testing using Postman: 
![image](https://github.com/SaraMekshaj1/ZhvillimAplikacioniNeCloud/assets/153858360/d42fa81c-2796-484e-b91e-a8de0fa673bf)

![image](https://github.com/SaraMekshaj1/CloudDevelopment/assets/153858360/0b9a7eb4-2b1c-4e86-9a81-6518dfcfa8d9)

#Task 3: Building and pushing to DockerHub: 
![image](https://github.com/SaraMekshaj1/CloudDevelopment/assets/153858360/669c4323-4a39-4327-be98-83d905c126ca)




# spring-boot-rest-api-postgresql

#### Plain REST API CRUD with Spring Boot and PostgreSQL.

Technology stack:

* Spring Boot;
* Spring Web;
* Spring Data;
* PostgreSQL database;
* Hibernate;
* Spring Security (as basic authentication).

##### To run this application use:

`mvn clean spring-boot:run`

The view in the Postman:

Add new Book

`POST /api/books`

http://localhost:8080/api/books

![Add New Book](img/add.png "Add New Book")

Get All Books

`GET /api/books`

http://localhost:8080/api/books

![Get All Books](img/list.png "Get All Books")

Get Book By Id

`GET /api/books/{id}`

http://localhost:8080/api/books/{id}

![Get Book By Id](img/getId.png "Get Book By Id")

Get Book By Name

`GET /api/books?name=name`

http://localhost:8080/api/books?name=name

![Get Book By Name](img/name.png "Get Book By Name")

Delete Book By Id

`DELETE /api/books/{id}`

http://localhost:8080/api/books/{id}

![Delete Book By Id](img/deleteId.png "Delete Book By Id")

Delete All Books

`DELETE /api/books`

http://localhost:8080/api/books

![Delete All Books](img/deleteAll.png "Delete All Books")





/////////////

kubectl config current-context -- To view your current context
kubectl config get-contexts -- To list all your contexts
kubectl config use-context my-context -- To switch to a different context:
