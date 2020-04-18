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
		authorService.createAuthor(author);
	}

}
