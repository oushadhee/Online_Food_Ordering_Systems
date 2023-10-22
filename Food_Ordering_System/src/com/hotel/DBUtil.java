 package com.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    
	public static boolean insertMenuItem(String name, String description, double price, String category, boolean availability) {
	    boolean isSuccess = false;
	    Connection con = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        con = DBConnect.getConnection();

	        String sql = "INSERT INTO menu (name, description, price, category, availability) VALUES (?, ?, ?, ?, ?)";

	        preparedStatement = con.prepareStatement(sql);

	        preparedStatement.setString(1, name);
	        preparedStatement.setString(2, description);
	        preparedStatement.setDouble(3, price);
	        preparedStatement.setString(4, category);
	        preparedStatement.setBoolean(5, availability);

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {

	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return isSuccess;
	}
    
	public static List<MenuItem> retrieveMenuItems() {
	    ArrayList<MenuItem> menuItems = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT * FROM menu";
	        preparedStatement = con.prepareStatement(sql);
	        resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("menu_id");
	            String name = resultSet.getString("name");
	            String description = resultSet.getString("description");
	            double price = resultSet.getDouble("price");
	            String category = resultSet.getString("category"); 
	            boolean availability = resultSet.getBoolean("availability"); 
	            MenuItem menuItem = new MenuItem(id, name, description, price, category, availability);
	            menuItems.add(menuItem);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return menuItems;
	}

    
	public static boolean deleteMenuItem(int menuId) {
	    boolean isSuccess = false;
	    Connection con = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        con = DBConnect.getConnection();

	        String sql = "DELETE FROM menu WHERE menu_id = ?";

	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setInt(1, menuId);

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return isSuccess;
	}


    
    

    public static boolean updateMenuItem(int menuID, String menuItemName, String newDescription, double newPriceValue, String newCategory, String newAvailabilityParam) {
        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBConnect.getConnection();

            String sql = "UPDATE menu SET name = ?, description = ?, price = ?, category = ?, availability = ? WHERE menu_id = ?";

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, menuItemName);
            preparedStatement.setString(2, newDescription);
            preparedStatement.setDouble(3, newPriceValue);
            preparedStatement.setBoolean(5, Boolean.parseBoolean(newAvailabilityParam));
            preparedStatement.setString(4, newCategory);
            preparedStatement.setInt(6, menuID);


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccess;
    }



}
   
	
	
	
	
	
	
	
	
	

