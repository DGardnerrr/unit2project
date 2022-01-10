package com.example.project2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//connect to postgres - database of book
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Float length;

    @Column
    private String release_date;

    //many to one
    @ManyToOne
    @JoinColumn(name="author_id")
    @JsonIgnore
    private Author author;

    @ManyToOne
    @JoinColumn(name="genre_id")
    @JsonIgnore
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    //default constructor
    public Book() {
    }

    public Book(Long id, String name, Float length, String release_date) {
        this.id = id;
        this.name = name;                  //book name
        this.length = length;              //length
        this.release_date = release_date;  //release date of book
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setGenre(Genre genre){this.genre = genre;}

    public Genre getGenre(){return genre;}
    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", release_date='" + release_date + '\'' +
                '}';
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author= author;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
