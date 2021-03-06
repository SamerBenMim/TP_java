package com.acme.utils;


public class MyDate {
	private int day;
	private int year;
	private int month;

	public MyDate() {
		this(1, 1, 1900);
	}

	public MyDate(int m, int d, int y) {
		if (valid(d, m, y)) {
			month = m;
			day = d;
			year = y;
		}
	}

	public String toString() {
		String ch = month + "/" + day + "/" + year;
		return ch;
	}

	public void setDate(int m, int d, int y) {
		if (valid(d, m, y)) {
			month = m;
			day = d;
			year = y;
		}
	}

	public static void leapYears() {
		int y = 1752;
		while (y <= 2020) {
			if (y % 400 == 0) {
				System.out.println("The year " + y + " is a leap year");
			} else if (y % 4 == 0 && y % 100 != 0) {
				System.out.println("The year " + y + " is a leap year");
			}
			y++;
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (valid(day, month, year)) {
			this.day = day;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (valid(day, month, year)) {
			this.year = year;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (valid(day, month, year)) {
			this.month = month;
		}
	}

	private boolean valid(int day, int month, int year) {
		if (day > 31 || day < 1 || month > 12 || month < 1) {
			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
			return false;
		}
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			return (day <= 30);
		case 2:
			return day <= 28 || (day == 29 && year % 4 == 0);
		}
		return true;
	}

	public boolean equals(Object o) {
		if (o instanceof MyDate) {
			MyDate d = (MyDate) o;
			if ((d.day == day) && (d.month == month) && (d.year == year)) {
				return true;
			}
		}
		return false;
	}
	
	private static MyDate[] holidays;
	static {holidays = new MyDate[6];
	holidays[0]= new MyDate(1,1,2012);
	holidays[1]= new MyDate(5,28,2012);
	holidays[2]= new MyDate(7,4,202);
	holidays[3]= new MyDate(9,3,2012);
	holidays[4]= new MyDate(11,22,2012);
	holidays[5]= new MyDate(12,25,2012);
	}

	
	public static MyDate[] getHolidays(){return holidays;}
	
	
	public static void listHolidays() {
	System.out.println("the holidays are:");
	for ( MyDate x  : holidays){
		System.out.println(x);
		}
	}
	
	
	
	
	
}
