package com.property.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;

import com.gl.poc.couchbase.dto.LandingScreenDetailDTO;
import com.gl.poc.couchbase.dto.OrderSearchDto;
import com.gl.poc.couchbase.dto.PaginationDto;
import com.gl.poc.couchbase.dto.ProductVariantDto;
import com.gl.poc.couchbase.dto.ProductVirtualDto;
import com.gl.poc.couchbase.dto.OrderDto;
import com.gl.poc.couchbase.response.GetOrderInfoByLimitResponse;
import com.gl.poc.couchbase.response.GetProductByLimitResponse;
import com.gl.poc.couchbase.response.GetProductVariantsResponse;

@Path("")
public interface PropertyServiceApi {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getAllCategories")
	public LandingScreenDetailDTO getAllCategories()throws Exception;
	
	
}

