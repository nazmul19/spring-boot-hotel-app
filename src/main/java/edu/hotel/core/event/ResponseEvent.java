/**
 * 
 */
package edu.hotel.core.event;

/**
 * @author Nazmul Hassan
 *
 */
public class ResponseEvent<T> {

	private T payload;

	public ResponseEvent(T payload) {
		this.payload = payload;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
	
	public static <P> ResponseEvent<P> response(P payload) {
		return new ResponseEvent<P>(payload);
	}
}
