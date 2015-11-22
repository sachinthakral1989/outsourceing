package com.property.util;


import com.google.gson.Gson;

public class JsonUtil<T> {

	public T unmarshal(String json, Class<T> entityClass) {
		Gson gson = new Gson();
		T entityType = (T) gson.fromJson(json, entityClass);
		return entityType;
	}

	public static String marshal(Object obj) {
		Gson gson = new Gson();
		String jsonDoc = gson.toJson(obj);
		return jsonDoc;
	}

}
