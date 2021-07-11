package com.bill.graphql.service.impl;

import com.bill.graphql.model.Book;
import com.bill.graphql.repository.BookRepository;
import com.bill.graphql.service.AuthorService;
import com.bill.graphql.service.BookService;
import com.bill.graphql.type.Category;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author Bill.Lin on 2021/7/11
 */

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public DataFetcher<CompletableFuture<Book>> getBook() {
        return env -> {
            String bookId = env.getArgument("id");
            return bookRepository.getBook(UUID.fromString(bookId)).toFuture();
        };
    }

    public DataFetcher<CompletableFuture<List<Book>>> getBooks() {
        return env -> bookRepository.getBooks().collectList().toFuture();
    }

    public DataFetcher<CompletableFuture<String>> createBook() {
        return env -> {
            String bookName = env.getArgument("bookName");
            String authorName = env.getArgument("authorName");

            int pages = env.getArgument("pages");
            int age = env.getArgument("age");
            Category category = Category.valueOf(env.getArgument("category"));

            Book book = new Book();
            book.setName(bookName);
            book.setPages(pages);
            book.setCategory(category);

            return bookRepository.createBook(book).flatMap(
                    bookId -> authorService.createAuthor(authorName, age, bookId)
                            .map(authorId -> bookId.toString()))
                    .toFuture();
        };
    }
}
