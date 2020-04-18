/**
 * 
 */
package com.smoothstack.training.libraryproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author seandarsie
 *
 */
public class AuthorService  {

	public String createAuthor(Author author)
	{
		if (author == null)
			return "Author cannot be null";
		if (author.getName().length() < 2 || author.getName().length() > 45)
			return "Author name must be between 2 and 45 characters in length";
		
		try(FileWriter fileWriter= new FileWriter(new File("resources/libraryfiles/authors.txt"))){
			fileWriter.write(author.getAuthorId()+ ","+author.getName());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Failed to write author: "+ author.getName()+" to author file");
		}
		return null;
	}
	
	public String readAuthor()
	{
		StringBuilder stringBuilder = new StringBuilder();
		try(BufferedReader bufStream = new BufferedReader(new FileReader("resources/libraryfiles/author.txt"))){
			String line = bufStream.readLine();
			while(line!=null){
				Author author = new Author(1, "Test");
				author.setAuthorId(Integer.parseInt(line.substring(0, line.indexOf(")"))));
				author.setName(line.substring(line.indexOf(")")+1, line.length()));
				stringBuilder.append("Author ID: "+author.getAuthorId()+" & Author Name:" +author.getName()+"\n");
				line = bufStream.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read from author File");
		}
		return stringBuilder.toString();

	}
	
	// find author. delete it. append the new author to the end of the file. 
	public String updateAuthor(Author oldAuthor, Author newAuthor)
	{
		if (oldAuthor == null || newAuthor == null)
			return "Author cannot be null";
		if (newAuthor.getName().length() < 2 || newAuthor.getName().length() > 45)
			return "Author name must be between 2 and 45 characters in length";
		
		return null;
	}
	
	public String deleteAuthor(Author author)
	{
		if (author == null)
			return "Author cannot be null";
		return null;
	}

}
