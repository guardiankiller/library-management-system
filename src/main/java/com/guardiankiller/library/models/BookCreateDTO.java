package com.guardiankiller.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

// DTO Data transfer object
public class BookCreateDTO {

    private String title;
    private String description;
    private String author;
    private LocalDate releaseDate;
    private String publisher;
    private String ISBN;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    @JsonProperty("ISBN")
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
