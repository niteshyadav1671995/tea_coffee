package com.yash.tcvm.enums;

public enum ContainerMaxCapacity {

	SUGAR(8000), TEA(2000), COFFEE(2000), MILK(10000), WATER(15000);

	private double maxCapacity;

	ContainerMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public double getMaxCapacity() {
		return maxCapacity;
	}

}
