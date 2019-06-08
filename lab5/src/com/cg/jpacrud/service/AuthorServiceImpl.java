package com.cg.jpacrud.service;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.dao.AuthorDao;
import com.cg.jpacrud.dao.AuthorDaoImpl;
import com.cg.jpacrud.entities.Author;
import com.cg.jpacrud.entities.Book;


public class AuthorServiceImpl implements AuthorService {

	private AuthorDao dao;

	public AuthorServiceImpl() {
		dao = new AuthorDaoImpl();
	}

	@Override
	public void addAuthor(Author author)throws AuthorException {
		dao.beginTransaction();
		dao.addAuthor(author);
		dao.commitTransaction();
	}
	@Override
	public  void addBook(Book  book)throws AuthorException{
		dao.beginTransaction();
		dao.addBook(book);
		dao.commitTransaction();
	}
	@Override
	public Author getAuthorNameBybookId(int id) throws AuthorException {

		return dao.getAuthorNameBybookId(id);
	}

	@Override
	public List<Book> getAllBooks() throws AuthorException {

		return dao.getAllBooks();
	}

	@Override
	public Set<Book> FindAllBooksByauthorName(String author) throws AuthorException {

		return dao.FindAllBooksByauthorName(author);
	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high)
			throws AuthorException {

		return dao.getBooksInPriceRange(low, high);
	}

	@Override
	public boolean validateAuthorName(String name)  {
		String pattern="[A-Z]{1}[a-z]{2,}";
		if(Pattern.matches(pattern, name)){
			return true;
		}else
			return false;

	}
	@Override
	public boolean validateAuthorPhoneNumber(String phNo)  {
		String pattern="[0-9]{10}";
		String phno=""+phNo;
		if(Pattern.matches(pattern, phno)){
			return true;
		}else
			return false;

	}


}
