package com.cg.jpacrud.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.entities.Author;


public interface AuthorDao {

	public abstract Author  getAuthorById(int id) throws AuthorException;

	public abstract void addAuthor (Author  author)throws AuthorException;

	public abstract void removeAuthor(Author  author)throws AuthorException;

	public abstract void updateAuthor(Author  author)throws AuthorException;
	public abstract List<Author> getAllAuthor()throws AuthorException;

	public abstract void commitTransaction();

	public abstract void beginTransaction();

}