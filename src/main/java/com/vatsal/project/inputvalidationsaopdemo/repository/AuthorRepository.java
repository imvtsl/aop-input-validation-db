package com.vatsal.project.inputvalidationsaopdemo.repository;

import com.vatsal.project.inputvalidationsaopdemo.dto.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * A repository class to interact with author table in the db.
 * @author imvtsl
 * @since v1.0
 */

@Slf4j
@Repository
public class AuthorRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Returns all authors in the db.
     * @return List<Author>
     */
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query("select * from authors", new BeanPropertyRowMapper<>(Author.class));
    }

    /**
     * Returns author details for the given author.
     * @param id Integer
     * @return Optional<String>
     */
    public Optional<String> findById(Integer id) {
        try {
            Author result = jdbcTemplate.queryForObject("select * from authors where id = ?",
                    new BeanPropertyRowMapper<>(Author.class),
                    id);
            return Optional.of(result.getName());
        }
        catch (EmptyResultDataAccessException e) {
            log.debug("No record found in database for:"+ id, e);
            return Optional.empty();
        }
    }
}
