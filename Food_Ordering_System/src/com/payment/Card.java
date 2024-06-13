package com.payment.model;

public class Card extends Paymentmethod{
   
    private long cardNumber;
    private String exdate;
    private int cvv;
    
    
	public long getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getExdate() {
		return exdate;
	}


	public void setExdate(String exdate) {
		this.exdate = exdate;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


	public Card(int id, int amount, long cardNumber, String exdate, int cvv) {
		super(id, amount);
		this.cardNumber = cardNumber;
		this.exdate = exdate;
		this.cvv = cvv;
	}

   


	



	
}
