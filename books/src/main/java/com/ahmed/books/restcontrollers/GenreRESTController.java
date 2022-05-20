package com.ahmed.books.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.books.entities.Genre;
import com.ahmed.books.entities.Book;
import com.ahmed.books.service.GenreService;
import com.ahmed.books.service.BookService;

@RestController
@RequestMapping("/apig")

@CrossOrigin
public class GenreRESTController {
	
	@Autowired
	// Un objet qui implemente cette interface
	GenreService categorieService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Genre> getAllCategories() {
		return categorieService.getAllCategories();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Genre getCategorieById(@PathVariable("id") Long id) {
		return categorieService.getCategorie(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Genre createCategorie(@RequestBody Genre categorie) {
		return categorieService.saveCategorie(categorie);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Genre updateCategorie(@RequestBody Genre categorie) {
		return categorieService.updateCategorie(categorie);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCategorieById(@PathVariable("id") Long id) {
		categorieService.deleteCategorieById(id);
	}
	
	/*@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Categorie> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
	return categorieService.findByCategorieIdCat(idCat);
	}*/

}
