package com.example.project2.service;

import com.example.project2.exception.InformationExistsException;
import com.example.project2.exception.InformationNotFoundException;
import com.example.project2.model.Author;
import com.example.project2.model.Book;
import com.example.project2.model.Genre;
import com.example.project2.model.Publisher;
import com.example.project2.repository.AuthorRepository;
import com.example.project2.repository.BookRepository;
import com.example.project2.repository.GenreRepository;
import com.example.project2.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;



//service layer incorporated for the controller
//incorporated exceptions into the service class
//purpose of service layer -
@Service
public class BookService {

    private static final Logger LOGGER = Logger.getLogger(BookService.class.getName());
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    private GenreRepository genreRepository;
    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    private AuthorRepository authorRepository;
    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private PublisherRepository publisherRepository;
    @Autowired
    public void setPublisherRepository(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    //===Books===//

    //get all books
    public List<Book> getBooks() {
        LOGGER.info("calling getBooks method from service");
        return bookRepository.findAll();
    }

   //get a single book
   public Optional getBook(Long bookId) {
       LOGGER.info("calling getBook method from service");
       Optional book = bookRepository.findById(bookId);
       if (book.isPresent()) {
           return book;
       } else {
           throw new InformationNotFoundException("book with id " + bookId + " not found");
       }
   }

   //create a book
    public Book createBook(Book bookObject) {
        LOGGER.info("calling createBook method from service");
        Book book = bookRepository.findByTitle(bookObject.getName());
        if (book != null) {
            throw new InformationExistsException("book with name " + book.getName() + " already exists");
        } else {
            return bookRepository.save(bookObject);
        }
    }

    //update a book
    public Book updateBook(Long bookId, Book bookObject) {
        LOGGER.info("service calling updateBook method ==> ");
        Optional<Book> book = bookRepository.findById(bookId);
        if (book == null) {
            throw new InformationNotFoundException("book with id " + bookId + " not found");


        } else {
            book.get().setName(bookObject.getName());
            return bookRepository.save(book.get());
        }
    }


    //delete a book
    public Optional<Book> deleteBook(Long bookId) {
        LOGGER.info("calling deleteBook method from service");
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            bookRepository.deleteById(bookId);
            return book;
        } else {
            throw new InformationNotFoundException("book with id: " + bookId + " not found");
        }
    }


    //===Authors==//

    //get all authors
    public List<Author> getAuthors() {
        LOGGER.info("calling getAuthors method from service");
        return authorRepository.findAll();
    }
    //get a single author
    public Optional getAuthor(Long authorId) {
        LOGGER.info("calling getAuthor method from service");
        Optional author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            return author;
        } else {
            throw new InformationNotFoundException("author with id " + authorId + " not found");
        }
    }

    //create book and add author's info(monthly books made, ex: part 1, part 2, part 3) to book
    public Author createAuthor(Long bookId, Author authorObject) {
        LOGGER.info("calling createAuthor method from service");
        try {
            Optional book = bookRepository.findById(bookId);

            authorObject.setMonthly_books((Book) book.get());

            return authorRepository.save(authorObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("Book with id " + bookId + "not found");
        }
    }


//update a author
public Author updateAuthor(Long authorId, Author authorObject) {
    LOGGER.info("calling updateAuthor method from service");
    Optional<Author> author = authorRepository.findById(authorId);
    if (author.isPresent()) {
        if (authorObject.getName().equals(author.get().getName())) {
            throw new InformationExistsException("author with name " + author.get().getName() + " already exist");
        } else {
            Author updateAuthor = authorRepository.findById(authorId).get();
            updateAuthor.setName(authorObject.getName());
            updateAuthor.setDescription(authorObject.getDescription());
            updateAuthor.setMonthly_books(authorObject.getMonthly_books());
            return authorRepository.save(updateAuthor);
        }
    } else {
        throw new InformationNotFoundException("author with id " + authorId + " not found");
    }

}



    //delete a author
    public Optional<Author> deleteAuthor(Long authorId) {
        LOGGER.info("calling deleteAuthor method ==>");
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            authorRepository.deleteById(authorId);
            return author;
        } else {
            throw new InformationNotFoundException("author with id: " + authorId + " not found");
        }
    }


    //==Genres==//
    //get all genres
    public List<Genre> getGenres() {
        LOGGER.info("calling getGenres method from service");
        return genreRepository.findAll();
    }

    //get a single genre
    public Optional getGenre(Long genreId) {
        LOGGER.info("calling getGenre method from service");
        Optional genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }

    //create book and a genre's description to the book
    public Genre createGenre(Long bookId, Genre genreObject) {
        LOGGER.info("calling createGenre method from service");
        try {
            Optional book = bookRepository.findById(bookId);

            genreObject.setDescription(String.valueOf((Book) book.get()));

            return genreRepository.save(genreObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("book with id " + bookId + " not found");
        }
    }

   //update a genre
   public Genre updateGenre(Long genreId, Genre genreObject) {
       LOGGER.info("calling updateGenre method from service");
       Optional<Genre> genre = genreRepository.findById(genreId);
       if (genre.isPresent()) {
           if (genreObject.getName().equals(genre.get().getName())) {
               throw new InformationExistsException("genre with name " + genre.get().getName() + " already exist");
           } else {
               Genre updateGenre = genreRepository.findById(genreId).get();
               updateGenre.setName(genreObject.getName());
               updateGenre.setDescription(genreObject.getDescription());
               return genreRepository.save(updateGenre);
           }
       } else {
           throw new InformationNotFoundException("genre with id " + genreId + " not found");
       }

   }


    //delete a genre
    public Optional<Genre> deleteGenre(Long genreId) {
        LOGGER.info("calling deleteGenre method from service");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            genreRepository.deleteById(genreId);
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id: " + genreId + " not found");
        }
    }


    //===Publishers===//
    //get all publishers
    public List<Publisher> getPublishers() {
        LOGGER.info("calling getPublishers method from service");
        return publisherRepository.findAll();
    }

    //get a single publisher
    public Optional getPublisher(Long publisherId) {
        LOGGER.info("calling getPublisher method from service");
        Optional publisher = publisherRepository.findById(publisherId);
        if (publisher.isPresent()) {
            return publisher;
        } else {
            throw new InformationNotFoundException("publisher with id " + publisherId + " not found");
        }
    }

    //create a book and add  publisher's info to the book
    public Publisher createPublisher(Long bookId, Publisher publisherObject) {
        LOGGER.info("calling createPublisher from service");
        try {
            Optional book = bookRepository.findById(bookId);
            publisherObject.setRevenue((Book) book.get());
            publisherObject.setNum_authors((Book) book.get());
            return publisherRepository.save(publisherObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("Book with id " + bookId + "not found");
        }
    }

    //update publisher
    public Publisher updatePublisher(Long publisherId, Publisher publisherObject) {
        LOGGER.info("service calling updatePublisher method ==> ");
        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        if (publisher.isPresent()) {
            if (publisherObject.getName().equals(publisher.get().getName())) {
                throw new InformationExistsException("publisher with name " + publisher.get().getName() + " already exist");
            } else {
                Publisher updatePublisher = publisherRepository.findById(publisherId).get();
                updatePublisher.setName(publisherObject.getName());
                updatePublisher.setRevenue(publisherObject.getRevenue());
                updatePublisher.setNum_authors(publisherObject.getNum_authors());
                return publisherRepository.save(updatePublisher);
            }
        } else {
            throw new InformationNotFoundException("publisher with id " + publisherId + " not found");
        }

    }


    //delete a publisher
    public Optional<Publisher> deletePublisher(Long publisherId) {
        LOGGER.info("calling deletePublisher method from service");
        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        if (publisher.isPresent()) {
            publisherRepository.deleteById(publisherId);
            return publisher;
        } else {
            throw new InformationNotFoundException("publisher with id: " + publisherId + " not found");
        }
    }

}






