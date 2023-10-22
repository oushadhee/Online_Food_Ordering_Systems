package com.Cart;

public class CartItem {
    private int id;
    private int menuId; 
    private String name;
    private double price;
    private int quantity;

    public CartItem(int id, int menuId, int quantity, String name, double price) {
        this.id = id;
        this.menuId = menuId;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    
    }

    public int getId() {
        return id;
    }
    

    public int getMenuId() {
        return menuId;
    }

    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

   
}
