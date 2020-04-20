/**
 * 
 */
package com.smoothstack.training.libraryproject;

/**
 * @author seandarsie
 *
 */
public class LibraryInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AuthorService authorService = new AuthorService();
		Author author = new Author(1,"TestAuthor");
		Author author2 = new Author(2,"TestAuthor2");
		
		
		System.out.println(authorService.readAuthor());
		System.out.println();
		System.out.println(authorService.updateAuthor(author, new Author(1,"updated author")));
		
	}

}
