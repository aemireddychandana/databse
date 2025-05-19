//package com.chandu.database.repositories;
//
//
//import com.chandu.database.TestDataUtil;
//import com.chandu.database.domain.entities.AuthorEntity;
//import com.chandu.database.domain.entities.BookEntity;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class BookEntityRepositoryIntegrationTests {
//    private BookRepository underTest;
//    private AuthorRepository authorRepository;
//
//     @Autowired
//    public BookEntityRepositoryIntegrationTests(BookRepository underTest, AuthorRepository authorRepository){
//         this.underTest=underTest;
//         this.authorRepository=authorRepository;
//     }
//
//     @Test
//    public void testBookCreated(){
//         AuthorEntity authorEntity =TestDataUtil.createTestAuthorA();
//         authorRepository.save(authorEntity);
//         BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity);
//         underTest.save(bookEntity);
//
//         Optional<BookEntity> res=underTest.findById(bookEntity.getIsbn());
//         assertThat(res).isPresent();
//         assertThat(res.get()).isEqualTo(bookEntity);
//     }
//
//     @Test
//     public void testMultipleBooksCreated(){
//         AuthorEntity authorEntityA =TestDataUtil.createTestAuthorA();
//         authorRepository.save(authorEntityA);
//
//         BookEntity bookEntityA =TestDataUtil.createTestBookA(authorEntityA);
//         underTest.save(bookEntityA);
//
//         BookEntity bookEntityB =TestDataUtil.createTestBookB(authorEntityA);
//         underTest.save(bookEntityB);
//
//         BookEntity bookEntityC =TestDataUtil.createTestBookC(authorEntityA);
//         underTest.save(bookEntityC);
//
//         Iterable<BookEntity> res=underTest.findAll();
//
//         assertThat(res).hasSize(3).containsExactly(bookEntityA, bookEntityB, bookEntityC);
//
//     }
////
//     @Test
//    public void testUpdatedBooks(){
//         AuthorEntity authorEntity =TestDataUtil.createTestAuthorA();
//         authorRepository.save(authorEntity);
//         BookEntity bookEntity =TestDataUtil.createTestBookA(authorEntity);
//         underTest.save(bookEntity);
//         bookEntity.setTitle("Updated");
//         underTest.save(bookEntity);
//         Optional<BookEntity> res=underTest.findById(bookEntity.getIsbn());
//         assertThat(res).isPresent();
//         assertThat(res.get()).isEqualTo(bookEntity);
//     }
////
//     @Test
//    public void testDeletedBook(){
//         AuthorEntity authorEntity =TestDataUtil.createTestAuthorA();
//         authorRepository.save(authorEntity);
//         BookEntity bookEntity =TestDataUtil.createTestBookA(authorEntity);
//         underTest.deleteById(bookEntity.getIsbn());
//         Optional<BookEntity> res=underTest.findById(bookEntity.getIsbn());
//         assertThat(res).isEmpty();
//     }
//}
