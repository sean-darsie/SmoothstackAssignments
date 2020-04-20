package com.smoothstack.training.libraryproject;

import java.util.Scanner;

public class UserFlow {
	
	UserInterface ui;
	Scanner in;
	
	public UserFlow(Scanner in)
	{
		this.in = in;
		ui = new UserInterface(this.in);
	}
	
	public void startLibrarySystem()
	{
		ui.welcomeMessage();
		beginQuerying();
	}
	
	public void beginQuerying()
	{
		ui.mainMenuOptions();
        String input = in.nextLine();
        switch(input) {
        case "1":
        	create();
        	break;
        case "2":
        	read();
        	break;
        case "3":
        	update();
        	break;
        case "4":
        	delete();
        	break;
        case "q":
        	System.out.println("Thank you for using the libray system");
        	break;
        default:
        	
        	System.out.println("you have not entered one of the correct options.");
        	beginQuerying();
        	break;
        }
        
		
	}
	
	public void create() {
		ui.chooseDatabase();
		String input = in.nextLine();
		switch(input){
		case"1":
			// create publisher
			Publisher newPublisher = ui.getPublisherInfo();
			System.out.println(PublisherService.getInstance().createPublisher(newPublisher));
			
			beginQuerying();
			break;
		case"2":
			// create authors
			Author newAuthor = ui.getAuthorInfo();
			System.out.println(AuthorService.getInstance().createAuthor(newAuthor));
			
			beginQuerying();
			break;
		case"3":
			// create books
			Book newBook = ui.getBookInfo();
			System.out.println(BookService.getInstance().createBook(newBook));
			
			// print the return from the service and return to main menu
			beginQuerying();
			break;
		case"r":
	        
			beginQuerying();
			break;
		default:
        	System.out.println("you have not entered one of the correct options.");
            
        	create();
			break;
		}
	}
	
	public void read() {
		ui.chooseDatabase();
		String input = in.nextLine();
		switch(input){
		case"1":
			//read publishers
			
			System.out.println(PublisherService.getInstance().readPublisher());
			beginQuerying();
			break;
		case"2":
			// read authors	
			
			System.out.println(AuthorService.getInstance().readAuthor());
			beginQuerying();
			break;
		case"3":
			// books		
			
			System.out.println(BookService.getInstance().readBook());
			beginQuerying();
			break;
		case"r":
			beginQuerying();
			break;
		default:
			
        	System.out.println("you have not entered one of the correct options.");
        	read();
			break;
		}
        

	}
	
	public void update() {
		ui.chooseDatabase();
		String input = in.nextLine();
		switch(input){
		case"1":
			//update publishers
			
			System.out.println("Current publisher record");
			Publisher oldRecord = ui.getPublisherInfo();
			System.out.println("New publisher record");
			Publisher newRecord = ui.getPublisherInfo();
			System.out.println(PublisherService.getInstance().updatePublisher(oldRecord,newRecord));
			beginQuerying();
			break;
		case"2":
			// update authors	
			
			System.out.println("Current author record");
			Author oldAuthor = ui.getAuthorInfo();
			System.out.println("New publisher record");
			Author newAuthor = ui.getAuthorInfo();
			System.out.println(AuthorService.getInstance().updateAuthor(oldAuthor,newAuthor));			beginQuerying();
			break;
		case"3":
			// update books			
			
			System.out.println("Current publisher record");
			Book oldBook = ui.getBookInfo();
			System.out.println("New publisher record");
			Book newBook = ui.getBookInfo();
			System.out.println(BookService.getInstance().updateBook(oldBook,newBook));
			beginQuerying();
			break;
		case"r":
			beginQuerying();
			break;
		default:
			
        	System.out.println("you have not entered one of the correct options.");
        	update();
			break;
		}
        

	}
	public void delete() {
		ui.chooseDatabase();
		String input = in.nextLine();
		switch(input){
		case"1":
			//delete publishers
			Publisher pubRecord = ui.getPublisherInfo();
			
			System.out.println(PublisherService.getInstance().deletePublisher(pubRecord));
			beginQuerying();
			break;
		case"2":
			// read authors	
			Author authRecord = ui.getAuthorInfo();
			
			System.out.println(AuthorService.getInstance().deleteAuthor(authRecord));
			beginQuerying();
			break;
		case"3":
			// books			
			Book bookRecord = ui.getBookInfo();
			System.out.println(BookService.getInstance().deleteBook(bookRecord));
			
			beginQuerying();
			break;
		case"r":
			
			beginQuerying();
			break;
		default:
        	System.out.println("you have not entered one of the correct options.");
        	
        	read();
			break;
		}
        

	}
}
