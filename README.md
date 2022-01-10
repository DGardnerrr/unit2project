Machineries Used: IntelliJ, ERD Tool/Lucidchart, Spring Boot,Maven,postgres,pgAdmin, Postman

Project description: Created REST Api for database of a book app. The REST API will allow the User to keep track of their Books, Genres, Authors, and Publishers.

General Approach:
1. time management - 

Hurdles:
1. debugging during certain parts project - Intelliji is strict on errors unlike Visual Studio Code . If there is one minor error on intelliji, the code will not be able to completely run.There was alot of trial & error involved here, it required lots of attention to detail.

2. being able to manauver throughout the project and complete each part in a certain amount of time
since most of the work was done solo

3. Making use of One to many, Many To Many mapping for the relations between models - This involved lots of trial and error and research


link to ERD diagram : https://lucid.app/lucidchart/f625e5d0-3422-4928-8224-e278f466f0c2/edit?invitationId=inv_92add0b3-91da-436e-9021-e70908a888ff
User Stories

Technical Requirements:
1.Persist at least four models eg: (Book, Author, Genre, Publisher) to a PostgreSQL database.
2.Use Spring Profiles for environment settings.
3.At least one API endpoint must perform full CRUD create, read, update, and delete actions.
4.Other API endpoints can perform CRUD based on the business use-case.
5.Expose CRUD routes that were built using REST conventions.
6.Handle exceptions gracefully.
7.Send appropriate messages back to the client in the event that an exception occurs.
8.Must have Controller and Service separate.
9.Document each end-point


Endpoints:

(1.Books) [GET] endpoint: "/api/books" - Get all Books - Request Type: None

[GET] endpoint: "/api/books/{bookId}" - Get a single book - Request Type: None *

[POST] endpoint: "/api/books/" - Creating a Single Book - Request Body: book info

[PUT] endpoint: "/api/books/{bookId}" - Updating Single Book - Request Body: book info

[DELETE] endpoint: "/api/books/{bookId}" - Delete Single Book - Request Body; None

(2.Genres) [GET] endpoint: "/genres" - Get all Genres- Request Body: None

[GET] endpoint: "/api/genres/{genreId}" - Get single genre - Request Type: None *

[POST] endpoint: "/api/books/{bookId}/genres" - creates book & add genre info to book - Request Body: genre info

[PUT] endpoint: "/api/genres/{genreId}" - Update a Single Genre - Request Body: genre info

[DELETE] endpoint: "/api/genres/{genreId}" - Delete a Single Genre - Request Body : None

(3.Publishers) [GET] endpoint: "/api/publishers" - Get all Publishers - Request Type: None

[GET] endpoint: "/api/publishers/{publisherId}" - Get a single publisher - Request Type: None *

[POST]endpoint: "/api/books/{bookId}/publisher" - creates book and add publisher info to book   - Request Type: publisher info

[PUT] endpoint: "/api/publishers/{publisherId}" - Update a Single Publisher

[DELETE] endpoint:"/api/publishers/{publisherId}" - Delete a Single Publisher
(4.Authors)

[GET] endpoint: "/api/authors" - Get all authors

[GET] endpoint: "/api/authors/{authorId}" - Get a single author
[POST] endpoint: "/books/{bookId}/authors" - create a book and add a author's info to the book

[PUT] endpoint: "/api/authors/{authorId}" - Update a Single Author
[DELETE] endpoint: "api/authors/{authorId}" - Delete a Single Author



As a user, I should be able to read the book.
As a user, I should be able to update the book.
As a user, I should be able to delete a book.
As a user, I should be able to find a book based on the Author's information.
As a user, I should be able to find a book based on the Genre's  information
As a user, I should be able to find a book based on the Publisher's  information


As a user, I should be able to read a genre.
As a user, I should be able to update a genre.
As a user, I should be able to delete a genre.



As a user, I should be able to read who is the author.
As a user, I should be able to update catalog of author.
As a user, I should be able to delete the current author in the catalog.


As a user, I should be able to read who is the publisher.
As a user, I should be able to update catalog of publisher.
As a user, I should be able to delete the current publisher in the catalog.


Timeline
Day 1 - Use Maven to download and build all of the dependencies, set up Spring Boot, set up dev environment, created user stories, erd diagram


Day 2 - created models (book, genre,publisher,author,etc.), use PostgreSQL  Spring Data to interact with database, mapped models together



Day 3 - created rest controller(s), tested endpoints for controller(s), created exceptions



Day 4 - fixed debugging issues - with database, one of tables will not show up on postgresql




Day 5, 6 & 7 - fixed debugging issues -service layers & controller




Day 8 - polishing up for presentation



Installation instructions: