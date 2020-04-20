/**
 * 
 */
package com.smoothstack.training.libraryproject;

/**
 * @author seandarsie
 *
 */
public class Publisher {
	private int publisherId;
	private String name;
	private String address;
	
	public Publisher(int publisherId, String name, String address) {
		this.setPublisherId(publisherId);
		this.setName(name);
		this.setAddress(address);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	
	public String displayInfo()
	{
		return "Publisher ID: "+publisherId+", Publisher Name: "+name+", Address: "+address;
	}
	
	public String recordInfo()
	{
		return name+","+address;
	}
	
}
