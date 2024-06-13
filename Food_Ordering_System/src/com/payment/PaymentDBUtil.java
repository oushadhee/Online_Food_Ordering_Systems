package com.payment.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payment.model.Card;
import com.util.DBConnect;

public class PaymentDBUtil {
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

  
    public static boolean insertcustomer(String amount, String cardNumber, String exdate, String cvv) {
        try (Connection con = DBConnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO bill (amount, cardNumber, exdate, cvv) VALUES (?, ?, ?, ?)")) {

            pstmt.setString(1, amount);
            pstmt.setString(2, cardNumber);
            pstmt.setString(3, exdate);
            pstmt.setString(4, cvv);

            int rs = pstmt.executeUpdate();

            return rs > 0; 
        } catch (Exception e) {
        	System.out.println("xxxxxxx");
            e.printStackTrace(); 
        }

        return false;
    }


        public static boolean updatecustomer(String id, String amount, String cardNumber, String exdate, String cvv) {
            try (Connection con = DBConnect.getConnection();
                 PreparedStatement pstmt = con.prepareStatement("UPDATE bill SET amount = ?, cardNumber = ?, exdate = ?, cvv = ? WHERE id = ?")) {

                pstmt.setString(1, amount);
                pstmt.setString(2, cardNumber);
                pstmt.setString(3, exdate);
                pstmt.setString(4, cvv);
                pstmt.setString(5, id);

                int rs = pstmt.executeUpdate();

                return rs > 0;
            } catch (Exception e) {
                e.printStackTrace(); 
            }

            return false;
        }

      
    

    public static List<Card> getCustomerDetails(String Id) {
        int convertedID = Integer.parseInt(Id);

        ArrayList<Card> cus = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
           stmt = con.createStatement();
            String sql = "select * from bill where id= '"+convertedID+"'";
           
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, convertedID);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                int amount = rs.getInt(2);
                int cardNumber = rs.getInt(3);
                String exdate = rs.getString(4);
                int cvv = rs.getInt(5);

                Card c = new Card(id, amount, cardNumber, exdate, cvv);
                cus.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cus;
    }

    public static boolean deleteCustomer(String id) {
        int convId = Integer.parseInt(id);

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "delete from bill where id = '" + convId + "' ";
            int r = stmt.executeUpdate(sql);

            return r > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }

   

    public static List<Card> retrieveCustomers() {
        List<Card> customers = new ArrayList<>();

        try (Connection con = DBConnect.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bill ORDER BY id DESC")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int amount = rs.getInt("amount");
                long cardNumber =rs.getLong("cardNumber") ;
                String exdate = rs.getString("exdate");
                int cvv = rs.getInt("cvv");

                Card customer = new Card(id, amount, cardNumber, exdate, cvv);
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }




	

}