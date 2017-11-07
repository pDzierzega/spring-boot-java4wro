package com.github.xenteros.exception;

public class AuthorNotFoundException extends RuntimeException {

    private String authorUuid;

    public AuthorNotFoundException(String authorUuid) {
        this.authorUuid = authorUuid;
    }

    public String getAuthorUuid() {
        return authorUuid;
    }

    public void setAuthorUuid(String authorUuid) {
        this.authorUuid = authorUuid;
    }

}
