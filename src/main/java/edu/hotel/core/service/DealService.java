/**
 * 
 */
package edu.hotel.core.service;

import java.util.List;

import edu.hotel.core.dto.DealDetail;
import edu.hotel.core.dto.DealStatistics;
import edu.hotel.core.dto.ListCriteria;
import edu.hotel.core.event.RequestEvent;
import edu.hotel.core.event.ResponseEvent;

/**
 * @author Nazmul Hassan
 *
 */
public interface DealService {

	public ResponseEvent<List<DealDetail>> getDeals(RequestEvent<ListCriteria> request);
	
	public ResponseEvent<DealStatistics> getStats();
	
	public ResponseEvent<DealDetail> searchDeal(RequestEvent<String> req);
	
}
