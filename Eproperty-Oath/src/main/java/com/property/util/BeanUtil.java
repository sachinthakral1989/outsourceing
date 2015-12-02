package com.property.util;

import org.springframework.beans.BeanUtils;

public class BeanUtil {

	public static  Object copyProperties(Object oldObject, Object newObject) {

		BeanUtils.copyProperties(oldObject, newObject);
		return newObject;
	}

}
