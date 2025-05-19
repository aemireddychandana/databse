package com.chandu.database.repositories;

import com.chandu.database.domain.entities.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity,Long> {

//    Iterable<AuthorEntity> ageLessThan(int age);
//
//    Iterable<AuthorEntity> ageGreaterThan(int age);
//
//    Iterable<AuthorEntity> ageEquals(int age);
//
//    @Query("SELECT a FROM Author a WHERE a.name=?1")
//    Iterable<AuthorEntity> nameAs(String name);
}
