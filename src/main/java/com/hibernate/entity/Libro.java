package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro")
	private int idLibro;
	
	@Column(nullable = false, length = 100)
	private String titulo;
	
	private String descripcion;
	
	@Column(name = "num_paginas")
	private int nPaginas;
	
	@Column(name = "isbn_13", unique = true, nullable = false, length = 13)
	private String isbn13;
	
	@ManyToOne
	@JoinColumn(name = "lib_id_autor", referencedColumnName = "id_autor")
	private Autor autor;

	public Libro() {
	}

	public Libro(String titulo, String descripcion, int nPaginas, String isbn13, Autor autor) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.nPaginas = nPaginas;
		this.isbn13 = isbn13;
		this.autor = autor;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getnPaginas() {
		return nPaginas;
	}

	public void setnPaginas(int nPaginas) {
		this.nPaginas = nPaginas;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", descripcion=" + descripcion + ", nPaginas="
				+ nPaginas + ", isbn13=" + isbn13 + "]";
	}

}
