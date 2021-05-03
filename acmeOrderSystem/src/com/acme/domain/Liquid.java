package com.acme.domain;

//import com.acme.domain.Good;

public class Liquid extends Good {
	private double radius;

	public Liquid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable,
			double wgtPerUofM, double radius) {
		super(name, modelNumber, height, uoM, flammable, wgtPerUofM);
		this.radius = radius;
	}

	public double volume() {
		return Math.PI * radius * radius * getHeight();
	}

	public String toString() {
		return super.toString() + " (liquid) " + volume() + " " + getUnitOfMeasure();
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
