/**
 * 
 */
package com.smoothstack.training.libraryproject.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.smoothstack.training.libraryproject.BookService;


/**
 * @author seandarsie
 *
 */
public class BookServiceTest {

	@Test
	public void bookCannotBeNull()
	{
		BookService bookService = new BookService();
		
		assertEquals(bookService.createBook(null), "Book cannot be null");
		assertEquals(bookService.deleteBook(null), "Book cannot be null");
		assertEquals(bookService.readBook(null), "Book cannot be null");
		assertEquals(bookService.updateBook(null), "Book cannot be null");
	}
}
