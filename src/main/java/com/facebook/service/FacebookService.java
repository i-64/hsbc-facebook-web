/**
 * 
 */
package com.facebook.service;

import java.util.ArrayList;

import com.facebook.dao.FacebookDAO;
import com.facebook.entity.FacebookUser;
import com.facebook.utilities.DAOFactory;

/**
 * @author i-64
 *
 */
public class FacebookService implements FacebookServiceInterface {
	
	private FacebookDAO d;
	
	public FacebookService () {
		
		d = DAOFactory.createObject();
	}

	@Override
	public int registerService(FacebookUser user) {
		
		return (d.resgisterDAO(user));
	}

	@Override
	public boolean loginService(FacebookUser u) {
		
		return (d.loginDAO(u));
	}

	@Override
	public ArrayList<FacebookUser> friendlist(FacebookUser u) {
		
		return (d.friendlistDAO(u));
	}

}
