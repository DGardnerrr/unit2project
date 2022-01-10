Machineries Used: IntelliJ, ERD Tool/Lucidchart, Spring Boot,Maven,postgres/pgAdmin, Postman, Git, Github

Project description: Created REST Api for database of a book app. The REST API will allow the User to keep track of their Books, Genres, Authors, and Publishers.

General Approach:
- time management, project management - came up with a timeline of what needs to be completed each day
   (This is very important, especially when working solo) . 
- Decided on four models for the book app; These models are going to be Book, Author, Publisher, and Genre
- created erd diagram - outline of what needs to be included in the 4 models
- Developed specific user stories to help with backend logic for the book, author, publisher, genre models. The purpose of these user stories was to
   (this helped to generate better understanding of book app's features from the end user’s perspective, For example: what would the user want out of this book app? How can this app benefit the user?)
- added dependencies in pom.xl, set up development environment, created test endpoints for controller/s to ensure server is running
- created models, decided to have 1 controller (book controller and book service)  to make thing less complicated, book  controller was created for models, tested api endpoints for the necessary controller/s
- created repositories for the models
- exception handling classes were created and incorporated
- Since this was a different project scope, decided to not add security
- created service class which service as connection to controller class

Hurdles:
1. debugging during certain parts project - Intelliji is strict on errors unlike Visual Studio Code . If there is one minor error on intelliji, the code will not be able to completely run.There was alot of trial & error involved here, it required lots of attention to detail.

2. being able to manauver throughout the project and complete each part in a certain amount of time
since most of the work was done solo. Despite that, it was a win at the same time because it gave me more exposure to
the importance of time management & agile project management in software development. This is a valuable skill that can be applied in the 
near future.

3.Making use of One to many, Many To Many mapping for the relations between models - This involved lots of trial, error and research


link to ERD diagram : https://lucid.app/lucidchart/f625e5d0-3422-4928-8224-e278f466f0c2/edit?invitationId=inv_92add0b3-91da-436e-9021-e70908a888ff
User Stories

Technical Requirements:
- Persist at least four models eg: (Book, Author, Genre, Publisher) to a PostgreSQL database.
- Use Spring Profiles for environment settings.
- At least one API endpoint must perform full CRUD create, read, update, and delete actions.
- Other API endpoints can perform CRUD based on the business use-case.
- Expose CRUD routes that were built using REST conventions.
- Handle exceptions gracefully.
- Send appropriate messages back to the client in the event that an exception occurs.
- Must have Controller and Service separate.
- Document each end-point




Endpoints:

(1.Books) 
- [GET] endpoint: "/api/books" - Get all Books 

- [GET] endpoint: "/api/books/{bookId}" - Get a single book 

- [POST] endpoint: "/api/books/" - Creating a Single Book 

- [PUT] endpoint: "/api/books/{bookId}" - Updating Single Book 

- [DELETE] endpoint: "/api/books/{bookId}" - Delete Single Book 

(2.Genres) 
- [GET] endpoint: "/genres" - Get all Genres- Request Body: None

- [GET] endpoint: "/api/genres/{genreId}" - Get single genre - Request Type: None *

- [POST] endpoint: "/api/books/{bookId}/genres" - creates book & add genre info to book - Request Body: genre info

- [PUT] endpoint: "/api/genres/{genreId}" - Update a Single Genre - Request Body: genre info

- [DELETE] endpoint: "/api/genres/{genreId}" - Delete a Single Genre - Request Body : None

(3.Publishers)
- [GET] endpoint: "/api/publishers" - Get all Publishers - Request Type: None

- [GET] endpoint: "/api/publishers/{publisherId}" - Get a single publisher - Request Type: None *

- [POST]endpoint: "/api/books/{bookId}/publisher" - creates book and add publisher info to book   - Request Type: publisher info

- [PUT] endpoint: "/api/publishers/{publisherId}" - Update a Single Publisher

- [DELETE] endpoint:"/api/publishers/{publisherId}" - Delete a Single Publisher



(4.Authors)

- [GET] endpoint: "/api/authors" - Get all authors

- [GET] endpoint: "/api/authors/{authorId}" - Get a single author
- [POST] endpoint: "/books/{bookId}/authors" - create a book and add a author's info to the book

- [PUT] endpoint: "/api/authors/{authorId}" - Update a Single Author
- [DELETE] endpoint: "api/authors/{authorId}" - Delete a Single Author





//===User Stories===//
- As a user, I should be able to find a book based on the Author's information.
- As a user, I should be able to find a book based on the Genre's  information
- As a user, I should be able to find a book based on the Publisher's  information


- As a user, I should be able to read a genre of a book
- As a user, I should be able to update a genre of book
- As a user, I should be able to delete a genre of book.



- As a user, I should be able to read who is the author of book
- As a user, I should be able to update catalog of author's book
- As a user, I should be able to delete the current author in the book.


- As a user, I should be able to read who is the publisher of the book.
- As a user, I should be able to update catalog of publisher of the book.
- As a user, I should be able to delete the current publisher that I no longer want to  search 
for in the catalog of the book


Timeline
Day 1 - Use Maven to download and build all of the dependencies, set up Spring Boot, set up dev environment, created user stories, erd diagram


Day 2 - created models (book, genre,publisher,author,etc.), use PostgreSQL  Spring Data to interact with database, mapped models together



Day 3 - created rest controller(s), tested endpoints for controller(s), created exceptions



Day 4 - fixed debugging issues - with database, one of tables will not show up on postgresql




Day 5, 6 & 7 - fixed debugging issues -service layers & controller




Day 8 - polishing up for presentation



Installation instructions:
- Fork and clone the repository. 
- create a database called project2app with pgadmin
- Make sure database url is connected in application dev properties to prevent any external database issues
- Open the file project2app/src/main/resources/application-dev.properties and change lines 1 to the proper port number and 3 & 4 to be your postgres username and password