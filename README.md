##Technologies Used:
IntelliJ, ERD Tool/Lucidchart, Spring Boot,Maven,postgres,pgAdmin, Postman

##Project description:
Created REST Api for database of a book app. The REST API will allow the User to keep track of their Books, Genres, Authors, and Publishers.


##Endpoints:
(1.Books)
[GET] endpoint: "/api/books" -  Request Type: None
[POST] endpoint: "api/books/1/authors/1- Request Type: book information
[PUT] endpoint: "/api/books/1"- Request Type: book information
[DELETE] endpoint: "api/books/1 - Request Type: None

(2. Genres)
[GET] endpoint: "/api/books/{bookid}/genres" -  Request Type: None
[POST] endpoint: "/api/books/{bookid}/genres/{genreid} " - Request Type: genre information
[PUT] endpoint: "/api/books/{bookid}/genres/{genreid}" - Request Type: genre information
[DELETE] endpoint: "/api/books/{bookid}/genres/{genreid}" - Request Type: None

(3. Publisher)
[GET] endpoint: "/api/books/{bookid}/publishers" -  Request Type: None
[POST] endpoint: "/api/books/{bookid}/publishers/{publisherid} - Request Type: publisher information
[POST] endpoint: "/api/books/{bookid}/publishers/{publisherid} - Request Type: publisher info
[DELETE] endpoint: ""api/books/{bookid}/publishers/{publisherid}- Request Type: None


(4. Author)
[GET] endpoint: "/api/books/{bookid}/authors" -  Request Type: None
[POST] endpoint: " /api/books/{bookid}/authors/{authorid}" - Request Type: author info
[PUT] endpoint: "/api/books/{bookid}/authors/{authorid} - Request Type: author info
[DELETE] endpoint: "/api/books/{bookid}/authors/{authorid}" - Request Type: None


link to ERD diagram : https://lucid.app/lucidchart/f625e5d0-3422-4928-8224-e278f466f0c2/edit?invitationId=inv_92add0b3-91da-436e-9021-e70908a888ff
##User Stories

[Book Model] As a user, I should be able to create new search catalog for a book.
As a user, I should be able to read the book.
As a user, I should be able to update the book.
As a user, I should be able to delete a book.

[Genre Model] As a user, I should be able to create new search a genre.
As a user, I should be able to read a genre.
As a user, I should be able to update a genre.
As a user, I should be able to delete a genre.

[Author Model] As a user, I should be able to create new search catalog for the author.
As a user, I should be able to read who is the author.
As a user, I should be able to update catalog of author.
As a user, I should be able to delete the current author in the catalog.

[Publisher Model] As a user, I should be able to create a new search catalog for the publisher.
As a user, I should be able to read who is the publisher.
As a user, I should be able to update catalog of publisher.
As a user, I should be able to delete the current publisher in the catalog.


##Timeline
Day 1 - Use Maven to download and build all of the dependencies, set up Spring Boot, set up dev environment, etc.
Day 2 - setting up first draft of controllers, use postman to test endpoints, debugging any technical issues with models, etc. 


