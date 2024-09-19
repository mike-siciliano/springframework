package com.sicilianofamily.graphql_service;

import com.sicilianofamily.graphql_service.model.Author;
import com.sicilianofamily.graphql_service.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    /*
     *  Example:
     *  [POST] localhost:8080/graphql?path=/graphql
     *  query bookDetails {
     *      bookById(id: "book-1") {
     *          id
     *          name
     *          pageCount
     *          author {
     *              id
     *              firstName
     *             lastName
     *          }
     *     }
     *  }
     *
     */

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }
}
