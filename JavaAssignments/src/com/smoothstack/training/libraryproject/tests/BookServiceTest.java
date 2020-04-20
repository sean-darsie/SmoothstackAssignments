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
		assertEquals(BookService.getInstance().createBook(null), "Book cannot be null");
		assertEquals(BookService.getInstance().deleteBook(null), "Book cannot be null");
		assertEquals(BookService.getInstance().updateBook(null,null), "Book cannot be null");
	}
}
