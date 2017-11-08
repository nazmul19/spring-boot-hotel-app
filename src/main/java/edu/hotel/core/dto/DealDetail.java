/**
 * 
 */
package edu.hotel.core.dto;

import edu.hotel.core.domain.Deal;

/**
 * @author Nazmul Hassan
 *
 */
public class DealDetail {

	private Long id;

	private String name;

	private String image;

	private Float rating;

	private String link;

	private Float actual_price;

	private Integer discount;

	private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Float getActual_price() {
		return actual_price;
	}

	public void setActual_price(Float actual_price) {
		this.actual_price = actual_price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public static DealDetail from(Deal deal){
		DealDetail detail = new DealDetail();
		detail.setId(deal.getId());
		detail.setActual_price(deal.getActual_price());
		detail.setDiscount(deal.getDiscount());
		detail.setImage(deal.getImage());
		detail.setLink(detail.getLink());
		detail.setLocation(detail.getLocation());
		detail.setName(deal.getName());
		detail.setRating(deal.getRating());
		return detail;
	}
}
