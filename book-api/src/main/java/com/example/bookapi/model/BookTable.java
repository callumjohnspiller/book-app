package com.example.bookapi.model;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

public class BookTable {

    private static List<Book> bookList = new ArrayList<>();

    public BookTable() {
        Book book = new Book("Some", "Data");
        bookList.add(book);
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void deleteBook(int index) {
        try {
            bookList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    public void editBook(int index, Book changedBook) throws JsonProcessingException {
        bookList.get(index).copyToHistory();
        bookList.get(index).setTitle(changedBook.getTitle());
        bookList.get(index).setAuthor(changedBook.getAuthor());
    }

    public List<Book> getBooks() {
        return bookList;
    }

}
