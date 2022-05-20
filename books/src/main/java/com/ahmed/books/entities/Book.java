package com.ahmed.books.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;

//import org.springframework.format.annotation.DateTimeFormat;

/////////////////////////////////////////////////////
/*Lombok*/
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
 @NoArgsConstructor
 @AllArgsConstructor
////////////////////////////////////////////////////

@Entity
public class Book {
	//cle primere
	@Id
	//auto incrementation
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idLivre;
	@Min(value = 1)
	@Max(value = 999999999)
    private long isbnLivre;
	@NotNull
	@Size (min = 4,max = 15)
    private String titreLivre;
	@NotNull
	@Size (min = 4,max = 15)
    private String auteurLivre;
	
	@Max(value = 9999)
	@Min(value = 1)
    private Double prixLivre;
    //@DateTimeFormat(pattern = "MM/dd/yyyy")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date datePublication;
    
    ////////////////////////////////////////////////////////////////////////
    @ManyToOne
    private Genre genre;
    //Getter & setter de produit
    public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Book [idLivre=" + idLivre + ", isbnLivre=" + isbnLivre + ", titreLivre=" + titreLivre + ", auteurLivre="
				+ auteurLivre + ", prixLivre=" + prixLivre + ", datePublication=" + datePublication + ", genre=" + genre
				+ "]";
	}
	
    ////////////////////////////////////////////////////////////////////
	

    
	/*public long getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(long idLivre) {
		this.idLivre = idLivre;
	}
	public long getIsbnLivre() {
		return isbnLivre;
	}
	public void setIsbnLivre(long isbnLivre) {
		this.isbnLivre = isbnLivre;
	}
	public String getTitreLivre() {
		return titreLivre;
	}
	public void setTitreLivre(String titreLivre) {
		this.titreLivre = titreLivre;
	}
	public String getAuteurLivre() {
		return auteurLivre;
	}
	public void setAuteurLivre(String auteurLivre) {
		this.auteurLivre = auteurLivre;
	}
	public Double getPrixLivre() {
		return prixLivre;
	}
	public void setPrixLivre(Double prixLivre) {
		this.prixLivre = prixLivre;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	
	
	
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Rq Contructeur utilise Field n'existe pas pour idLivre car auto incrementation
	public Livre(long isbnLivre, String titreLivre, String auteurLivre, Double prixLivre, Date datePublication, Genre genre ) {
		super();
		this.isbnLivre = isbnLivre;
		this.titreLivre = titreLivre;
		this.auteurLivre = auteurLivre;
		this.prixLivre = prixLivre;
		this.datePublication = datePublication;
		this.genre = genre;
	}
	
	// toString
	@Override
	public String toString() {
		return "Livre [idLivre=" + idLivre + ", isbnLivre=" + isbnLivre + ", titreLivre=" + titreLivre
				+ ", auteurLivre=" + auteurLivre + ", prixLivre=" + prixLivre + ", datePublication=" + datePublication
				+ ", genre=" + genre + "]";
	}*/
}
