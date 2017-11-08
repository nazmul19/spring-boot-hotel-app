/**
 * 
 */
package edu.hotel.core.service.impl;

import java.util.List;

import edu.hotel.core.dto.DealDetail;
import edu.hotel.core.dto.DealStatistics;
import edu.hotel.core.dto.ListCriteria;
import edu.hotel.core.event.RequestEvent;
import edu.hotel.core.event.ResponseEvent;
import edu.hotel.core.query.DealDao;
import edu.hotel.core.service.DealService;
import edu.hotel.rest.controller.HotelDealsController;

/**
 * @author Nazmul Hassan
 *
 */
public class DealServiceImpl implements DealService{

	private DealDao dealDao;
	
	public DealDao getDealDao() {
		return dealDao;
	}

	public void setDealDao(DealDao dealDao) {
		this.dealDao = dealDao;
	}

	
	public ResponseEvent<List<DealDetail>> getDeals(
			RequestEvent<ListCriteria> request) {
		List<DealDetail> deals = dealDao.getDeals(request.getPayload());
		return ResponseEvent.response(deals);
	}

	
	public ResponseEvent<DealStatistics> getStats() {
		DealStatistics stats = dealDao.getStats();
		return ResponseEvent.response(stats);
	}

	@Override
	public ResponseEvent<DealDetail> searchDeal(RequestEvent<String> req) {
		if(req.getPayload() == null)
			return null;
		return ResponseEvent.response(dealDao.search(req.getPayload()));
	}

	
}
