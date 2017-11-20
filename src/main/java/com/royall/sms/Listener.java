package com.royall.sms;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.royall.sms.dto.SMSReplyDTO;
import com.royall.sms.dto.SMSStatusDTO;

@Component
public class Listener {
	
	/**
	 * 
	 * @param message
	 * @return
	 * @throws JMSException
	 */
	@JmsListener(destination = "sms.reply")
	@SendTo("outbound.queue")
	public String receiveReply(final ActiveMQMapMessage message) throws JMSException {
		System.out.println("Received SMS Response " + message);
		ObjectMapper mapper = new ObjectMapper();
        String response = "";
        
        Map<String, Object> map = message.getContentMap();
        
        SMSReplyDTO dto = mapper.convertValue(convertAttributes(map), SMSReplyDTO.class);
        
        response = dto.toString();
        	
        return response;
	}

	/**
	 * 
	 * @param message
	 * @return
	 * @throws JMSException
	 */
    @JmsListener(destination = "sms.status")
    @SendTo("outbound.queue")
    public String receiveStatus(final ActiveMQMapMessage message) throws JMSException {
        System.out.println("Received SMS Status " + message);
		ObjectMapper mapper = new ObjectMapper();
        String response = "";
        
        Map<String, Object> map = message.getContentMap();
        
        SMSStatusDTO dto = mapper.convertValue(convertAttributes(map), SMSStatusDTO.class);
        
        response = dto.toString();
        	
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
