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
import com.ahmed.books.service.BookService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookRESTcontroller {
	
	@Autowired
	BookService livreService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Book> getAllLives()
	{
		return livreService.getAllLivres();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Book getLivreById(@PathVariable("id") Long id) {
	return livreService.getLivre(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Book createLivre(@RequestBody Book livre) {
	return livreService.saveLivre(livre);
	}
	
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public Book updateLivre(@RequestBody Book livre) {
	return livreService.updateLivre(livre);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteLivre(@PathVariable("id") Long id)
	{
	livreService.deleteLivreById(id);
	}
	
	@RequestMapping(value="/livsgen/{idGen}",method = RequestMethod.GET)
	public List<Book> getLivresByGenId(@PathVariable("idGen") Long idGen) {
	return livreService.findByGenreIdGen(idGen);
	}
	

	
	@RequestMapping(value="/livstitre/{titreLivre}",method = RequestMethod.GET)
	public List<Book> findByTitreLivreContains(@PathVariable("titreLivre") String titreLivre) {
	return livreService.findByTitreLivreContains(titreLivre);
	}
	
	
	
}
