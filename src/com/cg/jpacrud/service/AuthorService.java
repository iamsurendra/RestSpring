package com.cg.jpacrud.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.entities.Author;


public interface AuthorService {

	public abstract void addAuthor(Author author)throws AuthorException;

	public abstract void updateAuthor(Author author)throws AuthorException;

	public abstract void removeAuthor(Author author)throws AuthorException;

	public abstract Author findAuthorById(int id)throws AuthorException;
	public List<Author> getAllAuthor()throws AuthorException ;
	public boolean validateAuthorName(String name);
	public boolean validateAuthorPhoneNumber(String phNo); 

}