/**
 * 
 */
package edu.hotel.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.hotel.core.dto.DealDetail;
import edu.hotel.core.dto.DealStatistics;
import edu.hotel.core.dto.ListCriteria;
import edu.hotel.core.event.RequestEvent;
import edu.hotel.core.event.ResponseEvent;
import edu.hotel.core.service.DealService;

/**
 * @author Nazmul Hassan
 *
 */
@Controller
@RequestMapping("/hotel-deals")
public class HotelDealsController {

	@Autowired
	private DealService dealService;
	
	private static Integer apiHits = 0;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody	
	public String greeting(
			) {
		
		return "Hello World";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/list")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody	
	public List<DealDetail> getDeals(
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy) {
		
		ListCriteria criteria = new ListCriteria();
		criteria.setPage(page);
		criteria.setSortByColumnName(sortBy);
		RequestEvent<ListCriteria> request = new RequestEvent<ListCriteria>(criteria);
		ResponseEvent<List<DealDetail>> response = dealService.getDeals(request);
		return response.getPayload();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/stats")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody	
	public DealStatistics getStats() {
		ResponseEvent<DealStatistics> response = dealService.getStats();
		apiHits = apiHits + 1;
		response.getPayload().setApiHits(apiHits);
		return response.getPayload();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/search")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody	
	public DealDetail search(
			@RequestParam(value = "q", required = true, defaultValue = "") String nameOrLocation) {
		
		RequestEvent<String> request = new RequestEvent<String>(nameOrLocation);
		ResponseEvent<DealDetail> response = dealService.searchDeal(request);
		return response.getPayload();
	}
}
