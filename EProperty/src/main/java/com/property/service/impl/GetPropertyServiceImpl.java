package com.property.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.gl.poc.couchbase.dto.CategoryDto;
import com.google.gson.Gson;
import com.property.dao.GetPropertyDataDao;
import com.property.dao.impl.GetPropertyDataDaoImpl;
import com.property.service.BaseService;
import com.property.util.AsyncExecutor;

public class GetPropertyServiceImpl implements BaseService {

	private static final BaseService instance = new GetPropertyServiceImpl();
	private static final Logger logger = Logger.getLogger(GetPropertyServiceImpl.class);
	Gson gson = new Gson();
	
	private GetPropertyDataDao getRetailDataDao = new GetPropertyDataDaoImpl();

	public static BaseService getInstance() {
		return instance;
	}

	@Override
	public List<CategoryDto> getAllCategories() throws Exception {
		
		Callable<List<CategoryDto>> asyncTask = new Callable<List<CategoryDto>> () {
			
			@Override
			public List<CategoryDto> call() throws Exception {
				List<CategoryDto> categories = null;
				ViewResponse response = getRetailDataDao.getAllCategories();
				if (response != null) {
					categories = new ArrayList<CategoryDto>();
					for (ViewRow row : response) {
						String id = row.getId();
						String title = row.getValue();
						System.out.println("id is "+id +" And "+ title);
						CategoryDto category = new CategoryDto();
						category.setId(id);
						category.setTitle(title);
						categories.add(category);

					}
				}
				return categories;
			}
		};
		
		Future<List<CategoryDto>> asyncResult = AsyncExecutor.queueAndExecute(asyncTask);
		List<CategoryDto> categories = asyncResult.get();
	    return categories;
	}
	
}
