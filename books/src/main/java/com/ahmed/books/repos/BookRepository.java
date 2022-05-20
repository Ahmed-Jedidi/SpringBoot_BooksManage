package com.ahmed.books.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahmed.books.entities.Genre;
import com.ahmed.books.entities.Book;

//@RepositoryRestResource(path = "rest")
//faire toute les operation à travers ça
public interface BookRepository extends JpaRepository<Book, Long> {
	
	
	
	List<Book> findByTitreLivre(String titre);
	
	//List<Book> findByTitreLivreLike(String titre);
	//////////////////////////OU BIEN//////////////////////////////////
	List<Book> findByTitreLivreContains(String titre);
	
	
	
	@Query("select l from Book l where l.genre = ?1")
	List<Book> findByGenre(Genre genre);
	
	List<Book> findByGenreIdGen(Long id);
	
	
	
	
	
	
	
	
	
	
	
	
		@Query("select b from Book b where b.titreLivre like %?1 and b.prixLivre > ?2")
		List<Book> findByTitrePrix (String titre, Double prix);
		//////////////////////////OU BIEN//////////////////////////////////
		//@Query("select p from Book p where p.titreLivre like %:titre and p.prixProduit > :prix")
		//List<Book> findByTitrePrix (@Param("titre") String titre,@Param("prix") Double prix);
		
		

		
		
		List<Book> findByOrderByTitreLivreAsc();
		
		@Query("select b from Book b order by b.titreLivre ASC, b.prixLivre DESC")
		List<Book> trierBooksTitresPrix ();



}
