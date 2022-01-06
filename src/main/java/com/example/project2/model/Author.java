package com.example.project2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

//connect to postgres - database of author
@Entity
@Table(name="authors")
public class Author {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int monthly_books;

//many to one
    @ManyToOne
    @JoinColumn(name="publisher_id")
    @JsonIgnore
    private Publisher publisher;

    //one to many
    @OneToMany(mappedBy = "author", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Book> bookList;

    public Author() {
    }

    public Author(Long id, String name, String description, int monthly_books) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monthly_books = monthly_books;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMonthly_books() {
        return monthly_books;
    }

    public void setMonthly_books(int monthly_books) {
        this.monthly_books = monthly_books;
    }










}
