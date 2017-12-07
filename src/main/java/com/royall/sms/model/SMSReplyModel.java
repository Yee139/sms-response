package com.royall.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * Sample POST
 {
 "messageSid": "34394DDFJJFJF",
 "accountSid": "23434SJKASLJJ",
 "messagingServiceSid": "DKLDFJJI393933",
 "from": "Test From",
 "to": "Test To",
 "body":"Test Body",
 "numMedia":"322323",
 "media":"23324",
 "fromCity":"Richmond",
 "fromState":"Virginia",
 "fromZip":"23229",
 "fromCountry":"USA", 
 "toCity":"Richmond", 
 "toState":"Virginia", 
 "toZip":"23229", 
 "toCountry":"USA"
 }
 *
 */
@Entity
@Table(name = "sms_reply")
public class SMSReplyModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String messageSid;
	private String accountSid;
	private String messagingServiceSid;
	@Column(name="fromNum")
	private String from;
	@Column(name="toNum")
	private String to;
	private String body;
	private String numMedia;
	private String media;
	private String fromCity;
	private String fromState;
	private String fromZip;
	private String fromCountry;
	private String toCity;
	private String toState;
	private String toZip;
	private String toCountry;
	private String username = "twilio";
	
	public SMSReplyModel() { }
	
	@JsonCreator
	public SMSReplyModel(@JsonProperty("messageSid") String messageSid, @JsonProperty("accountSid") String accountSid,
			@JsonProperty("messagingServiceSid") String messagingServiceSid, @JsonProperty("from") String from,
			@JsonProperty("to") String to, @JsonProperty("body") String body, @JsonProperty("numMedia") String numMedia,
			@JsonProperty("media") String media, @JsonProperty("fromCity") String fromCity, @JsonProperty("fromState") String fromState,
			@JsonProperty("fromZip") String fromZip, @JsonProperty("fromCountry") String fromCountry, @JsonProperty("toCity") String toCity,
			@JsonProperty("toState") String toState, @JsonProperty("toZip") String toZip, @JsonProperty("toCountry") String toCountry) {
		super();
		this.messageSid = messageSid;
		this.accountSid = accountSid;
		this.messagingServiceSid = messagingServiceSid;
		this.from = from;
		this.to = to;
		this.body = body;
		this.numMedia = numMedia;
		this.media = media;
		this.fromCity = fromCity;
		this.fromState = fromState;
		this.fromZip = fromZip;
		this.fromCountry = fromCountry;
		this.toCity = toCity;
		this.toState = toState;
		this.toZip = toZip;
		this.toCountry = toCountry;
		this.username = "twilio";
	}

	/**
	 * @return the messageSid
	 */
	public String getMessageSid() {
		return messageSid;
	}

	/**
	 * @param messageSid the messageSid to set
	 */
	public void setMessageSid(String messageSid) {
		this.messageSid = messageSid;
	}

	/**
	 * @return the accountSid
	 */
	public String getAccountSid() {
		return accountSid;
	}

	/**
	 * @param accountSid the accountSid to set
	 */
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	/**
	 * @return the messagingServiceSid
	 */
	public String getMessagingServiceSid() {
		return messagingServiceSid;
	}

	/**
	 * @param messagingServiceSid the messagingServiceSid to set
	 */
	public void setMessagingServiceSid(String messagingServiceSid) {
		this.messagingServiceSid = messagingServiceSid;
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
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the numMedia
	 */
	public String getNumMedia() {
		return numMedia;
	}

	/**
	 * @param numMedia the numMedia to set
	 */
	public void setNumMedia(String numMedia) {
		this.numMedia = numMedia;
	}

	/**
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}

	/**
	 * @return the fromCity
	 */
	public String getFromCity() {
		return fromCity;
	}

	/**
	 * @param fromCity the fromCity to set
	 */
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	/**
	 * @return the fromState
	 */
	public String getFromState() {
		return fromState;
	}

	/**
	 * @param fromState the fromState to set
	 */
	public void setFromState(String fromState) {
		this.fromState = fromState;
	}

	/**
	 * @return the fromZip
	 */
	public String getFromZip() {
		return fromZip;
	}

	/**
	 * @param fromZip the fromZip to set
	 */
	public void setFromZip(String fromZip) {
		this.fromZip = fromZip;
	}

	/**
	 * @return the fromCountry
	 */
	public String getFromCountry() {
		return fromCountry;
	}

	/**
	 * @param fromCountry the fromCountry to set
	 */
	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}

	/**
	 * @return the toCity
	 */
	public String getToCity() {
		return toCity;
	}

	/**
	 * @param toCity the toCity to set
	 */
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	/**
	 * @return the toState
	 */
	public String getToState() {
		return toState;
	}

	/**
	 * @param toState the toState to set
	 */
	public void setToState(String toState) {
		this.toState = toState;
	}

	/**
	 * @return the toZip
	 */
	public String getToZip() {
		return toZip;
	}

	/**
	 * @param toZip the toZip to set
	 */
	public void setToZip(String toZip) {
		this.toZip = toZip;
	}

	/**
	 * @return the toCountry
	 */
	public String getToCountry() {
		return toCountry;
	}

	/**
	 * @param toCountry the toCountry to set
	 */
	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SMSReplyDTO [messageSid=").append(messageSid).append(", accountSid=").append(accountSid)
				.append(", messagingServiceSid=").append(messagingServiceSid).append(", from=").append(from)
				.append(", to=").append(to).append(", body=").append(body).append(", numMedia=").append(numMedia)
				.append(", media=").append(media).append(", fromCity=").append(fromCity).append(", fromState=")
				.append(fromState).append(", fromZip=").append(fromZip).append(", fromCountry=").append(fromCountry)
				.append(", toCity=").append(toCity).append(", toState=").append(toState).append(", toZip=")
				.append(toZip).append(", toCountry=").append(toCountry).append(", username=").append(username)
				.append("]");
		return builder.toString();
	}
	
}