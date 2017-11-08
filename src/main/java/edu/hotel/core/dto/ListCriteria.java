/**
 * 
 */
package edu.hotel.core.dto;

/**
 * @author Nazmul Hassan
 *
 */
public class ListCriteria {

	private Integer page;
	
	private String sortByColumnName;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSortByColumnName() {
		return sortByColumnName;
	}

	public void setSortByColumnName(String sortByColumnName) {
		this.sortByColumnName = sortByColumnName;
	}
	
	
}
