package org.example.dsbook.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String titre;
        private String publisher;
        private String datePublication;
        private float price;
        private String resume;

}
