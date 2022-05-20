package com.ahmed.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmed.books.service.GenreService;
import com.ahmed.books.entities.Book;
import com.ahmed.books.entities.Genre;
import com.ahmed.books.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService livreService;

	@Autowired
	GenreService categorieService;

	
	@RequestMapping("/ListeBooks")
	public String listeLivres(ModelMap modelMap,
								@RequestParam(name = "page", defaultValue = "0") int page,
								@RequestParam(name = "size", defaultValue = "6") int size)
	{
		Page<Book> livs = livreService.getAllBooksParPage(page, size);
		modelMap.addAttribute("livres", livs);
		
		//
		List<Genre> cats = categorieService.getAllCategories();
		modelMap.addAttribute("categories", cats);
		//

		modelMap.addAttribute("pages", new int[livs.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		return "listeBooks";
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////
	@RequestMapping("/rechercherProduit")
	public String rechercherProduit(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "6") int size,
			@RequestParam("nomProd") String nomProd,
			@PageableDefault(page = 0, size = 6) Pageable pageable)

	{
	
	List<Book> pros = livreService.findByTitreLivreContains(nomProd);
	
	int start = (int) pageable.getOffset();
	int end = (int) ((start + pageable.getPageSize()) > pros.size() ? pros.size()
					: (start + pageable.getPageSize()));
	Page<Book> prods = new PageImpl<Book>(pros.subList(start, end), pageable, pros.size());
	
	//Ou bien 2eme methode
	//PagedListHolder<Produit> prods = new PagedListHolder(pros);
	//prods.setPageSize(10); // number of items per page
	//prods.setPage(0);

	
	// list of items on this page .getContent()
	modelMap.addAttribute("produits", prods.getContent());
	

	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("nomProd", nomProd);
	modelMap.addAttribute("mode", "nom");
	return "recherche";
	}
	/////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/rechercherProduitByCatId")
	public String rechercherProduitByCatId(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "6") int size,
			@RequestParam("id") Long id ,
			@PageableDefault(page = 0, size = 6) Pageable pageable)

	{
		
		List<Genre> cats = categorieService.getAllCategories();
		modelMap.addAttribute("categories", cats);
		
		List<Book> pros = livreService.findByGenreIdGen(id);
		int start = (int) pageable.getOffset();
		int end = (int) ((start + pageable.getPageSize()) > pros.size() ? pros.size()
						: (start + pageable.getPageSize()));
		Page<Book> prods = new PageImpl<Book>(pros.subList(start, end), pageable, pros.size());
		modelMap.addAttribute("produits", prods.getContent());
		

		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("id", id);
		modelMap.addAttribute("mode", "id");
		return "recherche";
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////
	
	
	
	@RequestMapping("/supprimerBook")
	public String supprimerLivre(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "10") int size)

	{
	livreService.deleteLivreById(id);
	Page<Book> livs = livreService.getAllBooksParPage(page, size);

	modelMap.addAttribute("livres", livs);
	modelMap.addAttribute("pages", new int[livs.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeBooks";
	}
	
	
	
	@RequestMapping("/modifierBook")
	public String editerLivre(@RequestParam("id") Long id, ModelMap modelMap/*, @RequestParam(name = "idc", defaultValue = "1") int idc*/) {
		
		Genre g = categorieService.getCategorie(livreService.getLivre(id).getGenre().getIdGen());
		modelMap.addAttribute("genre", g);
		
		Book l = livreService.getLivre(id);
		modelMap.addAttribute("book", l);
		
		List<Genre> cats= categorieService.getAllCategories();
		modelMap.addAttribute("categories", cats);
		
		//long idc = 1 ;//
		//modelMap.addAttribute("idc", idc);//
		/*Long idca = p.getCategorie().getIdCat();
		modelMap.addAttribute("idc", idca);*/
		
		modelMap.addAttribute("mode", "edit");
		return "formBook";
	}

	
	
	
	@RequestMapping("/creerBook")
	public String showCreate(ModelMap modelMap) {
		
		List<Genre> cats= categorieService.getAllCategories();
		modelMap.addAttribute("categories", cats);
		
		//modelMap.addAttribute("book", new Book());//
		//
		Book p = new Book();
		Genre cat = new Genre(0L,"Selectionnez","",null) ;
		p.setGenre(cat);
		modelMap.addAttribute("book", p);
		//
		
		//cats.add(0, cat);
		modelMap.addAttribute("mode", "new");
		return "formBook";
	}
	

	
	
	@RequestMapping("/saveBook")
	public String saveProduit(@Valid Book livre, BindingResult bindingResult//, long idc// /*, ModelMap modelMap*/
								)

	{
		//Genre ccc = categorieService.getCategorie(idc) ;//
		//livre.setGenre(ccc);//
		if (bindingResult.hasErrors())
			return "formBook";
		
		
		livreService.saveLivre(livre);
		
		/*int page = 0;
		int size = 2;
		Page<Produit> prods = produitService.getAllProduitsParPage(page, size);
		modelMap.addAttribute("produits", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeProduits";*/
		
		
		return "redirect:/ListeBooks";
		}

}
