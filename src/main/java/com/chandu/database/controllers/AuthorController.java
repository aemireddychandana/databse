package com.chandu.database.controllers;

import com.chandu.database.domain.dto.AuthorDto;
import com.chandu.database.domain.entities.AuthorEntity;
import com.chandu.database.mappers.Mapper;
import com.chandu.database.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private AuthorService authorService;

    private Mapper<AuthorEntity,AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity,AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper=authorMapper;
    }

    @PostMapping(path="/authors")
    //to resolve different status error like 200/201 we use responseEntity
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        AuthorEntity authorEntity=authorMapper.mapFrom(authorDto);
        AuthorEntity result=authorService.createAuthor(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(result), HttpStatus.CREATED);
    }

    @GetMapping(path="/authors")
    public List<AuthorDto> findAllAuthors(){
        List<AuthorEntity> authors=authorService.findAll();
        return authors.stream().map(authorMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path="/authors/{id}")
    public ResponseEntity<AuthorDto> findAuthor(
            @PathVariable("id") Long id){
        Optional<AuthorEntity> find=authorService.findOne(id);
        return find.map(authorEntity -> {
            AuthorDto authorDto=authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
