package com.chandu.database.mappers.impl;

import com.chandu.database.domain.dto.BookDto;
import com.chandu.database.domain.entities.BookEntity;
import com.chandu.database.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDto> {
    private ModelMapper modelMapper;


    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto mapTo(BookEntity bookEntity) {
        return modelMapper.map(bookEntity,BookDto.class);
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto,BookEntity.class);
    }
}
