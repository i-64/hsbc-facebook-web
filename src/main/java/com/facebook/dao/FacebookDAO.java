/**
 * 
 */
package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.facebook.entity.FacebookUser;

/**
 * @author i-64
 *
 */
public class FacebookDAO implements FacebookDAOInterface {

	@Override
	public int resgisterDAO (FacebookUser u) {

		Connection con = null;
		
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb1;create=true","mrunal","0348");
			
			PreparedStatement ps = con.prepareStatement("insert into FBTABLE values(?,?,?,?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPhone());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getCountry());
			ps.setString(6, u.getState());
			
			return (ps.executeUpdate());
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return 0;
	}

}
