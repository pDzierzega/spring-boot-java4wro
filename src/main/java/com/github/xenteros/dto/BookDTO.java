package com.github.xenteros.dto;

public class BookDTO {

    private String title;
    private AuthorNoBooksDTO author;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorNoBooksDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorNoBooksDTO author) {
        this.author = author;
    }
}
