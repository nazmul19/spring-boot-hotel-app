package edu.hotel.core.query.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.hotel.core.domain.Deal;
import edu.hotel.core.dto.DealDetail;
import edu.hotel.core.dto.DealStatistics;
import edu.hotel.core.dto.ListCriteria;
import edu.hotel.core.query.DealDao;
import edu.hotel.core.util.Utility;


public class DealDaoImpl implements DealDao{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<DealDetail> getDeals(ListCriteria criteria) {
		List<DealDetail> deals = null;
		String sql = " Select * from hotel_deals ";
		if(criteria.getSortByColumnName() != null){
			sql =  sql + " order by "+ criteria.getSortByColumnName();
			sql = sql + (criteria.getSortByColumnName() == "actual_price" ? " asc " : " desc ");
		}
		
		sql  = sql + " limit "+ (criteria.getPage() -1) + ",6 ";
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		
		if(rows != null && rows.size() > 0)
			deals = new ArrayList<DealDetail>();
		
		for (Map row : rows) {
			Deal deal = new Deal();
			deal.setId(Utility.numberToLong(row.get("id")));
			deal.setName((String) row.get("name"));
			deal.setImage((String) row.get("image"));
			deal.setRating(Utility.numberToFloat(row.get("rating")));
			deal.setLink((String) row.get("link"));
			deal.setActual_price(Utility.numberToFloat(row.get("actual_price")));
			deal.setDiscount(Utility.numberToInt(row.get("discount")));
			deal.setLocation((String) row.get("location"));
			
			deals.add(DealDetail.from(deal));
		}
		
		return deals;
	}

	public DealStatistics getStats() {
		DealStatistics stats = null;
		String aggregateStatsAsNumber = "select avg(rating)  as avgRating, min(actual_price) as minAPrice, max(actual_price) as maxAPrice from hotel_deals ";
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(aggregateStatsAsNumber);
		for (Map row : rows) {
			stats = new DealStatistics();
			stats.setAvegargeRating(Utility.numberToFloat(row.get("avgRating")));
			stats.setMinPrice(Utility.numberToFloat(row.get("minAPrice")));
			stats.setMaxPrice(Utility.numberToFloat(row.get("maxAPrice")));
			break;
		}
		
		Map<String,Integer> locationWiseCount = new HashMap<String, Integer>();
		
		locationWiseCount.put("DEL", jdbcTemplate.queryForInt("select count(*) from hotel_deals where location like '%New Delhi%'"));
		locationWiseCount.put("BLR", jdbcTemplate.queryForInt("select count(*) from hotel_deals where location like '%Bengaluru%'"));
		locationWiseCount.put("MUM", jdbcTemplate.queryForInt("select count(*) from hotel_deals where location like '%Mumbai%'"));
		locationWiseCount.put("CHE", jdbcTemplate.queryForInt("select count(*) from hotel_deals where location like '%Chenai%'"));
		locationWiseCount.put("HYD", jdbcTemplate.queryForInt("select count(*) from hotel_deals where location like '%Hyederabad%'"));
		
		stats.setAreaWiseHotelDistribution(locationWiseCount);
		
		return stats;
	}

	@Override
	public DealDetail search(String searchValue) {
		String sql = " Select * from hotel_deals ";
		if(searchValue == null || searchValue =="")
			return null;
		
		sql = sql + " where name='"+ searchValue + "' or location='"+searchValue+"' ";
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		DealDetail detail = null;
		for (Map row : rows) {
			Deal deal = new Deal();
			deal.setId(Utility.numberToLong(row.get("id")));
			deal.setName((String) row.get("name"));
			deal.setImage((String) row.get("image"));
			deal.setRating(Utility.numberToFloat(row.get("rating")));
			deal.setLink((String) row.get("link"));
			deal.setActual_price(Utility.numberToFloat(row.get("actual_price")));
			deal.setDiscount(Utility.numberToInt(row.get("discount")));
			deal.setLocation((String) row.get("location"));
			detail = DealDetail.from(deal);
			break;
		}
		return detail;
	}

	
}
