package com.cg.jpacrud.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="book_master")
@NamedQueries(@NamedQuery(name = "getAllBooks", query = "SELECT book FROM Book book"))
public class Book {
	private static final long serialVersionUID = 1L;
	@Id
	private int isbn;
	@Column(name = "book_title")
	private String title;
	@Column(name = "book_price")
	private double  price;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Book_authors", joinColumns = { @JoinColumn(name = "isbn_code") }, inverseJoinColumns = { @JoinColumn(name = "authors_id") })
	private Set<Author> authors = new HashSet<>();	//required to avoid NullPointerException

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		authors = authors;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price
				+ ", authors=" + authors + "]";
	}
	
	
}
