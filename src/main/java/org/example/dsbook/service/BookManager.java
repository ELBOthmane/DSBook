package org.example.dsbook.service;

import lombok.AllArgsConstructor;
import org.example.dsbook.dao.entities.Book;
import org.example.dsbook.dao.repositories.BookRepository;
import org.example.dsbook.dto.BookDTO;
import org.example.dsbook.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookManager implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.fromBookDTOToBook(bookDTO);
        book = bookRepository.save(book);
        return bookMapper.fromBookToBookDTO(book);
    }


    @Override
    public List<BookDTO> getBookByModel(String titre) {
        List<Book> books = bookRepository.findByTitre(titre); // Adjusted based on assumed repo method
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            bookDTOS.add(bookMapper.fromBookToBookDTO(book)); // Added missing list additions
        }
        return bookDTOS;
    }

    @Override
    public boolean deleteBook(String id) {
        try {
            bookRepository.deleteById(String.valueOf(Long.parseLong(id))); // Ensured type consistency
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<BookDTO> getBookByTitre(String titre) {
        List<Book> books = bookRepository.findByTitre(titre);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            bookDTOS.add(bookMapper.fromBookToBookDTO(book)); // Added missing list additions
        }
        return bookDTOS;
    }

    @Override
    public List<BookDTO> getBookByTitreAndPublisher(String titre, String publisher) {
        List<Book> books = bookRepository.findByTitreAndPublisher(titre, publisher);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            bookDTOS.add(bookMapper.fromBookToBookDTO(book)); // Added missing list additions
        }
        return bookDTOS;
    }

    @Override
    public boolean deleteBook(Long id) {
        return false;
    }

    @Override
    public List<BookDTO> saveBooks(List<BookDTO> bookDTOS) {
        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOS) {
            books.add(bookMapper.fromBookDTOToBook(bookDTO)); // Added missing list additions
        }
        books = bookRepository.saveAll(books);

        List<BookDTO> savedBookDTOS = new ArrayList<>();
        for (Book book : books) {
            savedBookDTOS.add(bookMapper.fromBookToBookDTO(book)); // Added missing list additions
        }
        return savedBookDTOS;
    }
}
