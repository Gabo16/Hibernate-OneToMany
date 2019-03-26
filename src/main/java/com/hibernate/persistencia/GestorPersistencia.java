package com.hibernate.persistencia;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

import com.hibernate.entity.Autor;


public class GestorPersistencia {
	EntityManagerFactory factory;
	EntityManager em;

	public GestorPersistencia() {
		this.factory = Persistence.createEntityManagerFactory("miBaseDeDatos");
	}
	
	public Autor getAutorXID(int id) {
		this.em = this.factory.createEntityManager();
		EntityTransaction transaccion = this.em.getTransaction();
		transaccion.begin();
		Autor c = em.find(Autor.class, id);
		c.getLibros().size();
		/**
		 * c.getLibros().size();
		 * Esta linea se lleva a cabo debido a que el tipo
		 * de recuperacion esta configuarada en perezosa
		 * "@OneToMany(mappedBy="autor", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)"
		 */
		transaccion.commit();
		this.em.close();
		return c;
	}
	
	public boolean insertarAutor(Autor c) {
		this.em = this.factory.createEntityManager();
		EntityTransaction transaccion = this.em.getTransaction();
		transaccion.begin();
		try {
			this.em.persist(c);
			transaccion.commit();
		} catch (Exception e) {
			return false;
		}finally {
			this.em.close();
		}
		return true;
	}
	
	public boolean actualizarAutor(Autor c) {
		this.em = this.factory.createEntityManager();
		EntityTransaction transaccion = this.em.getTransaction();
		transaccion.begin();
		try {
			this.em.merge(c);
			transaccion.commit();
		} catch (Exception e) {
			return false;
		}finally {
			this.em.close();
		}
		return true;
	}
	
	public boolean eliminarAutor(Autor c) {
		this.em = this.factory.createEntityManager();
		EntityTransaction transaccion = this.em.getTransaction();
		transaccion.begin();
		try {
			Autor c1 = em.merge(c);
			this.em.remove(c1);
			transaccion.commit();
		} catch (Exception e) {
			return false;
		}finally {
			this.em.close();
		}
		return true;
	}

	public void cerrar() {
		this.factory.close();
	}

}
