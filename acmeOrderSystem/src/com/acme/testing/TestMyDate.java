package com.acme.testing;

import com.acme.utils.MyDate;

public class TestMyDate {

	public static void main(String[] args) {
		MyDate.listHolidays();

		MyDate date1 = new MyDate(11, 11, 1918);
		MyDate date2 = new MyDate();
		date2.setDay(11);
		date2.setMonth(11);
		date2.setYear(1918);
		MyDate date3 = new MyDate();
		date3.setDate(13, 40, -1);
		String str1 = date1.toString();
		String str2 = date2.toString();
		String str3 = date3.toString();
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		MyDate date4 = new MyDate();
		String str4 = date4.toString();
		System.out.println(str4);
		System.out.println("");
		
		MyDate newYear = new MyDate(1, 1, 2009);
		MyDate fiscalStart = new MyDate(1, 1, 2009);

		if (newYear.equals(fiscalStart))
			System.out.println("These two dates are equal");
		else
			System.out.println("These two dates are not equal");
		
		
		MyDate d1 = new MyDate(1, 10, 2009);
		MyDate d2 = new MyDate(1, 11, 2009);

		if (d1.equals(d2))
			System.out.println("These two dates are equal");
		else
			System.out.println("These two dates are not equal");
		

		// MyDate.leapYears();
		
		
		
		
	}

	
	
	
}
