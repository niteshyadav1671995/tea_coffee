package com.yash.tcvm.model;

import com.yash.tcvm.enums.Ingredient;

public class Container {

	private Ingredient ingredient;

	private double maxCapacity;

	private double currentAvailability;

	public Container() {
		// TODO Auto-generated constructor stub
	}

	public Container(Ingredient ingredient, double maxCapacity, double currentAvailability) {
		super();
		this.ingredient = ingredient;
		this.maxCapacity = maxCapacity;
		this.currentAvailability = currentAvailability;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public double getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public double getCurrentAvailability() {
		return currentAvailability;
	}

	public void setCurrentAvailability(double currentAvailability) {
		this.currentAvailability = currentAvailability;
	}

	@Override
	public String toString() {
		return "Container [ingredient=" + ingredient + ", maxCapacity=" + maxCapacity + ", currentAvailability="
				+ currentAvailability + "]";
	}

}
