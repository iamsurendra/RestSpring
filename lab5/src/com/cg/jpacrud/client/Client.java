package com.cg.jpacrud.client;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.entities.Author;
import com.cg.jpacrud.entities.Book;
import com.cg.jpacrud.service.AuthorService;
import com.cg.jpacrud.service.AuthorServiceImpl;


public class Client {

	static  AuthorService service = new AuthorServiceImpl();
	public static void main(String[] args) {

		//Debug this program as Debug -> Debug as Java Application
		int choice = 0;
		try(Scanner sc = new Scanner(System.in))
		{
			do
			{
				System.out.println("0-Add Book");
				System.out.println("1-Add Author");
				System.out.println("2-getAuthorNameBybookId");
				System.out.println("3-FindAllBooksByauthorName");
				System.out.println("4-Search All");
				System.out.println("5- getBooksInPriceRange");
				System.out.println("Enter choice::");
				choice = sc.nextInt();
				switch(choice)
				{
				case 0 : 

					Book book = acceptBookDetails(); 
					if(book!=null){	
						try
						{
							service.addBook(book);
							System.out.println("inserted book is= "+book.toString());
						}
						catch(AuthorException e)
						{
							System.out.println(e.getMessage());
						}}

					Author author = acceptAuthorDetails(); 
					if(author!=null){	
						try
						{
							service.addAuthor(author);
							System.out.println("inserted author is= "+author.toString());
						}
						catch(AuthorException e)
						{
							System.out.println(e.getMessage());
						}}
					break;
				case 1 : 


				case 2: System.out.println("Enter to bookid to getAuthor name::");
				int id = sc.nextInt();
				try
				{
					Author author1;
					author1=service.getAuthorNameBybookId(id);

					System.out.println("Author name is ..... "+author1.getName());
				}
				catch(AuthorException e)
				{
					System.out.println(e.getMessage());
				}
				break;

				case 3 : System.out.println("Enter author name to search AllBooks::");
				String name = sc.next();
				try
				{
					Author author2 =new Author();
					Set<Book> list=service.FindAllBooksByauthorName(name);

					System.out.println("books "+list);
				}
				catch(AuthorException e)
				{
					System.out.println(e.getMessage());
				}
				break;

				case 4 : 
					try{
						List<Book>list = service.getAllBooks();
						for(Book obj : list)
						{
							System.out.println(obj);
						}
					}
					catch(AuthorException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				case 5: System.out.println("Enter price Range::");
				double low=sc.nextInt();
				double high=sc.nextInt();
				try{
					List<Book> ref = service.getBooksInPriceRange(low,high);

					System.out.println("Books with id"+ref+"is missing");


				}
				catch(AuthorException e)
				{
					System.out.println(e.getMessage());
				}
				break;
				}
				System.out.println("do you want to continue 1-yes 0-No");
				choice = sc.nextInt();
			}while(choice!=0);
			System.out.println("thank you");
			System.exit(0);

		}



	}public static Author acceptAuthorDetails()
	{
		Author author = null;

		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Author name details::");
			String name = sc.next();

			if(!service.validateAuthorName(name))
			{
				continue;
			}
			else
			{	if(name!=null)
			{

				author = new Author();
				author.setName(name);
				author.addBook(acceptBookDetails());


				break;
			}
			}
		}

		return author;
	}
	public static Book acceptBookDetails()
	{

		Book book=null;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter  isbn details::");

			int isbn=sc.nextInt();
			System.out.println("Enter price");
			int price=sc.nextInt();
			System.out.println("Enter title");
			String title = sc.next();
			book=new Book();
			book.setIsbn(isbn);
			book.setPrice(price);
			book.setTitle(title);

			break;
		}

		return book;
	}


}
