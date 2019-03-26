package com.hibernate.test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import com.hibernate.entity.Autor;
import com.hibernate.entity.Libro;
import com.hibernate.persistencia.GestorPersistencia;

public class Test {

	public static void main(String[] args) {
		
		GestorPersistencia gp = new GestorPersistencia();
		
		
//******Obtener Autor por ID
		Autor autor = gp.getAutorXID(2);
		System.out.println(autor);	
		
//******Insertar Autor
//		Date createAt = new GregorianCalendar(2019,02,29).getTime();
//		Autor autor = new Autor("George", "Martin");
////		autor.getLibros().add(new Libro("ANIMALES FANTASTICOS Y DONDE ENCONTRARLOS", "ANIMALES FANTASTICOS Y DONDE ENCONTRARLOS", 156, "9788498388237", autor));
//		agregarLibros(autor);
//		if(gp.insertarAutor(autor) == true) {
//			System.out.println("Autor insertado");
//		}else {
//			System.out.println("Ha fallado la inserción");
//		}
		
//******Actualizar Autor y agregar un libro
//		Autor autor = gp.getAutorXID(1);
//		autor.setApPaterno("Rowling");
//		autor.getLibros().add(new Libro("HARRY POTTER Y EL PRISIONERO DE AZKABAN", "HARRY POTTER Y EL PRISIONERO DE AZKABAN", 336, "9788498388275", autor));
//		System.out.println(autor);
//		if(gp.actualizarAutor(autor) == true) {
//			System.out.println("Autor actualizado");
//		}else {
//			System.out.println("Ha fallado la actualización");
//		}
		
//******Eliminar  Autor
//		Autor autor = gp.getAutorXID(3);
//		System.out.println(autor);
//		if (gp.eliminarAutor(autor) == true) {
//			System.out.println("Autor eliminado");
//		} else {
//			System.out.println("Ha fallado la eliminación");
//		}
		
		gp.cerrar();
	}
	
	private static void agregarLibros(Autor a) {
		a.getLibros().add(new Libro("Fuego y Sangre", "Los Dragones reinaban en poniente", 880, "9786073173025", a));
		a.getLibros().add(new Libro("Juego de Tronos 1", "Juego de Tronos", 192, "9788415480129", a));
		a.getLibros().add(new Libro("Juego de Tronos 2", "Juego de Tronos", 192, "9788415480396", a));
		a.getLibros().add(new Libro("Juego de Tronos 3", "Juego de Tronos", 192, "9788415866060", a));
	}

}
