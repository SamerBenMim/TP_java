package com.acme.domain;

import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.utils.HolidayOrdersNotAllowedException;
import com.acme.utils.MyDate;


public class Order {
	private boolean isHoliday(MyDate proposedDate) {boolean result = false;
	for (MyDate holiday :MyDate.getHolidays()) {
		if( holiday.equals(proposedDate) ) {
		result =true;
		}
	}
	return result;
	}
	
	
	
	public void setOrderDate(MyDate orderDate) throws 
	HolidayOrdersNotAllowedException {
		if (isHoliday(orderDate)) {
			System.out.println("Order date, " + orderDate
			+ ", cannot be set to a holiday!");
			throw new HolidayOrdersNotAllowedException(orderDate);
			} else {
			this.orderDate = orderDate;
			}}
	
	
	
	public static double taxRate;

	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}

	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}

	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}

	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
//	private Good product;
	private Product product;

	private int quantity;

	public MyDate getOrderDate() {
		return orderDate;
	}



	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if (orderAmount >= 0) {
			this.orderAmount = orderAmount;
		}
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity >= 0) {
			this.quantity = quantity;
		}

	}

	
	public Order(MyDate d, double amt, String c, Product p, int q) {
		 try {
		setOrderDate(d);
		 } catch (HolidayOrdersNotAllowedException e){
		 System.out.println("The order date for an order cannot be a holiday! Application closing.");
		 System.exit(0); 
		 }
		 orderAmount = amt;
		 customer = c;
		 product = p;
		 quantity = q;
		}


	
	
	
	public Order(MyDate d, double amt, String c) {

		this(d, amt, c, new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3), 1);
	}

	public String toString() {
		return quantity + " ea. " + product + " for " + customer;
	}

	public char jobSize() {
		if (quantity <= 25) {
			return 'S';
		} else if (quantity <= 75) {
			return 'M';
		} else if (quantity <= 150) {
			return 'L';
		} else {
			return 'X';
		}
	}

	public double computeDiscount() {
		// ...your work here to compute the total based on the
		if (jobSize() == 'S') {
			return ((double) 0.0);
		} else if (jobSize() == 'M') {
			return ((double) 0.01);
		} else if (jobSize() == 'L') {
			return (double) 0.02;
		} else if (jobSize() == 'X') {
			return (double) 0.03;
		}
		return 0;
	}

	public double computeTotal() {
		// ...your work here to compute the total based on the
		if (orderAmount > 1500) {
			return (double) (orderAmount * (1 - computeDiscount()));
		} else {
			return (double) (orderAmount * (1 - computeDiscount()) + computeTax());
		}

	}

	private static Rushable rushable;

	public static Rushable getRushable() {
		return rushable;
	}

	public static void setRushable(Rushable rushable) {
		Order.rushable = rushable;
	}

	public boolean isPriorityOrder() {
		boolean priorityOrder = false;
		if (rushable != null) {
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
		}
		return priorityOrder;
	}
	
}
