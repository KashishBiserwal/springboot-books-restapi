package booksApi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int a_id;
    @Column(name = "author_name")
    private String a_name;
    private String language;
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    public Author(int a_id, String a_name, String language, Book book) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.language = language;
        this.book = book;
    }

    public Author() {
    }

    public Author(int a_id, String a_name, String language) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.language = language;
    }

    public Author(String a_name, String language) {
        this.a_name = a_name;
        this.language = language;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "a_id=" + a_id +
                ", a_name='" + a_name + '\'' +
                ", language='" + language + '\'' +
                ", book=" + book +
                '}';
    }
}
