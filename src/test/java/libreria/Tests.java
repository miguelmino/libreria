package libreria;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.autentia.libreria.domain.Libro;
import com.autentia.libreria.persistence.Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/servlet-context-test.xml" })
public class Tests {

	@Resource
	private Dao dao;

	List<Libro> libros;

	Libro libro;

	private static final int LIBROSBD = 3;

	@Before
	public void setUp() {
		libro = new Libro();
		libro.setId(5);
		libro.setAutor("Carlos");
		libro.setTitulo("HTML");
		libro.setIsbn("5555");
	}

	@Test
	public void testBBDD() {
		libros = dao.findAll();
		Assert.assertTrue("Comprobar que en la base de datos hay 3 libros",
				libros.size() == LIBROSBD);
	}

	@Test
	public void testInsert() {

		dao.insertBook(libro);
		libros = dao.findAll();
		Assert.assertTrue("Comprueba que hay un libro mas",
				libros.size() == LIBROSBD + 1);

		Libro libroAux = libros.get(LIBROSBD);

		Assert.assertTrue("Comprueba que coincide id.",
				libro.getId() == libroAux.getId());
		Assert.assertTrue("Comprueba que coincide el autor.",
				libro.getAutor() == libroAux.getAutor());
		Assert.assertTrue("Comprueba que coincide el titulo.",
				libro.getTitulo() == libroAux.getTitulo());
		Assert.assertTrue("Comprueba que coincide el ISBN.",
				libro.getIsbn() == libroAux.getIsbn());

		dao.deleteBook(libroAux);
	}

	@Test
	public void testDelete() {

		dao.insertBook(libro);

		libros = dao.findAll();
		Assert.assertTrue("Comprueba que hay un libro mas.",
				libros.size() == LIBROSBD + 1);

		dao.deleteBook(libro);

		libros = dao.findAll();
		Assert.assertTrue("Comprueba que vuelve a haber los libros iniciales.",
				libros.size() == LIBROSBD);
	}
}
