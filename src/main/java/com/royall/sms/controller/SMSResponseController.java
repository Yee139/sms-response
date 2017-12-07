package com.royall.sms.controller;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.validation.Valid;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.royall.sms.SMSMessageProducer;
import com.royall.sms.model.SMSReplyModel;
import com.royall.sms.model.SMSStatusModel;

@EnableJms
@RequestMapping(path="/sms-response")
@RestController
public class SMSResponseController {
	 
	@Autowired
	private SMSMessageProducer producer;

	@Bean
	public Queue replyQueue() {
		return new ActiveMQQueue("sms.reply");
	}

	@Bean
    public Queue statusQueue() {
            return new ActiveMQQueue("sms.status");
    }
	
	@RequestMapping(value="/reply", method = RequestMethod.POST)
	ResponseEntity<String> reply(@Valid SMSReplyModel replyDTO) throws InterruptedException, JMSException {
		this.producer.sendReply(replyDTO);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
 
    @RequestMapping(value="/status", method = RequestMethod.POST)
    ResponseEntity<String> status(@Valid SMSStatusModel statusDTO) throws InterruptedException, JMSException {
        this.producer.sendStatus(statusDTO);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

}
