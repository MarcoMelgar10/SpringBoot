package com.database.dao;

import com.database.TestDataUtil;
import com.database.dao.impl.AuthorDaoImpl;
import com.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

//It's like simulation of a real class to compare with the real class (Or specific method)
@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreatedAuthorGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthorA();


    underTest.create(author);

    verify(jdbcTemplate).update(eq("INSERT INTO author (id, name, age) VALUES (?,?,?)"),
                eq(1l), eq("Jorge Salas"), eq(25)
    );//This is where the comparison happens.

    }

    @Test
    public void testThatFineOneGenerateTheCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM author WHERE id = ? LIMIT 1"), ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(), eq(1L));
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM author"), ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any());
    }


    /*
    You’re testing that:
	When the create() method is called on AuthorDaoImpl,
	It generates the correct SQL command,
	And it uses the right values (id, name, age) to insert into the database.

    You’re not testing the real database, you’re just making sure the method calls the database layer correctly.
     */


}
