/**
 * 
 */
package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			ps.setString(6, u.getCountry());
			ps.setString(5, u.getState());
			
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

	@Override
	public boolean loginDAO(FacebookUser u) {
		
		Connection con = null;
		
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb1;create=true","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("select * from FBTABLE where email=? and password=?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ResultSet res = ps.executeQuery();
			
			System.out.println(res.toString());
			
			if (res.next()) {
				
//				con.close();
				return true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			/*
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}*/
		}
		return false;
	}

	@Override
	public ArrayList<FacebookUser> friendlistDAO(FacebookUser u) {
		
		ArrayList<FacebookUser> list = new ArrayList<>();
		Connection con = null;
		
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb1;create=true","mrunal","0348");
			PreparedStatement ps = con.prepareStatement("select * from FRTABLE where EMAIL=?");
			ps.setString(1, u.getEmail());
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				
				FacebookUser currU = new FacebookUser();
//				currU.setName(res.getString(1));
//				currU.setPhone(res.getString(2));
				currU.setEmail(res.getString(2));
//				currU.setPassword(res.getString(4));
//				currU.setState(res.getString(5));
//				currU.setCountry(res.getString(6));
				
				list.add(currU);
			}
			
			return list;
			
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
		return null;
	}
}
