package com.autentia.libreria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.libreria.domain.Libro;
import com.autentia.libreria.persistence.Dao;
import com.autentia.libreria.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired 
	  private Dao dao;
	  
	  public List<Libro> findAll(){
		  return dao.findAll();
	  }
	  
	  public void insert(Libro libro){
		  dao.insertBook(libro);
	  }

}
