package com.bill.graphql.model;

import com.bill.graphql.type.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

/**
 * @author Bill.Lin on 2021/7/11
 */
@Data
@NoArgsConstructor
@Table("books")
public class Book {

    @Id
    private UUID id;
    private String name;
    private int pages;
    private Category category;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }
}
