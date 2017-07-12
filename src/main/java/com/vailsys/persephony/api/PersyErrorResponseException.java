package com.vailsys.persephony.api;

/**
 * This exception is thrown when the Persephony API responds with and HTTP
 * error code to some user request.
 */
public class PersyErrorResponseException extends PersyException {
	private PersyError pe;

	/**
	 *
	 */
	public PersyErrorResponseException(int status, String message, int code, String info) {
		super("ErrorResponse ("+status+")::"+code+":"+message);
		this.pe= new PersyError(status, message, code, info);
	}

	/**
	 *
	 */
	public PersyErrorResponseException(PersyError pe) {
		super("ErrorResponse ("+pe.getStatus()+")::"+pe.getCode()+":"+pe.getMessage());
		this.pe = pe;
	}

	/**
	 * @return an object representing the error payload returned from the
	 * Persephony API
	 */
	public PersyError getError() {
		return this.pe;
	}
}
