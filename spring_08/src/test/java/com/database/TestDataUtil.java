package com.database;

import com.database.domain.Author;

public final class TestDataUtil {
    private TestDataUtil(){}


    public static Author createTestAuthorA() {
        return new Author().builder()
                .id(1L)
                .name("Jorge Salas")
                .age(25)
                .build();
    }
    public static Author createTestAuthorB() {
        return new Author().builder()
                .id(2L)
                .name("Mark Serring")
                .age(30)
                .build();
    }
    public static Author createTestAuthorC() {
        return new Author().builder()
                .id(3L)
                .name("John Markell")
                .age(89)
                .build();
    }


}
