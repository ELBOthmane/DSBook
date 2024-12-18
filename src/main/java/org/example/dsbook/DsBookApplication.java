package org.example.dsbook;

import org.example.dsbook.dto.BookDTO;
import org.example.dsbook.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DsBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsBookApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BookService bookService){
        return  args -> {
            bookService.saveBooks(
                    List.of(
                            BookDTO.builder().titre("model1").publisher("red").datePublication("sdf64w6e").price(12345).resume("rtrt").build(),
                            BookDTO.builder().titre("model2").publisher("ef6e+6").datePublication("green").price(65489).resume("rt").build(),
                            BookDTO.builder().titre("model3").publisher("ef64we8").datePublication("yellow").price(89789).resume("tr").build(),
                            BookDTO.builder().titre("model4").publisher("wrdqwqw").datePublication("black").price(67489).resume("yuy").build()
                    )

            );
        };
    }
}
