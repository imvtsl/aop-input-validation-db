package com.vatsal.project.inputvalidationsaopdemo.repository;

import com.vatsal.project.inputvalidationsaopdemo.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * A repository class to interact with books table in the db.
 * @author imvtsl
 * @since v1.0
 */

@Slf4j
@Repository
public class BookRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Inserts book record.
     * @param book Book
     */
    public void insert(Book book) {
        jdbcTemplate.update(
                "insert into books(name, created_by) values(?, ?)",
                book.getName(), book.getCreatedBy());
    }
}
