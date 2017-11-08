package edu.hotel.core.dto;

import java.util.Map;

public class DealStatistics {

	private Float avegargeRating;
	
	private Integer apiHits;
	
	private Float minPrice;
	
	private Float maxPrice;
	
	private Map<String, Integer> areaWiseHotelDistribution;

	public Float getAvegargeRating() {
		return avegargeRating;
	}

	public void setAvegargeRating(Float avegargeRating) {
		this.avegargeRating = avegargeRating;
	}

	public Integer getApiHits() {
		return apiHits;
	}

	public void setApiHits(Integer apiHits) {
		this.apiHits = apiHits;
	}

	public Float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Float minPrice) {
		this.minPrice = minPrice;
	}

	public Float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Map<String, Integer> getAreaWiseHotelDistribution() {
		return areaWiseHotelDistribution;
	}

	public void setAreaWiseHotelDistribution(
			Map<String, Integer> areaWiseHotelDistribution) {
		this.areaWiseHotelDistribution = areaWiseHotelDistribution;
	}
}
