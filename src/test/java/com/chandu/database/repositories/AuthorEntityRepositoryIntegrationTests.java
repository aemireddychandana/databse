//package com.chandu.database.repositories;
//
//import com.chandu.database.TestDataUtil;
//import com.chandu.database.domain.entities.AuthorEntity;
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
//public class AuthorEntityRepositoryIntegrationTests {
//
//    private AuthorRepository underTest;
//
//    @Autowired
//    public AuthorEntityRepositoryIntegrationTests(AuthorRepository underTest) {
//        this.underTest = underTest;
//    }
//    @Test
//    public void testAuthorCreated() {
//        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
//        underTest.save(authorEntity);
//        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(authorEntity);
//    }
//
//
//    @Test
//    public void testMultipleAuthorsCreated(){
//        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
//        underTest.save(authorEntityA);
//        AuthorEntity authorEntityB =TestDataUtil.createTestAuthorB();
//        underTest.save(authorEntityB);
//        AuthorEntity authorEntityC =TestDataUtil.createTestAuthorC();
//        underTest.save(authorEntityC);
//        Iterable<AuthorEntity> res=underTest.findAll();
//        assertThat(res).hasSize(3).containsExactly(authorEntityA, authorEntityB, authorEntityC);
//
//    }
////
//    @Test
//    public void testUpdatedAuthor(){
//        AuthorEntity authorEntityA =TestDataUtil.createTestAuthorA();
//        underTest.save(authorEntityA);
//        authorEntityA.setName("Updatedd");
//        underTest.save(authorEntityA);
//        Optional<AuthorEntity> res=underTest.findById(authorEntityA.getId());
//        assertThat(res).isPresent();
//        assertThat(res.get()).isEqualTo(authorEntityA);
//    }
//    @Test
//    public void testDeletedAuthor(){
//        AuthorEntity authorEntity =TestDataUtil.createTestAuthorA();
//        underTest.save(authorEntity);
//        underTest.delete(authorEntity);
//        Optional<AuthorEntity> res=underTest.findById(authorEntity.getId());
//        assertThat(res).isEmpty();
//
//    }
//
//    @Test
//    public void testAgeLess(){
//        AuthorEntity authorEntityA =TestDataUtil.createTestAuthorA();
//        underTest.save(authorEntityA);
//        AuthorEntity authorEntityB =TestDataUtil.createTestAuthorB();
//        underTest.save(authorEntityB);
//        AuthorEntity authorEntityC =TestDataUtil.createTestAuthorC();
//        underTest.save(authorEntityC);
//        Iterable<AuthorEntity> res= underTest.ageLessThan(50);
//        Iterable<AuthorEntity> res1=underTest.ageGreaterThan(50);
//        assertThat(res).containsExactly(authorEntityB, authorEntityC);
//        assertThat(res1).containsExactly(authorEntityA);
//        Iterable<AuthorEntity> res2=underTest.ageEquals(23);
//        assertThat(res2).containsExactly(authorEntityB);
//
//    }
//
//    @Test
//    public void testAuthorName(){
//        AuthorEntity authorEntityA =TestDataUtil.createTestAuthorA();
//        underTest.save(authorEntityA);
//        AuthorEntity authorEntityB =TestDataUtil.createTestAuthorB();
//        underTest.save(authorEntityB);
//        AuthorEntity authorEntityC =TestDataUtil.createTestAuthorC();
//        underTest.save(authorEntityC);
//        Iterable<AuthorEntity> res=underTest.nameAs("Trisha");
//        assertThat(res).containsExactly(authorEntityC);
//
//    }
//}