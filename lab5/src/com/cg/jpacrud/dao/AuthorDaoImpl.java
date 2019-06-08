package com.cg.jpacrud.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.entities.Author;
import com.cg.jpacrud.entities.Book;
import com.cg.jpacrud.util.JPAUtil;


public class AuthorDaoImpl implements AuthorDao {

	private EntityManager entityManager;

	public AuthorDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public  Author  getAuthorNameBybookId(int id) throws AuthorException{
		Author author = entityManager.find(Author.class, id);
		return author;
	}

	@Override
	public void addAuthor(Author author)throws AuthorException {
		entityManager.persist(author);
	}
	public  void addBook(Book  book)throws AuthorException{
		entityManager.persist(book);
	}
	@Override
	public Set<Book> FindAllBooksByauthorName(String author) throws AuthorException {
		HashSet<Book> books=new HashSet<Book>();
		TypedQuery<Author> query = entityManager
				.createQuery("SELECT author FROM Author author WHERE author.name=:pAuthor", Author.class);
		query.setParameter("pAuthor", author);

		List<Author> list= query.getResultList();

		for (Author ref : list) {
			for (Book book : ref.getBooks()) {
				books.add(book);
			}
		}
		return books;

	}

	@Override
	public List<Book> getBooksInPriceRange(double low,double high)throws AuthorException {

		String qStr = "SELECT book FROM Book book WHERE book.price between :low and :high";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		List<Book> bookList = query.getResultList();
		return bookList;
	}

	@Override
	public List<Book> getAllBooks()throws AuthorException {

		@SuppressWarnings("unchecked")
		List<Book> list =  entityManager.createNamedQuery("getAllBooks")
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
