package com.bill.graphql.repository;

import com.bill.graphql.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author Bill.Lin on 2021/7/11
 */

@Repository
public class AuthorRepository {

    private R2dbcEntityTemplate template;

    public AuthorRepository(R2dbcEntityTemplate template) {
        this.template = template;
    }


    public Mono<Author> getAuthor(UUID bookId) {
        return template
                .select(Author.class)
                .matching(Query.query(Criteria.where("book_id").is(bookId))).one();
    }

    public Mono<UUID> createAuthor(Author author) {
        UUID authorId = UUID.randomUUID();
        author.setId(authorId);
        return template
                .insert(Author.class)
                .using(author)
                .thenReturn(authorId);
    }


}
