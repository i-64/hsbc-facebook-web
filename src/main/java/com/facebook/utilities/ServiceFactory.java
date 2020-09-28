/**
 * 
 */
package com.facebook.utilities;

import com.facebook.service.FacebookService;

/**
 * @author i-64
 *
 */
public class ServiceFactory {
	
	private ServiceFactory () {
		;
	}
	
	public static FacebookService createObject() {
		
		return (new FacebookService());
	}

}
