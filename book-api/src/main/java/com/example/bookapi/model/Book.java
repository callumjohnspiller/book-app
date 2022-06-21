package com.example.bookapi.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private List<String> editHistory = new ArrayList<String>();

    public List<String> getEditHistory() {
        return editHistory;
    }

    public void copyToHistory() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode state = mapper.createObjectNode();
        state.put("title", this.title);
        state.put("author", this.author);
        editHistory.add(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(state));
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
