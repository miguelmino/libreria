package com.autentia.libreria.service;

import java.util.List;

import com.autentia.libreria.domain.Libro;

public interface LibroService {
	  
	  public List<Libro> findAll();
	  
	  public void insert(Libro libro); 

}
