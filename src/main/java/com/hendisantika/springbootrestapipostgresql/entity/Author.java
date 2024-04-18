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
    @CollectionTable(name = "isbn")
    @Column(name = "Value")
    private List<String> isbn = new ArrayList<>();

    public Author(String name, String lastName, List<String> isbn) {
        this.name = name;
        this.lastName = lastName;
        this.isbn = isbn;
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

    public List<String> getIsbn() {
        return isbn;
    }

    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Author{" +
                ", name='" + name + '\'' +
                ", last name='" + lastName + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
