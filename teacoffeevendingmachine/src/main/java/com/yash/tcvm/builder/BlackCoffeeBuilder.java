package com.yash.tcvm.builder;

import com.yash.tcvm.config.BlackCoffeeConfiguration;
import com.yash.tcvm.enums.Drink;
import com.yash.tcvm.exception.ContainerUnderflowException;
import com.yash.tcvm.exception.NullFieldException;
import com.yash.tcvm.model.Order;

public class BlackCoffeeBuilder extends AbstractDrinkBuilder {

	public BlackCoffeeBuilder() {
		setDrinkConfigurer(BlackCoffeeConfiguration.getDrinkConfigurer());
	}

	@Override
	public void prepareDrink(Order order) throws ContainerUnderflowException, NullFieldException {
		if (order.getDrink() == Drink.BLACK_COFFEE) {
			super.prepareDrink(order);
		} else {
			throw new IllegalArgumentException(
					"Wrong Drink Type, required " + Drink.BLACK_COFFEE + " and found " + order.getDrink());
		}
	}

	public static IDrinkBuilder getDrinkBuilder() {
		return new BlackCoffeeBuilder();
	}

}
