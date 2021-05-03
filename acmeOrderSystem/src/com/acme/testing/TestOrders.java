package com.acme.testing;
import com.acme.domain.Service;

import java.time.LocalDate;
import java.time.Period;

import com.acme.domain.Good;
import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.domain.Order;
import com.acme.domain.Rushable;
import com.acme.domain.Solid;
import com.acme.utils.MyDate;

public class TestOrders {

	public static void main(String[] args) {
		Order.setTaxRate(0.05);

		MyDate hammerDate = new MyDate( 5, 17, 2016 ); 
		Solid hammerType = new Solid( "Acme Hammer", 281, 0.3,UnitOfMeasureType.CUBIC_METER, false, 100, 0.25, 0.3 );
		Order hammer = new Order( hammerDate, 10.00, "Wile E Coyote", hammerType, 10 );
		
		MyDate date1 = new MyDate(1, 20, 2008);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);
		MyDate date2 = new MyDate(4, 10, 2008);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);

		System.out.println(anvil);
		System.out.println(balloons);

		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		Order.setTaxRate(0.06);
		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();

		MyDate date3 = new MyDate( 4, 17, 2016);

		Order anotherAnvil = new Order(date3, 200, "Road Runner");
		System.out.println(anotherAnvil);

		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		balloons.setQuantity(-200);
		System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());

		System.out.println("The volume of the anvil is: " + ((Good)(anvil.getProduct())).volume());
		Solid anvilProduct = (Solid)anvil.getProduct() ; 
		System.out.println("The length of the anvil is: " + anvilProduct.getLength());
		
		MyDate date5 = new MyDate(4,10,2008);
		Service s3 = new Service("Road Runner Eradication", 14, false);
		Order birdEradication = new Order(date5, 20000, "Daffy Duck", 
		s3, 1);
		System.out.println("The total bill for: " + birdEradication + " is "
		+ birdEradication.computeTotal());

		Rushable rushableTest = (MyDate orderDate, double amount) -> { return (amount>1500);};
		
		
		
		
		Rushable Testrushable = (MyDate orderDate,double orderalount)-> { LocalDate currentdate = LocalDate.now(); 
		LocalDate from = LocalDate.of(orderDate.getYear(),orderDate.getMonth(),orderDate.getDay());
		Period period = Period.between(from,currentdate);
		return(period.getMonths()>0 || period.getYears()>0 );
		};
		
		
		
		
		Order.setRushable(rushableTest);
		System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder()); // true
		System.out.println("Balloons isPriorityOrder: " + balloons.isPriorityOrder()); // false
	
		
		
		
		System.out.println("Anvil isPriorityOrder: " +anvil.isPriorityOrder());
		System.out.println("Hammer isPriorityOrder: " + hammer.isPriorityOrder()); 
		
		

	}

}



