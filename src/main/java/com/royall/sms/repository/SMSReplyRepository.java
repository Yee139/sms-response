package com.royall.sms.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.royall.sms.model.SMSReplyModel;

@Transactional
public interface SMSReplyRepository extends CrudRepository<SMSReplyModel, Long> {
	
}