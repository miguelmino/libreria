package com.autentia.libreria.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.libreria.domain.Libro;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Dao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Libro> findAll() {
		
		Session session = sessionFactory.getCurrentSession();
		List pizzas = session.createQuery("from Libro").list();
		return pizzas;
	}
	
	@Transactional
	public void insertBook(Libro libro) {
		
		sessionFactory.getCurrentSession().save(libro);
	
	}
	
	@Transactional
	public void deleteBook(Libro libro) {
		sessionFactory.getCurrentSession().delete(libro);
	}
}