package com.yash.tcvm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.yash.tcvm.exception.EmptyException;
import com.yash.tcvm.model.Container;
import com.yash.tcvm.model.Order;

public class JSONUtil {

	private static final String FILE_PATH_CONTAINER_JSON = "src/main/resources/Json/Container.json";
	private static final String FILE_PATH_ORDER_JSON = "src/main/resources/Json/Order.json";

	public void writeObjectToJSON(List<Container> containerList) {
		Gson gson = new GsonBuilder().create();
		try {
			String containersJson = gson.toJson(containerList);
			FileWriter jsonFileWriter = new FileWriter(FILE_PATH_CONTAINER_JSON);
			jsonFileWriter.write(containersJson);
			jsonFileWriter.close();
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}
	}

	public List readObjectFromJson() {
		List<Container> containers = null;
		Gson gson = new GsonBuilder().create();
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader(FILE_PATH_CONTAINER_JSON);
			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				containers = gson.fromJson(jsonfromString, new TypeToken<List<Container>>() {
				}.getType());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return containers;
	}

	public static void writeJSONToFile(List<Order> orders) {
		Gson gson = new GsonBuilder().create();
		try {
			String containersJson = gson.toJson(orders);
			FileWriter jsonFileWriter = new FileWriter(FILE_PATH_ORDER_JSON);
			jsonFileWriter.write(containersJson);
			jsonFileWriter.close();
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Order> readOrderJSONFromFile() throws FileNotFoundException, EmptyException {
		List<Order> orders = null;
		Gson gson = new GsonBuilder().create();
		File fileToBeRead = new File(FILE_PATH_ORDER_JSON);
		if (!fileToBeRead.exists()) {
			throw new FileNotFoundException("File doesnt exist");
		}

		if (fileToBeRead.length() <= 0) {
			throw new EmptyException("File is empty");
		}
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader(fileToBeRead);

			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				orders = gson.fromJson(jsonfromString, new TypeToken<List<Order>>() {
				}.getType());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
