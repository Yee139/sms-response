package com.royall.sms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SMSStatusDTO {
	
	private String from;
	private String to;
	private String smsStatus;
	
	public SMSStatusDTO() { }
	
	@JsonCreator
	public SMSStatusDTO(@JsonProperty("from") String from, @JsonProperty("to") String to, @JsonProperty("smsStatus") String smsStatus) {
		super();
		this.from = from;
		this.to = to;
		this.smsStatus = smsStatus;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the smsStatus
	 */
	public String getSmsStatus() {
		return smsStatus;
	}

	/**
	 * @param smsStatus the smsStatus to set
	 */
	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SMSStatusDTO [from=").append(from).append(", to=").append(to).append(", smsStatus=")
				.append(smsStatus).append("]");
		return builder.toString();
	}
	
}