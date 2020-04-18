/**
 * 
 */
package com.smoothstack.training.libraryproject;

/**
 * @author seandarsie
 *
 */
public class Author {
	private int authorId;
	private String name;
	
	public Author(int authorId, String authorName) {
		this.setAuthorId(authorId);
		this.setName(authorName);
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String authorName) {
		this.name = authorName;
	}
	
}
