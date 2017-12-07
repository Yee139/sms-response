package com.royall.sms;

import java.util.Map;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.royall.sms.model.SMSReplyModel;
import com.royall.sms.model.SMSStatusModel;

@Component
public class SMSMessageProducer {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue replyQueue;

	@Autowired
	private Queue statusQueue;

	public void sendReply(SMSReplyModel msg) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = 
			    mapper.convertValue(msg, new TypeReference<Map<String, String>>() {});
		
		this.jmsMessagingTemplate.convertAndSend(this.replyQueue, map);
	}
	
	public void sendStatus(SMSStatusModel msg) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = 
			    mapper.convertValue(msg, new TypeReference<Map<String, String>>() {});
		
		this.jmsMessagingTemplate.convertAndSend(this.statusQueue, map);
	}

}
