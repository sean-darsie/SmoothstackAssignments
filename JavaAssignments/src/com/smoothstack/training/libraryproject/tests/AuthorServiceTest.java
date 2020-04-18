/**
 * 
 */
package com.smoothstack.training.libraryproject.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.smoothstack.training.libraryproject.Author;
import com.smoothstack.training.libraryproject.AuthorService;

/**
 * @author seandarsie
 *
 */
public class AuthorServiceTest {
	
	@Test
	public void authorCannotBeNull()
	{
		AuthorService authorService = new AuthorService();
		
		assertEquals(authorService.createAuthor(null), "Author cannot be null");
		assertEquals(authorService.deleteAuthor(null), "Author cannot be null");
		assertEquals(authorService.updateAuthor(null, null), "Author cannot be null");
	}
	
	@Test
	public void createAuthorTest()
	{
		AuthorService authorService = new AuthorService();
		Author author = new Author(1, "George RR Martin");
		String result = authorService.createAuthor(author);
		
		assertEquals(result,"Success");
	}
	
	@Test
	public void canReadAuthors()
	{
		// make sure the file has known values in it. 
		AuthorService authorService = new AuthorService();
		
		authorService.createAuthor(new Author(1,"brett"));
		
		assertEquals(authorService.readAuthor(), "1) brett");
		
	}
	
	@Test
	public void authorNameLengthTest()
	{
		AuthorService authorService = new AuthorService();
		
		Author shortName = new Author(1, "h");
		Author longName = new Author(2, "aaoisdnfoiansdiofnoisadnfioasdfaosdfnoiasdnfoinasdfasdoifn");
		
		assertEquals(authorService.createAuthor(shortName), "Name must be at least 2 characters");
		assertEquals(authorService.createAuthor(longName), "Name must be at less than 45 characters");
		assertEquals(authorService.updateAuthor(shortName, longName), "Name must be at least 2 characters");
	}
	
	@Test
	public void canDeleteAuthor()
	{
		AuthorService authorService = new AuthorService();
		
		Author author = new Author(1, "h");
		authorService.createAuthor(author);
		
		assertEquals(authorService.deleteAuthor(author),author.getName()+" has been deleted");
	}
	
	
	
}
