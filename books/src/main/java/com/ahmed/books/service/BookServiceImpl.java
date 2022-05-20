package com.ahmed.books.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ahmed.books.entities.Genre;
import com.ahmed.books.entities.Book;
import com.ahmed.books.repos.BookRepository;


@Service
public class BookServiceImpl implements BookService{
	
	//odonné à sprint Injection une implementation des dependances 
	@Autowired
	BookRepository livreRepository; //objet pour CRUD
	

	@Override
	public Book saveLivre(Book l) {
		return livreRepository.save(l);
	}

	@Override
	public Book updateLivre(Book l) {
		return livreRepository.save(l);
	}

	@Override
	public void deleteLivre(Book l) {
		livreRepository.delete(l);
	}

	@Override
	public void deleteLivreById(Long id) {
		livreRepository.deleteById(id);
	}

	@Override
	public Book getLivre(Long id) {
		return livreRepository.findById(id).get();
	}

	@Override
	public List<Book> getAllLivres() {
		return livreRepository.findAll();
	}
	
	
	@Override
	public List<Book> findByTitreLivreContains(String titre) {
	return livreRepository.findByTitreLivreContains(titre);
	}
	/////////////////////////////////////////
	@Override
	public List<Book> findByGenre(Genre genre) {
	return livreRepository.findByGenre(genre);
	}
	@Override
	public List<Book> findByGenreIdGen(Long id) {
	return livreRepository.findByGenreIdGen(id);
	}



	
	
	@Override
	public Page<Book> getAllBooksParPage(int page, int size) {
		return livreRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Book> findByTitreLivre(String titre) {
		return livreRepository.findByTitreLivre(titre);
	}

	@Override
	public List<Book> findByTitreLivrePrix(String titre, Double prix) {
		return livreRepository.findByTitrePrix(titre, prix);
	}


	@Override
	public List<Book> findByOrderByTitreLivreAsc() {
		return livreRepository.findByOrderByTitreLivreAsc();
	}

	@Override
	public List<Book> trierBooksTitresPrix() {
		return livreRepository.trierBooksTitresPrix();
	}

}
