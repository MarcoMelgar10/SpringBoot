package com.database.dao;

import com.database.dao.impl.AuthorDaoImpl;
import com.database.dao.impl.BookDaoImpl;
import com.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreatedBookGeneratesCorrectSql(){
        Book book = new Book().builder()
                .isbn("990-2001-1001-0")
                .title("The hide castle")
                .authorId(1L)
                .build();

        underTest.create(book);

        verify(jdbcTemplate).update(eq("INSERT INTO book (isbn, title, authorId) VALUES (?,?,?)"),
                eq("990-2001-1001-0"),
                eq("The hide castle"),
                eq(1L));
    }

    @Test
    public void testThatFindBookGeneratesCorrectSql(){
        underTest.findOne("990-2001-1001-0");

        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM book WHERE isbn = ? LIMIT 1"), ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(), eq("990-2001-1001-0"));
    }
}
