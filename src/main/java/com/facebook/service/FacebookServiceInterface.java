/**
 * 
 */
package com.facebook.service;

import java.util.ArrayList;

import com.facebook.entity.FacebookUser;

/**
 * @author i-64
 *
 */
public interface FacebookServiceInterface {

	public int registerService (FacebookUser u);
	public boolean loginService (FacebookUser u);
	public ArrayList<FacebookUser> friendlist(FacebookUser u);
}
