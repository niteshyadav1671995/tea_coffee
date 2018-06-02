package com.yash.tcvm.serviceimpl;

import java.util.List;

import com.yash.tcvm.dao.ContainerDAO;
import com.yash.tcvm.daoimpl.ContainerDAOImpl;
import com.yash.tcvm.enums.Ingredient;
import com.yash.tcvm.exception.NullFieldException;
import com.yash.tcvm.model.Container;
import com.yash.tcvm.service.ContainerService;

public class ContainerServiceImpl implements ContainerService {

	private List<Container> containers;

	private static ContainerServiceImpl containerServiceImpl = new ContainerServiceImpl();
	private ContainerDAO containerDAO;

	public ContainerServiceImpl(ContainerDAO containerDAO) {
		this.containerDAO = containerDAO;
	}

	public ContainerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static ContainerServiceImpl getInstance() {
		return containerServiceImpl;
	}

	public Container getContainerByIngredient(Ingredient ingredient) throws NullFieldException {
		containerDAO = ContainerDAOImpl.getInstance();
		if (ingredient == null) {
			throw new NullFieldException("Ingredient Can not Be null");
		}
		containers = containerDAO.getListOfContainers();
		Container selectedContainer = null;
		for (Container container : containers) {
			if (container.getIngredient() == ingredient) {
				selectedContainer = container;
				break;
			}
		}
		return selectedContainer;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public Container updateContainer(Ingredient ingredient, Container container) throws NullFieldException {
		if (ingredient == null && container == null) {
			throw new NullFieldException("Ingredient And Container values cannot null");
		}
		Container updatedContainer = containerDAO.updateContainer(ingredient, container);
		return updatedContainer;
	}

	@Override
	public Integer refillContainers() throws NullFieldException {
		containers = containerDAO.getListOfContainers();
		double diff;
		int rowsAffected = 0;
		for (Container container : containers) {
			diff = container.getMaxCapacity() - container.getCurrentAvailability();
			System.out.println(container.getIngredient() + " : Empty " + diff + " , Available : "
					+ container.getCurrentAvailability() + " , Max Capacity : " + container.getMaxCapacity());
			container.setCurrentAvailability(container.getCurrentAvailability() + diff);
			updateContainer(container.getIngredient(), container);
		}
		rowsAffected = containers.size();
		System.out.println("Container ReFilled Successfully");
		return rowsAffected;
	}

	@Override
	public Integer containerStatus() {
		containers = containerDAO.getListOfContainers();
		int rowsAffected = 0;
		double diff;
		for (Container container : containers) {
			System.out.println(
					"Ingredient : " + container.getIngredient() + " , Max capacity: " + container.getMaxCapacity()
							+ " , Current availability: " + container.getCurrentAvailability() + "");
		}
		rowsAffected = containers.size();
		System.out.println("Container ReFilled Successfully");
		return rowsAffected;
	}

}
