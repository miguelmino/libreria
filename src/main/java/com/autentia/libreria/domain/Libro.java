package com.autentia.libreria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="autor")
	private String Autor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String Isbn) {
		isbn = Isbn;
	}

	public String getAutor() {
		return Autor;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

}
