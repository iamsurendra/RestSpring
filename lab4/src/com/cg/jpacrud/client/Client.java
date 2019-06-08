package com.cg.jpacrud.client;

import java.util.List;
import java.util.Scanner;

import com.cg.jpacrud.Exception.AuthorException;
import com.cg.jpacrud.entities.Author;
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
				System.out.println("1-Add Author");
				System.out.println("2-Remove Author");
				System.out.println("3-Search By Id");
				System.out.println("4-Search All");
				System.out.println("5- update Author");
				System.out.println("Enter choice::");
				choice = sc.nextInt();
				switch(choice)
				{
				case 1 : 

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
				case 2: System.out.println("Enter to id to remove::");
				int id = sc.nextInt();
				try
				{
					Author author1;
					author1=service.findAuthorById(id);
					if(author1==null){
						System.out.println("author with id"+id+"is missing");
					}else{
						service.removeAuthor(author1);
						System.out.println("Author removed  succussfully..... "+author1);
					}

				}
				catch(AuthorException e)
				{
					System.out.println(e.getMessage());
				}
				break;

				case 3 : System.out.println("Enter id to search Author::");
				int aid = sc.nextInt();
				try
				{
					Author ref = service.findAuthorById(aid);
					System.out.println("emp "+ref);
				}
				catch(AuthorException e)
				{
					System.out.println(e.getMessage());
				}
				break;

				case 4 : 
					try{
						List<Author>list = service.getAllAuthor();
						for(Author obj : list)
						{
							System.out.println(obj);
						}
					}
					catch(AuthorException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				case 5: System.out.println("Enter id::");
				int auid=sc.nextInt();
				try{
					Author ref = service.findAuthorById(auid);
					if(ref==null){
						System.out.println("author with id"+auid+"is missing");
					}else{
						System.out.println("enter the phoneNumber");
						String phone=sc.next();
						ref.setPhoneNo(phone);
						service.updateAuthor(ref);
						System.out.println(phone+" is succussfully updated = "+ref);
					}

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
			System.out.println("Enter name::");
			String fname = sc.next();
			String mname = sc.next();
			String lname = sc.next();
			if(!service.validateAuthorName(fname))
			{
				continue;
			}
			else
			{
				while(true)
				{
					System.out.println("Enter PhoneNumber::");
					String phone = sc.next();
					if(!service.validateAuthorPhoneNumber(phone))
					{
						continue;
					}
					else
					{
						if(phone!=null)
						{
							author = new Author();
							author.setFirstName(fname);
							author.setMiddleName(mname);
							author.setLastName(lname);
							author.setPhoneNo(phone);
							break;
						}
					}
				}
			}
			return author;
		}


	}
}
