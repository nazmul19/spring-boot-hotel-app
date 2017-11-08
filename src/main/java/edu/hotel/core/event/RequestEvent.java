/**
 * 
 */
package edu.hotel.core.event;

/**
 * @author Nazmul Hassan
 *
 */
public class RequestEvent<T> {

	private T payload;
	
	public RequestEvent() {		
	}
	
	public RequestEvent(T payload) {
		this.payload = payload;
	}
	
	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
	
}