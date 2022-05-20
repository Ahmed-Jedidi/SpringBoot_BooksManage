package com.ahmed.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.ahmed.books.entities.Book;
import com.ahmed.books.entities.Genre;


@SpringBootApplication
public class BooksApplication {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;


	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	
	
	public void run(String... args) throws Exception {
	/*produitService.saveProduit(new Produit("PC Dell", 2600.0, new Date()));
	produitService.saveProduit(new Produit("PC Asus", 2800.0, new Date()));
	produitService.saveProduit(new Produit("Imprimante Epson", 900.0, new Date()));*/
		repositoryRestConfiguration.exposeIdsFor(Book.class);
		repositoryRestConfiguration.exposeIdsFor(Genre.class);
	}

}
