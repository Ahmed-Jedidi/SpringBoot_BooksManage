package com.ahmed.books.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
	//cle primere
	@Id
	//auto incrementation
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idGen;
	
	@NotNull
	@Size (min = 2,max = 30)
	private String nomGen;
	
	@NotNull
	@Size (min = 2, max = 100)
	private String descriptionGen;
	//
	@JsonIgnore
	@OneToMany (mappedBy = "genre")
	private List<Book> livres;
	@Override
	public String toString() {
		return "Genre [idGen=" + idGen + ", nomGen=" + nomGen + ", descriptionGen=" + descriptionGen + "]";
	}
	
	/*
	//Constructeur
	public Genre() {
		super();
	}
	
	
	
	//Getters & setters
	public Long getIdGen() {
		return idGen;
	}
	public void setIdGen(Long idGen) {
		this.idGen = idGen;
	}
	public String getNomGen() {
		return nomGen;
	}
	public void setNomGen(String nomGen) {
		this.nomGen = nomGen;
	}*/
	

	
}


	
