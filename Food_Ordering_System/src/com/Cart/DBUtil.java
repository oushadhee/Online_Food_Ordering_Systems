package com.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
	
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
                String category = resultSet.getString("description");
                boolean availability = resultSet.getBoolean("availability"); 
                double price = resultSet.getDouble("price");

                MenuItem menuItem = new MenuItem(id,name, description, price,category,availability);
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
	
	
	public static boolean insertCartItem( int menuId, String itemName,double itemPrice,int quantity) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        con = DBConnect.getConnection();

	        String sql = "INSERT INTO cart (menu_id, name, price, quantity) VALUES (?, ?, ?, ?)";
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setInt(1,menuId);
	        preparedStatement.setString(2, itemName);
	        preparedStatement.setDouble(3, itemPrice);
	        preparedStatement.setInt(4, quantity);

	        int rowsAffected = preparedStatement.executeUpdate();

	        return rowsAffected > 0; // Return true if the item was successfully inserted
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // Return false on failure
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
	}
	
	public static List<CartItem> getCartItems() {
	    ArrayList<CartItem> cartItems = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        con = DBConnect.getConnection();
	        String sql = "SELECT * FROM cart";
	        preparedStatement = con.prepareStatement(sql);
	        resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            int menuId = resultSet.getInt("menu_id");
	            int quantity = resultSet.getInt("quantity");
	            String name = resultSet.getString("name");
	            double price = resultSet.getDouble("price");
	            
	            CartItem cartItem = new CartItem(id, menuId , quantity, name, price);
	            cartItems.add(cartItem);
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

	    return cartItems;
	}
	
	public static boolean removeItem(int itemId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnect.getConnection(); // Obtain a database connection

            String sql = "DELETE FROM cart WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, itemId);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; // Return true if the item was successfully removed
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false on failure
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public static boolean updateCartItemQuantity(int itemId, int newQuantity) {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = DBConnect.getConnection(); // Obtain a database connection

	        String sql = "UPDATE cart SET quantity = ? WHERE id = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, newQuantity);
	        stmt.setInt(2, itemId);

	        int rowsAffected = stmt.executeUpdate();

	        // Return true if the item quantity was successfully updated (rowsAffected > 0)
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // Return false on failure
	    } finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



	    
	}

	

    

