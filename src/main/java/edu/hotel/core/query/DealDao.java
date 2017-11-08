/**
 * 
 */
package edu.hotel.core.query;

import java.util.List;

import edu.hotel.core.dto.DealDetail;
import edu.hotel.core.dto.DealStatistics;
import edu.hotel.core.dto.ListCriteria;

/**
 * @author Nazmul Hassan
 *
 */
public interface DealDao {

	public List<DealDetail> getDeals(ListCriteria criteria);
	
	public DealStatistics getStats();
	
	public DealDetail search(String searchValue);
	
	
}
