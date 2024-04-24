package com.hendisantika.springbootrestapipostgresql.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastName;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "booksTitles")
    @Column(name = "Value")
    private List<String>  booksTitles = new ArrayList<>();

  public Author(String name, String lastName, List<String> booksTitles) {
        this.name = name;
        this.lastName = lastName;
        this. booksTitles= booksTitles;
  }
    public Author() {
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getBooks(){
        return  booksTitles;
    }
    public void setBookTitles(List<String>booksTitles){
        this.booksTitles=booksTitles;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books='" + booksTitles + '\'' +
                ", id=" + id +
                '}';
    }
}
