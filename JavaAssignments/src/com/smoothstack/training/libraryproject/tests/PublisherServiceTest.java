/**
 * 
 */
package com.smoothstack.training.libraryproject.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.smoothstack.training.libraryproject.PublisherService;


/**
 * @author seandarsie
 *
 */
public class PublisherServiceTest {

	@Test
	public void publisherCannotBeNull()
	{
		PublisherService publisherService = new PublisherService();
		
		assertEquals(publisherService.createPublisher(null), "Publisher cannot be null");
		assertEquals(publisherService.deletePublisher(null), "Publisher cannot be null");
		assertEquals(publisherService.readPublisher(null), "Publisher cannot be null");
		assertEquals(publisherService.updatePublisher(null), "Publisher cannot be null");
	}
}
