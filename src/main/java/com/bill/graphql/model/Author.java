package com.bill.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

/**
 * @author Bill.Lin on 2021/7/11
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("authors")
public class Author {

    @Id
    private UUID id;
    private String name;
    private int age;

    @Column("book_id")
    private UUID bookId;

}
