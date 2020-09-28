/**
 * 
 */
package com.facebook.utilities;

import com.facebook.dao.FacebookDAO;

/**
 * @author i-64
 *
 */
public class DAOFactory {
	
	private DAOFactory () {
		;
	}
	
	public static FacebookDAO createObject () {
		
		return (new FacebookDAO());
	}

}
