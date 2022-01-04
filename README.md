# unit2project


Technologies Used: IntelliJ, ERD Tool/Lucidchart, Spring Boot,Maven,postgres,pgAdmin, Postman

Project description: Created REST Api for database of a book app. The REST API will allow the User to keep track of their Books, Genres, Authors, and Publishers.

Endpoints:

(1.Books) [GET] endpoint: "/api/books" - Get all Books - Request Type: None

[GET] endpoint: "/api/books/{bookId}" - Get a single book - Request Type: None *

[POST] endpoint: "/api/books/1" - Creating a Single Book - Request Body: book info

[PUT] endpoint: "/api/books/1" - Updating Single Book - Request Body: book info

[DELETE] endpoint: "/api/books/1" - Delete Single Book - Request Body; None

(2.Genres) [GET] endpoint: "/api/books/1/genres" - Get all Genres- Request Body: None

[GET] endpoint: "/api/genres/{genreId}" - Get single genre - Request Type: None *

[POST] endpoint: "/api/books/1/genres/1" - Create a Single Genre - Request Body: genre info

[PUT] endpoint: "/api/books/1/genres/1" - Update a Single Genre - Request Body: genre info

[DELETE] endpoint: "/api/books/1/genres/1" - Delete a Single Genre - Request Body : None

(3.Publishers) [GET] endpoint: "/api/books/1/publishers" - Get all Publishers - Request Type: None

[GET] endpoint: "/api/publishers/{publisherId}" - Get a single publisher - Request Type: None *

[POST]endpoint: "/api/books/1/publishers" - Create a Single Publisher - Request Type: publisher info

[PUT] endpoint: "/api/books/1/publishers/1" - Update a Single Publisher - Request Type: publisher info

[DELETE] endpoint:"/api/books/1/publishers" - Delete a Single Publisher - Request Type: None

(4.Authors)

[GET] endpoint: "/api/books/1/authors/1" - Get all authors - Request Type: None

[GET] endpoint: "/api/authors/{authorId}" - Get a single author - Request Type: None *

[POST] endpoint: "/api/books/1/authors/1" - Create a single author - Request Type: author info

[PUT] endpoint: "/api/books/1/authors/1" - Update a Single Author - Request Type: author info

[DELETE] endpoint: "/api/books/1/authors/1" - Delete a Single Author

User Stories

[Book Model] As a user, I should be able to create new search catalog for a book. As a user, I should be able to read the book. As a user, I should be able to update the book. As a user, I should be able to delete a book.

[Genre Model] As a user, I should be able to create new search a genre. As a user, I should be able to read a genre. As a user, I should be able to update a genre. As a user, I should be able to delete a genre.

[Author Model] As a user, I should be able to create new search catalog for the author. As a user, I should be able to read who is the author. As a user, I should be able to update catalog of author. As a user, I should be able to delete the current author in the catalog.

[Publisher Model] As a user, I should be able to create a new search catalog for the publisher. As a user, I should be able to read who is the publisher As a user, I should be able to update catalog of publisher. As a user, I should be able to delete the current publisher in the catalog.

ERD Diagram Link https://lucid.app/lucidchart/f625e5d0-3422-4928-8224-e278f466f0c2/edit?invitationId=inv_92add0b3-91da-436e-9021-e70908a888ff

Timeline Day 1 - Use Maven to download and build all of the dependencies, set up Spring Boot, set up dev environment, etc.
