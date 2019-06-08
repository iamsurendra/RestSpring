package com.cg.jpacrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.dao.AuthorDao;
import com.cg.jpacrud.dao.AuthorDaoImpl;
import com.cg.jpacrud.entities.Author;


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
	public void updateAuthor(Author author)throws AuthorException {
		dao.beginTransaction();
		dao.updateAuthor(author);
		dao.commitTransaction();
	}
	
	@Override
	public void removeAuthor(Author author)throws AuthorException {
		dao.beginTransaction();
		dao.removeAuthor(author);
		dao.commitTransaction();
	}
	
	@Override
	public Author findAuthorById(int id) throws AuthorException{
		//no need of transaction, as it's an read operation
		Author student  = dao.getAuthorById(id);
		return student;
	}

	@Override
	public List<Author> getAllAuthor() throws AuthorException{
		// TODO Auto-generated method stub
		return dao.getAllAuthor();
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
