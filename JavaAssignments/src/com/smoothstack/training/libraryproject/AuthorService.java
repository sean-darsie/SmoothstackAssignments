/**
 * 
 */
package com.smoothstack.training.libraryproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author sean darsie
 *
 */
public class AuthorService implements Reader, Writer {

	public String createAuthor(Author author)
	{
		if (author == null)
			return "Author cannot be null";
		if (author.getName().length() < 2 || author.getName().length() > 45)
			return "Author name must be between 2 and 45 characters in length";
		
		writeToFile("resources/libraryfiles/authors.txt",author.getAuthorId()+ ","+author.getName());
		return "Successfully added "+author.getName();
	}
	
	public String readAuthor()
	{
		StringBuilder stringBuilder = new StringBuilder();
		try(BufferedReader bufStream = new BufferedReader(new FileReader("resources/libraryfiles/author.txt"))){
			String line = bufStream.readLine();
			while(line!=null){
				Author author = new Author(1, "placeholder");
				author.setAuthorId(Integer.parseInt(line.substring(0, line.indexOf(")"))));
				author.setName(line.substring(line.indexOf(")")+1, line.length()));
				stringBuilder.append("Author ID: "+author.getAuthorId()+", Author Name: " +author.getName()+"\n");
				line = bufStream.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read from author file");
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
		
		// authorId should remain consistent after the update.
		newAuthor.setAuthorId(oldAuthor.getAuthorId());
		
		// delete the author from the database.
		String allAuthors = readFromFile("resources/libraryfiles/authors.txt");
		allAuthors.replace(oldAuthor.getName(), newAuthor.getName());
		
		// write new data to the file
		try(FileWriter fileWriter= new FileWriter(new File("resources/libraryfiles/authors.txt"))){
			fileWriter.write(allAuthors);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Failed to write to author file");
		}
		return "Sucess. Replaced "+oldAuthor.getName()+" with "+newAuthor.getName();
	}
	
	public String deleteAuthor(Author author)
	{
		if (author == null)
			return "Author cannot be null";
		
		String allAuthors = readFromFile("resources/libraryfiles/authors.txt");
		if (allAuthors.contains(author.getName()) != true)
		{
			return "There is no record of "+author.getName()+".";
		}
		StringBuffer stringBuffer = new StringBuffer(allAuthors);
		int start = stringBuffer.indexOf(author.getAuthorId()+","+author.getName());
		int end = start + (author.getAuthorId()+","+author.getName()).length();
		stringBuffer.delete(start, end);
		// write to file
		writeToFile("resources/libraryfiles/authors.txt", stringBuffer.toString());
		
		return null;
	}

}
