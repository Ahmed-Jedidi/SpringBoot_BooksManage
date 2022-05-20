package com.ahmed.books.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ahmed.books.entities.Genre;

public interface GenreService {
	
	Genre saveCategorie(Genre c);
	Genre updateCategorie(Genre c);
	void deleteCategoriet(Genre c);
	void deleteCategorieById(Long id);
	Genre getCategorie(Long id);
	List<Genre> getAllCategories();

	
	Page<Genre> getAllCategoriesParPage(int page, int size);

}
