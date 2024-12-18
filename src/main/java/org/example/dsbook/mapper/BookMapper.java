package org.example.dsbook.mapper;

import org.example.dsbook.dao.entities.Book;
import org.example.dsbook.dto.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public BookDTO fromBookToBookDTO(Book book){
        return modelMapper.map(book, BookDTO.class);
    }

    public Book fromBookDTOToBook(BookDTO bookDTO){
        return modelMapper.map(bookDTO, Book.class);
    }
}