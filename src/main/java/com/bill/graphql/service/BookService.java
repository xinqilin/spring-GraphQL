package com.bill.graphql.service;

import com.bill.graphql.model.Book;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author Bill.Lin on 2021/7/11
 */

@Service
public interface BookService {

    public DataFetcher<CompletableFuture<Book>> getBook();

    public DataFetcher<CompletableFuture<List<Book>>> getBooks();

    public DataFetcher<CompletableFuture<String>> createBook();
}
