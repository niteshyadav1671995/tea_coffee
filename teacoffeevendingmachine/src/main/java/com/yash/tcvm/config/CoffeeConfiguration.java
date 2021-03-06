package com.yash.tcvm.config;

import java.util.HashMap;
import java.util.Map;

import com.yash.tcvm.config.IDrinkConfigurer;
import com.yash.tcvm.enums.Drink;
import com.yash.tcvm.enums.Ingredient;

public class CoffeeConfiguration extends AbstractDrinkConfigurer {

	private static IDrinkConfigurer drinkConfigurer;

	public static final double WATER_CONSUMPTION = 20;
	public static final double SUGAR_CONSUMPTION = 15;
	public static final double MILK_CONSUMPTION = 80;
	public static final double COFFEE_CONSUMPTION = 4;

	public static final double WATER_WASTAGE = 3;
	public static final double SUGAR_WASTAGE = 2;
	public static final double MILK_WASTAGE = 8;
	public static final double COFFEE_WASTAGE = 1;

	public static final double RATE = 15;

	private CoffeeConfiguration() {
		// TODO Auto-generated constructor stub
	}

	static {
		drinkConfigurer = new CoffeeConfiguration();
	}
	
	public static IDrinkConfigurer getDrinkConfigurer() {
		return drinkConfigurer;
	}

	public void configIngredientConsumption() {
		Map<Ingredient, Double> ingredientsConsumption = new HashMap<Ingredient, Double>();

		ingredientsConsumption.put(Ingredient.COFFEE, COFFEE_CONSUMPTION);
		ingredientsConsumption.put(Ingredient.MILK, MILK_CONSUMPTION);
		ingredientsConsumption.put(Ingredient.WATER, WATER_CONSUMPTION);
		ingredientsConsumption.put(Ingredient.SUGAR, SUGAR_CONSUMPTION);

		setIngredientConsumption(ingredientsConsumption);
	}

	public void configIngredientWastage() {
		Map<Ingredient, Double> ingredientsWastage = new HashMap<Ingredient, Double>();
		ingredientsWastage.put(Ingredient.COFFEE, COFFEE_WASTAGE);
		ingredientsWastage.put(Ingredient.MILK, MILK_WASTAGE);
		ingredientsWastage.put(Ingredient.WATER, WATER_WASTAGE);
		ingredientsWastage.put(Ingredient.SUGAR, SUGAR_WASTAGE);
		setIngredientWastage(ingredientsWastage);
	}

	public void configDrinkType() {
		setDrinkType(Drink.COFFEE);
	}

	public void configDrinkRate() {
		setDrinkRate(RATE);
	}

}
