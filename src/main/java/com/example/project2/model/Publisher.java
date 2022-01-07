package com.example.project2.model;

//connect to postgres - database of publisher

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="publishers")
public class Publisher {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;      //Id

    @Column
    private String name;    //publisher name

    @Column
    private int num_authors;  //number authors for each publisher

    @Column
    private int revenue;    //revenue made

    //one to many
    @OneToMany(mappedBy = "publisher", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Author> authorList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    //default constructor
    public Publisher() {
    }

    public Publisher(Long id, String name, int num_authors, int revenue) {
        this.id = id;
        this.name = name;
        this.num_authors = num_authors;
        this.revenue = revenue;
    }

    //setters and getters
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

    public int getNum_authors() {
        return num_authors;
    }

    public void setNum_authors(int num_authors) {
        this.num_authors = num_authors;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }













}
