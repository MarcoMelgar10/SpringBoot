package com.database.dao.impl;

import com.database.dao.BookDao;
import com.database.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate jdbcTemplate;
    public BookDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO book (isbn, title, authorId) VALUES (?,?,?)",
                    book.getIsbn(),
                    book.getTitle(),
                    book.getAuthorId());
    }

    @Override
    public Optional<Book> findOne(String isbn) {
        List<Book> result = jdbcTemplate.query("SELECT id, name, age FROM book WHERE isbn = ? LIMIT 1", new BookRowMapper(),isbn );
        return result.stream().findFirst();
    }

    public static class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .isbn("990-2001-1001-0")
                    .title("The hide castle")
                    .authorId(1L)
                    .build();
        }
    }

}
