/**
 * 
 */
package com.smoothstack.training.libraryproject;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author sean darsie
 *
 */
public class AuthorService implements Reader, Writer {

	private static final AuthorService instance = new AuthorService();
	private int numberOfRecords = 1;
    
    //private constructor to avoid client applications to use constructor
    private AuthorService(){}

    public static AuthorService getInstance(){
        return instance;
    }
    
	public String createAuthor(Author author)
	{
		if (author == null)
			return "Author cannot be null";
		if (author.getName().length() < 2 || author.getName().length() > 45)
			return "Author name must be between 2 and 45 characters in length";
		
		author.setAuthorId(numberOfRecords++);
		String allAuthors = readFromFile("resources/libraryfiles/authors.txt");
		if (allAuthors.contains(","+author.getName()+"\n"))
		{
			return "Author named " + author.getName()+ " already exists";
		}
		if (allAuthors.length() == 0)
		{
			writeToFile("resources/libraryfiles/authors.txt",author.getAuthorId()+ ","+author.getName());
		}
		else
		{
			appendToFile("resources/libraryfiles/authors.txt","\n"+author.getAuthorId()+ ","+author.getName());
		}
		return "Successfully added "+author.getName();
	}
	
	public String readAuthor()
	{
		StringBuilder stringBuilder = new StringBuilder();
		try(BufferedReader bufStream = new BufferedReader(new FileReader("Resources/libraryfiles/authors.txt"))){
			String line = bufStream.readLine();
			while(line!=null){
				Author author = new Author(1, "placeholder");
				if (line.contains(","))
				{
					author.setName(line.substring(line.indexOf(",")+1, line.length()));
					author.setAuthorId(Integer.parseInt(line.substring(0, line.indexOf(","))));
				}
				else
				{
					line = bufStream.readLine();
					continue;
				}
				stringBuilder.append("Author ID: "+author.getAuthorId()+", Author Name: " +author.getName()+"\n");
				line = bufStream.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read from author file in readAuthor");
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
		String allAuthors = readFromFile("resources/libraryfiles/authors.txt");
		
		if (allAuthors.contains(","+oldAuthor.getName()+"\n") != true)
		{
			return "There is no record of "+oldAuthor.getName()+".";
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		try(BufferedReader bufStream = new BufferedReader(new FileReader("Resources/libraryfiles/authors.txt"))){
			String line = bufStream.readLine();
			while(line!=null){
				Author author = new Author(1, "placeholder");
				if (line.contains(","))
				{
					if (line.contains(oldAuthor.getName()))
					{
						author.setName(newAuthor.getName());
					}
					else
					{
						author.setName(line.substring(line.indexOf(",")+1, line.length()));
					}
					author.setAuthorId(Integer.parseInt(line.substring(0, line.indexOf(","))));
				}
				else
				{
					line = bufStream.readLine();
					continue;
				}
				stringBuilder.append(author.getAuthorId()+"," +author.getName()+"\n");
				line = bufStream.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read from author file in readAuthor");
		}

		// write new data to the file
		writeToFile("resources/libraryfiles/authors.txt",stringBuilder.toString());
		return "Success. Replaced "+oldAuthor.getName()+" with "+newAuthor.getName();
	}
	
	public String deleteAuthor(Author author)
	{
		if (author == null)
			return "Author cannot be null";
		
		String allAuthors = readFromFile("resources/libraryfiles/authors.txt");
		
		if (allAuthors.contains(","+author.getName()+"\n") != true)
		{
			return "There is no record of "+author.getName()+".";
		}
		StringBuffer stringBuffer = new StringBuffer(allAuthors);
		int start = stringBuffer.indexOf(author.getAuthorId()+","+author.getName());
		int end = start + (author.getAuthorId()+","+author.getName()).length();
		stringBuffer.delete(start, end);
		// write to file
		writeToFile("resources/libraryfiles/authors.txt", stringBuffer.toString());
		
		return "Deleted "+author.getName()+" from the records";
	}

}
