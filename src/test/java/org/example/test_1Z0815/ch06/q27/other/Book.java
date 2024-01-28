package org.example.test_1Z0815.ch06.q27.other;

public class Book {
    private String isbn;
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    protected void printInfo() {
        System.out.println("isbn = " + isbn);
    }
}
