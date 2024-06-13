package com.user.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.user.model.User;
import com.util.DBConnect;



public class UserDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String userName,String password) {
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from user where username='"+userName+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
     
	public static List<User> getUser(String userName){
		
		ArrayList<User> usr = new ArrayList<>();
		
		
		
		//validate
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from user where username='"+userName+"'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				String address = rs.getString(6);
				String userU = rs.getString(7);
				String passU = rs.getString(8);
				
				User u = new User(id,name,gender,email,phone,address,userU,passU);
				usr.add(u);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return usr;
	}
	
	public static boolean insertuser(String name,String gender,String email,String phone,String address,String username,String password) {
		
		boolean isSuccess = false;
		
		
		try {
			
            con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into user values(0,'"+name+"','"+gender+"','"+email+"','"+phone+"','"+address+"','"+username+"','"+password+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
			    isSuccess = false;
		    }	
		}
		catch (Exception e) {
		e.printStackTrace();
	}
		return isSuccess;
	}
	
	public static boolean updateuser(String id,String name,String gender,String email,String phone,String address,String username,String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update user set name='"+name+"',gender='"+gender+"',email='"+email+"',phone='"+phone+"',address='"+address+"',username='"+username+"',password='"+password+"'"+"where id='"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs >0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	public static List<User>getUserDetails(String Id){
		
		int convertedID = Integer.parseInt(Id);
		
		ArrayList<User> usr  = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from user where id= '"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				String address = rs.getString(6);
				String username = rs.getString(7);
				String password = rs.getString(8);
				
			   User u =new User(id,name,gender,email,phone,address,username,password);
			   usr.add(u);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		return usr;
	}
	
	public static boolean deleteUser(String id) {
		
		int convId = Integer.parseInt(id);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from user where id='"+convId+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
}