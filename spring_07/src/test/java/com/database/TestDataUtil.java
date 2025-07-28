package com.database;

import com.database.domain.Author;

public final class TestDataUtil {
    private TestDataUtil(){}


    public static Author createTestAuthor() {
        return new Author().builder()
                .id(1L)
                .name("Jorge Salas")
                .age(25)
                .build();
    }
}
