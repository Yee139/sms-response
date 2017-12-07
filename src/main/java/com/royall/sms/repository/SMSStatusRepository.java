package com.royall.sms.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.royall.sms.model.SMSStatusModel;

@Transactional
public interface SMSStatusRepository extends CrudRepository<SMSStatusModel, Long> {
	
}