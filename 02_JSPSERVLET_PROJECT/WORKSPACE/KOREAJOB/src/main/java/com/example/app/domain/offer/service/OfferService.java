package com.example.app.domain.offer.service;

import com.example.app.domain.offer.dto.OfferDto;

public interface OfferService {

	OfferDto getUser(String offername) throws Exception;
	
}
