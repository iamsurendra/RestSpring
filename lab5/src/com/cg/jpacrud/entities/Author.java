package com.cg.jpacrud.entities;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name="Author_Master")
public class Author  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq",sequenceName="seq_purchase_id",
				allocationSize=1)*/
	private int authorId;
	private String name;

	@ManyToMany(fetch=FetchType.LAZY,mappedBy="authors")
	private Set<Book> books = new HashSet<>();


	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + "]";
	}

	public void addBook(Book book){
		this.getBooks().add(book);
	}


}
