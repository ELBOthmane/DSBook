package org.example.dsbook.service;

import org.example.dsbook.dto.BookDTO;

import java.util.List;

public interface BookService {
    /**
     * Saves a book and returns the saved BookDTO.
     *
     * @param bookDTO the book details to save
     * @return the saved BookDTO
     */
    BookDTO saveBook(BookDTO bookDTO);

    /**
     * Deletes a book by its ID.
     *
     * @param id the ID of the book to delete
     * @return true if the deletion was successful, false otherwise
     */

    /**
     * Retrieves a list of books by model.
     *
     * @param model the model to search for
     * @return a list of BookDTOs matching the model
     */
    List<BookDTO> getBookByModel(String model);

    boolean deleteBook(String id);

    List<BookDTO> getBookByTitre(String titre);

    public List<BookDTO> getBookByTitreAndPublisher(String titre, String publisher);
    boolean deleteBook(Long id);

    /**
     * Saves multiple books and returns the saved BookDTOs.
     *
     * @param bookDTOS the list of book details to save
     * @return a list of saved BookDTOs
     */
    List<BookDTO> saveBooks(List<BookDTO> bookDTOS);
}
