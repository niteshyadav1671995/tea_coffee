package com.yash.tcvm.serviceimpl;

import java.io.FileNotFoundException;
import java.util.List;

import com.yash.tcvm.builder.BlackCoffeeBuilder;
import com.yash.tcvm.builder.BlackTeaBuilder;
import com.yash.tcvm.builder.CoffeeBuilder;
import com.yash.tcvm.builder.IDrinkBuilder;
import com.yash.tcvm.builder.TeaBuilder;
import com.yash.tcvm.dao.OrderDao;
import com.yash.tcvm.enums.Drink;
import com.yash.tcvm.exception.EmptyException;
import com.yash.tcvm.model.Order;
import com.yash.tcvm.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;

	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> getOrders() throws FileNotFoundException, EmptyException {
		List<Order> orders = orderDao.getOrders();
		if (orders == null) {
			throw new NullPointerException("Order's list is null");
		}

		if (orders.isEmpty()) {
			throw new EmptyException("Order's list is empty");
		}
		return orders;
	}

	@Override
	public List<Order> getOrdersByDrink(Drink drink) throws FileNotFoundException, EmptyException {
		List<Order> ordersListByDrink = orderDao.getOrdersByDrink(drink);
		if (ordersListByDrink == null) {
			throw new NullPointerException("Order's list for given drink is null");
		}

		if (ordersListByDrink.isEmpty()) {
			throw new EmptyException("Order's list for given drink is empty");
		}
		return ordersListByDrink;
	}

	@Override
	public int addOrder(Order order) throws FileNotFoundException, EmptyException {
		IDrinkBuilder drinkBuilder;

		int rowsAffected = 0;
		if (order == null) {
			throw new NullPointerException("Order cannot be null");
		}
		try {
			switch (order.getDrink()) {
			case TEA:
				drinkBuilder = TeaBuilder.getDrinkBuilder();
				drinkBuilder.prepareDrink(order);
				break;
			case COFFEE:
				drinkBuilder = CoffeeBuilder.getDrinkBuilder();
				drinkBuilder.prepareDrink(order);
				break;
			case BLACK_TEA:
				drinkBuilder = BlackTeaBuilder.getDrinkBuilder();
				drinkBuilder.prepareDrink(order);
				break;
			case BLACK_COFFEE:
				drinkBuilder = BlackCoffeeBuilder.getDrinkBuilder();
				drinkBuilder.prepareDrink(order);
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		rowsAffected = orderDao.insertOrder(order);
		return rowsAffected;
	}

}
