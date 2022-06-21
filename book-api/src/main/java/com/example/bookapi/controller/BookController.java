package com.example.bookapi.controller;

import com.example.bookapi.model.Book;
import com.example.bookapi.model.BookTable;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    BookTable bookTable = new BookTable();

    @GetMapping("/helloWorld") //GET request to this URL runs this method
    public String helloWorld() {
        return "Hello World";
    }

    //curly braces brings in name as a variable
    // /hello/Callum => name = Callum
    @GetMapping("/hello/{name}")
    public String greeting(@PathVariable String name) { //Path variable tag resolves to variable in path
        return "Hello " + name;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookTable.getBooks();
    }

    @GetMapping("book-edit-history/{index}")
    public List<String> getBookEditHistory(@PathVariable int index) {
        return bookTable.getBooks().get(index).getEditHistory();
    }

    @PostMapping("/add-book")
    public void addBook(@RequestBody Book newBook) { //request body
        bookTable.addBook(newBook);
    }

    @DeleteMapping("delete-book/{index}")
    public void deleteBook(@PathVariable int index) {
        try {
            bookTable.deleteBook(index);
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }

    @PutMapping("edit-book/{index}")
    public void editBook(@PathVariable int index, @RequestBody Book changedBook) {
        try {
            bookTable.editBook(index, changedBook);
        } catch (RuntimeException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
