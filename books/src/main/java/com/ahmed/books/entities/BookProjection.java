package com.ahmed.books.entities;

import org.springframework.data.rest.core.config.Projection;

import com.ahmed.books.entities.Book;

@Projection(name = "nomBo", types = { Book.class })
public interface BookProjection {
	public String getNomBook();
}