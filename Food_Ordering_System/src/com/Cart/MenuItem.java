package com.Cart;


	public class MenuItem {
		private int id;
	    private String name;
	    private String description;
	    private double price;
	    private String category;
	    private boolean availability;
	

	    public MenuItem(int id , String name,  String description, double price, String category, boolean availability) {
	    	this.id=id;
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.category = category;
	        this.availability = availability;
	        
	    }
	    public String getCategory() {
			return category;
		}
		
		public boolean isAvailability() {
			return availability;
		}
		
		public int getId() {
	        return id;
	    }


	    public String getName() {
	        return name;
	    }

	    
	    public String getDescription() {
	        return description;
	    }

	   
	    public double getPrice() {
	        return price;
	    }

	  
	}

