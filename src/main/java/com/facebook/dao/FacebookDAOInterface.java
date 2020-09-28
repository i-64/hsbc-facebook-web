/**
 * 
 */
package com.facebook.dao;

import java.util.ArrayList;

import com.facebook.entity.FacebookUser;

/**
 * @author i-64
 *
 */
public interface FacebookDAOInterface {
	
	public int resgisterDAO(FacebookUser u);
	public boolean loginDAO(FacebookUser u);
	public ArrayList<FacebookUser> friendlistDAO(FacebookUser u);

}
