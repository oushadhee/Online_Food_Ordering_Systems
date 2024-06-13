package com.admin.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.model.Admin;
import com.util.DBConnect;





public class AdminDBUtil {


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
     
	public static List<Admin> getUser(String userName){
		
		ArrayList<Admin> adm = new ArrayList<>();
		
		
		
		//validate
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from user where username='"+userName+"'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String hotelname = rs.getString(2);
				String username = rs.getString(3);
				String password = rs.getString(4);
				String address = rs.getString(5);
				
				
				Admin a = new Admin(id,hotelname,username,password,address);
				adm.add(a);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return adm;
	}
	

	public static List<Admin>getAdminDetails(String Id){
		
		int convertedID = Integer.parseInt(Id);
		
		ArrayList<Admin> adm  = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from user where id= '"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String hotelname = rs.getString(2);
				String username = rs.getString(3);
				String password = rs.getString(4);
				String address = rs.getString(5);
				
				
			   Admin a =new Admin(id,hotelname,username,password,address);
			   adm.add(a);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		return adm;
	}
	
	
}
