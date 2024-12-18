package org.example.dsbook.web;

import lombok.AllArgsConstructor;
import org.example.dsbook.dto.BookDTO;
import org.example.dsbook.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookGraphQLController {

    private BookService bookService ;

    @MutationMapping
    public BookDTO saveBook(@Argument BookDTO book){
        return bookService.saveBook(book);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id){
        return bookService.deleteBook(id);
    }


    @QueryMapping
    public List<BookDTO> getBookByTitre(@Argument String titre){
        return bookService.getBookByModel(titre);
    }

    @QueryMapping
    public List<BookDTO> getBookByTitreAndPublisher(@Argument String titre, @Argument String publisher){
        return bookService.getBookByTitreAndPublisher(titre, publisher);
    }
}