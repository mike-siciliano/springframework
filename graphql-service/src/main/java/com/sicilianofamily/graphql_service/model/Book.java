package com.sicilianofamily.graphql_service.model;

import java.util.Arrays;
import java.util.List;

public record Book(String id, String name, int pageCount, String authorId) {

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "The Black Swan", 401, "author-1"),
            new Book("book-2", "The Count of Monte Cristo", 1276, "author-2"),
            new Book("book-3", "Mindset", 320, "author-3")
    );

    public static Book getById(String id) {
        return books.stream()
                .filter(book -> book.id.equals(id))
                .findFirst()
                .orElse(null);
    }
}
