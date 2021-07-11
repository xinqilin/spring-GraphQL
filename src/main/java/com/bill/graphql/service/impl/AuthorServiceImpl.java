package com.bill.graphql.service.impl;

import com.bill.graphql.model.Author;
import com.bill.graphql.model.Book;
import com.bill.graphql.repository.AuthorRepository;
import com.bill.graphql.service.AuthorService;
import graphql.schema.DataFetcher;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author Bill.Lin on 2021/7/11
 */
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    public Mono<String> createAuthor(String authorName, int age, UUID bookId) {
        Author author = new Author();
        author.setAge(age);
        author.setName(authorName);
        author.setBookId(bookId);
        return repository.createAuthor(author).map(Object::toString);
    }

    public DataFetcher<CompletableFuture<Author>> authorDataFetcher() {
        return env -> {
            Book book = env.getSource();
            return repository.getAuthor(book.getId()).toFuture();
        };
    }
}
