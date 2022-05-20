package com.ahmed.books.entities;

import org.springframework.data.rest.core.config.Projection;

import com.ahmed.books.entities.Genre;

@Projection(name = "nomGe", types = { Genre.class })
public interface GenreProjection {
	public String getNomGenre();
}
