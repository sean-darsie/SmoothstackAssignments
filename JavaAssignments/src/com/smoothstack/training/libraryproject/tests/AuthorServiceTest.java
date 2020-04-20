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
		
		assertEquals(AuthorService.getInstance().createAuthor(null), "Author cannot be null");
		assertEquals(AuthorService.getInstance().deleteAuthor(null), "Author cannot be null");
		assertEquals(AuthorService.getInstance().updateAuthor(null, null), "Author cannot be null");
	}
	
	@Test
	public void createAuthorTest()
	{
		Author author = new Author(1, "George RR Martin");
		String result = AuthorService.getInstance().createAuthor(author);
		
		assertEquals(result,"Success");
	}
	
	@Test
	public void canReadAuthors()
	{
		// make sure the file has known values in it. 
		
		AuthorService.getInstance().createAuthor(new Author(1,"brett"));
		
		assertEquals(AuthorService.getInstance().readAuthor(), "1) brett");
		
	}
	
	@Test
	public void authorNameLengthTest()
	{
		
		Author shortName = new Author(1, "h");
		Author longName = new Author(2, "aaoisdnfoiansdiofnoisadnfioasdfaosdfnoiasdnfoinasdfasdoifn");
		
		assertEquals(AuthorService.getInstance().createAuthor(shortName), "Name must be at least 2 characters");
		assertEquals(AuthorService.getInstance().createAuthor(longName), "Name must be at less than 45 characters");
		assertEquals(AuthorService.getInstance().updateAuthor(shortName, longName), "Name must be at least 2 characters");
	}
	
	@Test
	public void canDeleteAuthor()
	{
		
		Author author = new Author(1, "h");
		AuthorService.getInstance().createAuthor(author);
		
		assertEquals(AuthorService.getInstance().deleteAuthor(author),author.getName()+" has been deleted");
	}
	
	
	
}
