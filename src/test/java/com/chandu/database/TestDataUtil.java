package com.chandu.database;

import com.chandu.database.domain.dto.AuthorDto;
import com.chandu.database.domain.dto.BookDto;
import com.chandu.database.domain.entities.AuthorEntity;
import com.chandu.database.domain.entities.BookEntity;

public final class TestDataUtil {
    private TestDataUtil(){
    }

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .name("Anushka")
                .age(80)
                .build();
    }
    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()

                .name("Samantha")
                .age(23)
                .build();
    }
    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .name("Trisha")
                .age(38)
                .build();
    }


    public static BookEntity createTestBookEntityA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1234-5678")
                .title("Book1")
                .authorEntity(authorEntity)
                .build();
    }
    public static BookDto createTestBookDtoA(final AuthorDto author) {
        return BookDto.builder()
                .isbn("1234-5678")
                .title("Book1")
                .author(author)
                .build();
    }
    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("ABCD-EFGH")
                .title("Book2")
                .authorEntity(authorEntity)
                .build();
    }
    public static BookEntity createTestBookC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("IJKL-MNOP")
                .title("Book3")
                .authorEntity(authorEntity)
                .build();
    }
}
