package com.cg.jpacrud.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.entities.Author;
import com.cg.jpacrud.util.JPAUtil;

public class AuthorDaoImpl implements AuthorDao {

	private EntityManager entityManager;

	public AuthorDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Author getAuthorById(int id) throws AuthorException{
		Author student = entityManager.find(Author.class, id);
		return student;
	}

	@Override
	public void addAuthor(Author author)throws AuthorException {
		entityManager.persist(author);
	}

	@Override
	public void removeAuthor(Author author) throws AuthorException{
		entityManager.remove(author);
	}

	@Override
	public void updateAuthor(Author author) throws AuthorException{
		entityManager.merge(author);
	}

	@Override
	public List<Author> getAllAuthor()throws AuthorException {

		List<Author> list =  entityManager.createNamedQuery("getAllBooks", Author.class)
				.getResultList();

		return list;
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
}
