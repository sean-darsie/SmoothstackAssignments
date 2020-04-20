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
		assertEquals(PublisherService.getInstance().createPublisher(null), "Publisher cannot be null");
		assertEquals(PublisherService.getInstance().deletePublisher(null), "Publisher cannot be null");
		assertEquals(PublisherService.getInstance().readPublisher(), "Publisher cannot be null");
		assertEquals(PublisherService.getInstance().updatePublisher(null,null), "Publisher cannot be null");
	}
}
