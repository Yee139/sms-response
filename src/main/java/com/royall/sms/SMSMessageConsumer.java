package com.royall.sms;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.royall.sms.model.SMSReplyModel;
import com.royall.sms.model.SMSStatusModel;
import com.royall.sms.repository.SMSReplyRepository;
import com.royall.sms.repository.SMSStatusRepository;

@Component
public class SMSMessageConsumer {
	
	@Autowired
	private SMSStatusRepository smsStatusRepository;
	
	@Autowired
	private SMSReplyRepository smsReplyRepository;
	
	/**
	 * 
	 * @param message
	 * @return
	 * @throws JMSException
	 * @throws InterruptedException 
	 */
	@JmsListener(destination = "sms.reply")
	@SendTo("outbound.queue")
	public String receiveReply(final ActiveMQMapMessage message) throws JMSException, InterruptedException {
		System.out.println("Received SMS Response " + message);
		ObjectMapper mapper = new ObjectMapper();
        String response = "";
        
        Map<String, Object> map = message.getContentMap();
        
        SMSReplyModel dto = mapper.convertValue(convertAttributes(map), SMSReplyModel.class);
        
        response = dto.toString();

        // Call the datagateway and pause for 1 sec
        Thread.sleep(5000L);
        
        smsReplyRepository.save(dto);
        
        return response;
	}

	/**
	 * 
	 * @param message
	 * @return
	 * @throws JMSException
	 * @throws InterruptedException 
	 */
    @JmsListener(destination = "sms.status")
    @SendTo("outbound.queue")
    public String receiveStatus(final ActiveMQMapMessage message) throws JMSException, InterruptedException {
        System.out.println("Received SMS Status " + message);
		ObjectMapper mapper = new ObjectMapper();
        String response = "";
        
        Map<String, Object> map = message.getContentMap();
        
        SMSStatusModel dto = mapper.convertValue(convertAttributes(map), SMSStatusModel.class);
        
        response = dto.toString();

        // Call the datagateway and pause for 1 sec
        Thread.sleep(5000L);
        
        smsStatusRepository.save(dto);
        
        return response;
    }
    
    /**
     * 
     * @param attributes
     * @return
     */
    private Map<String, String> convertAttributes(Map<String, Object> attributes) {
        Map<String, String> result = new HashMap<String, String>();
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            result.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return result;
    }

}
