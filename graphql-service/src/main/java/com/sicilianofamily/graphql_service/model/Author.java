package com.sicilianofamily.graphql_service.model;

import java.util.Arrays;
import java.util.List;

public record Author(String id, String firstName, String lastName) {

    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Nassim", "Talib"),
            new Author("author-2", "Alexandre", "Dumas"),
            new Author("author-3", "Carol", "Dweck")
    );

    public static Author getById(String id) {
        return authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
