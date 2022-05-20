package com.ahmed.books.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ahmed.books.entities.Genre;

import com.ahmed.books.entities.Book;

public interface BookService {
	
	Book saveLivre(Book l);
	Book updateLivre(Book l);
	void deleteLivre(Book l);
	void deleteLivreById(Long id);
	Book getLivre(Long id);
	List<Book> getAllLivres();


	Page<Book> getAllBooksParPage(int page, int size);
	
	List<Book> findByTitreLivre(String titre);
	List<Book> findByTitreLivreContains(String titre);
	
	List<Book> findByGenre (Genre genre);
	List<Book> findByGenreIdGen(Long id);
	
	

	List<Book> findByTitreLivrePrix (String titre, Double prix);

	List<Book> findByOrderByTitreLivreAsc();
	List<Book> trierBooksTitresPrix();
	
}
