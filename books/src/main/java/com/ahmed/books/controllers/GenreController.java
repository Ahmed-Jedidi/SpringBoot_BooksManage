package com.ahmed.books.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmed.books.entities.Genre;
import com.ahmed.books.entities.Book;
import com.ahmed.books.service.GenreService;
import com.ahmed.books.service.BookService;

@Controller
public class GenreController {
	
	@Autowired
	GenreService categorieService;
	
	@RequestMapping("/ListeGenres")
	public String listeCategories(
			ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size)
	{
		Page<Genre> gens = categorieService.getAllCategoriesParPage(page, size);
		modelMap.addAttribute("genres", gens);

		modelMap.addAttribute("pages", new int[gens.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		return "listeGenres";
	}

	@RequestMapping("/supprimerGenre")
	public String supprimerCategorie(@RequestParam("id") Long id,
			ModelMap modelMap, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size)
	{
		categorieService.deleteCategorieById(id);
		Page<Genre> gens = categorieService.getAllCategoriesParPage(page, size);

		modelMap.addAttribute("genres", gens);
		modelMap.addAttribute("pages", new int[gens.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeGenres";
	}
	
	
	
	
	@RequestMapping("/modifierGenre")
	public String editerCategorie(@RequestParam("id") Long id, ModelMap modelMap ) {
		Genre c = categorieService.getCategorie(id);
		modelMap.addAttribute("genre", c);
		
		//List<Genre> cats= categorieService.getAllCategories();
		//modelMap.addAttribute("categories", cats);
		
		modelMap.addAttribute("mode", "edit");
		return "formGenre";
	}
	
	@RequestMapping("/creerGenre")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("genre", new Genre());
		
		//List<Genre> cats= categorieService.getAllCategories();
		//modelMap.addAttribute("categories", cats);
		
		modelMap.addAttribute("mode", "new");
		return "formGenre";
	}
	
	
	
	
	@RequestMapping("/saveGenre")
	public String saveProduit(@Valid Genre categorie, BindingResult bindingResult /*, ModelMap modelMap*/)

	{
		if (bindingResult.hasErrors()) 
			return "formGenre";

		categorieService.saveCategorie(categorie);
		
		return "redirect:/ListeGenres";
		}
}
