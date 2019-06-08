package com.cg.jpacrud.service;

import java.util.List;
import java.util.Set;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.entities.Author;
import com.cg.jpacrud.entities.Book;


public interface AuthorService {


	public  void addAuthor (Author  author)throws AuthorException;
	public  void addBook(Book  book)throws AuthorException;
	public  Author  getAuthorNameBybookId(int id) throws AuthorException;
	public List<Book> getAllBooks()throws AuthorException;
	public Set<Book> FindAllBooksByauthorName(String author) throws AuthorException;
	
	public List<Book> getBooksInPriceRange(double low,double high)throws AuthorException;


	public boolean validateAuthorName(String name);
	public boolean validateAuthorPhoneNumber(String phNo); 

}