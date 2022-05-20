package com.ahmed.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ahmed.books.entities.Genre;
import com.ahmed.books.entities.Book;
import com.ahmed.books.repos.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	GenreRepository categorieRepository;


	@Override
	public Genre saveCategorie(Genre c) {
		return categorieRepository.save(c);
	}

	@Override
	public Genre updateCategorie(Genre c) {
		return categorieRepository.save(c);
	}

	@Override
	public void deleteCategoriet(Genre c) {
		categorieRepository.delete(c);
	}

	@Override
	public void deleteCategorieById(Long id) {
		categorieRepository.deleteById(id);
		
	}

	@Override
	public Genre getCategorie(Long id) {
		return categorieRepository.findById(id).get();
	}

	@Override
	public List<Genre> getAllCategories() {
		return categorieRepository.findAll();
	}

	@Override
	public Page<Genre> getAllCategoriesParPage(int page, int size) {
		return categorieRepository.findAll(PageRequest.of(page, size));
	}

	
	
}

