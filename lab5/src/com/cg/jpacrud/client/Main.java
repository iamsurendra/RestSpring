package com.cg.jpacrud.client;

import java.util.List;
import java.util.Scanner;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.entities.Author;
import com.cg.jpacrud.entities.Book;
import com.cg.jpacrud.service.AuthorService;
import com.cg.jpacrud.service.AuthorServiceImpl;
import com.cg.jpacrud.util.JPAUtil;


public class Main {
	public static void main(String[] args) throws AuthorException {
		Author author=null;
		AuthorService service = new AuthorServiceImpl();
		//Scanner sc=new Scanner(System.in);

		/*
		System.out.println("************Listing total number of books*************");
		List<Book>list=service.getAllBooks();
		for(Book book:list) {
			System.out.println("Total books:"+book);
		}
		System.out.println("************Listing book with id *************");
		System.out.println("Book with ID :"+service.getAuthorNameBybookId(100));

		Book fictionBook = new Book();
		fictionBook.setIsbn(100);
		fictionBook.setTitle("Rich Dad Poor Dad");
		fictionBook.setPrice(450);
		author = new Author();
		author.setName("Fiction");
		author.addBook(fictionBook);
		service.addAuthor(author);
		System.out.println("adding author is="+author.toString());

		System.out.println("FindAllBooksByAuthorName"+service.FindAllBooksByauthorName("Kulu"));;

		System.out.println("************Listing All books between 500 and 600*************");
		for(Book book:service.getBooksInPriceRange(500, 600) ) {
			System.out.println(book);
		}*/
		Book fictionBook = new Book();
		fictionBook.setIsbn(100);
		fictionBook.setTitle("Rich Dad Poor Dad");
		fictionBook.setPrice(450);
		author = new Author();
		author.setName("Fiction");
		author.addBook(fictionBook);
		service.addAuthor(author);
		System.out.println("adding author is="+author.toString());




	}
}
