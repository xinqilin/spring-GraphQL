package com.bill.graphql.service;

import com.bill.graphql.model.Author;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author Bill.Lin on 2021/7/11
 */

public interface AuthorService {

    public Mono<String> createAuthor(String authorName, int age, UUID bookId);

    public DataFetcher<CompletableFuture<Author>> authorDataFetcher();
}
