package com.autentia.libreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.autentia.libreria.domain.Libro;
import com.autentia.libreria.service.LibroService;


@Controller
@RequestMapping("/")
public class LibroController {

	  private static int num = 3;
	  
	  @Autowired
	  private LibroService libroServiceImpl;
	   
	  @RequestMapping(method = RequestMethod.GET)
	  public String list(Model model) {
	    List<Libro> libros = libroServiceImpl.findAll();
	    model.addAttribute("libros", libros);
	    model.addAttribute("libro", new Libro());
	    return "index";
	  }
	  
	  @RequestMapping("/addBook")
	  public String addBook(@ModelAttribute("libro") Libro libro) {
		  libro.setId(num);
		  num++;
		  libroServiceImpl.insert(libro);
		  return "redirect:/";
	  }
}
