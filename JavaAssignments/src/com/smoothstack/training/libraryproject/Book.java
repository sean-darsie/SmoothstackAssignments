/**
 * 
 */
package com.smoothstack.training.libraryproject;

/**
 * @author seandarsie
 *
 */
public class Book {
	private int bookId;
	private String name;
	private String author;
	private String publisher;
	
	public Book(int bookId, String name, String author, String publisher) {
		super();
		this.setBookId(bookId);
		this.setName(name);
		this.setAuthor(author);
		this.setPublisher(publisher);
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
