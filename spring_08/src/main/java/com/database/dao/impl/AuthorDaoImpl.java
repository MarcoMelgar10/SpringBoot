package com.database.dao.impl;

import com.database.dao.AuthorDao;
import com.database.domain.Author;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorDaoImpl implements AuthorDao {
    private JdbcTemplate jdbcTemplate;
    public AuthorDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
            jdbcTemplate.update("INSERT INTO author (id, name, age) VALUES (?,?,?)", author.getId(), author.getName(), author.getAge());
    }

    @Override
    public Optional<Author> findOne(long authorId) {
        try {
            Author author = jdbcTemplate.queryForObject(
                    "SELECT id, name, age FROM author WHERE id = ?",
                    new AuthorRowMapper(),
                    authorId
            );
            return Optional.ofNullable(author);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Author> find() {
        return jdbcTemplate.query("SELECT id, name, age FROM author", new AuthorRowMapper());
    }

    public static class AuthorRowMapper implements RowMapper<Author>{

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }


}
