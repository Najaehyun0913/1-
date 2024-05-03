package com.example.app.domain.offer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.app.domain.common.dao.UserDaoImpl;
import com.example.app.domain.common.dao.connectionPool.ConnectionPool;
import com.example.app.domain.common.dto.UserDto;
import com.example.app.domain.offer.dao.OfferDaoImpl;
import com.example.app.domain.offer.dto.OfferDto;

public class OfferServiceImpl implements OfferService {

	private OfferDaoImpl offerDaoImpl;
	private UserDaoImpl userDaoImpl;
	private ConnectionPool connectionPool;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	//싱글톤
	private static OfferServiceImpl instance ;
	public static OfferServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance=new OfferServiceImpl();
		return instance;
	}
	
	private OfferServiceImpl() throws Exception{
		System.out.println("OfferServiceImpl's constructor invoke ..");
		offerDaoImpl = OfferDaoImpl.getInstance();
		userDaoImpl = UserDaoImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}
	
	
	//회원가입
	public Map<String,Object> join(OfferDto newUser) throws Exception{
		Map<String,Object> returnValue =new HashMap();
		connectionPool.txStart();
		//작업위치

		UserDto existingUser = getUser(newUser.getId());
		if(existingUser != null) {
	        returnValue.put("response", false);
	        return returnValue;
	  	}
		
		newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
		boolean isRegistered = userDaoImpl.Insert(newUser); 
		isRegistered = offerDaoImpl.Insert(newUser);
		if (!isRegistered) {
		        returnValue.put("response", false);
		        returnValue.put("msg", "회원가입 실패.");
		        return returnValue;
		}
		    
		returnValue.put("response", true);
		returnValue.put("msg", "회원가입이 성공.");
				
		connectionPool.txCommit();
			
		return returnValue;
	}



	//회원탈퇴
	public boolean remove(String offername) throws Exception {
	    boolean success = false;
	    connectionPool.txStart();    

	    OfferDto offerToRemove = getUser(offername);
	    if(offerToRemove == null) {
	        connectionPool.txRollBack();
	        return false; 
	    }

	    success = offerDaoImpl.Remove(offerToRemove.getId());
	    if (success) {
	        connectionPool.txCommit();
	    } else {
	        connectionPool.txRollBack();
	    } 

	    return success;
	}
	
	@Override
	public OfferDto getUser(String offername) throws Exception {
		connectionPool.txStart();
		OfferDto offerDto =  offerDaoImpl.Select(offername);
		connectionPool.txCommit();
		return offerDto;
	}

	public OfferDto getCompanyInfo() {
		return null;
	}


	
//	private UserDto getUser(String id) throws Exception{
//		connectionPool.txStart();
//		UserDto userDto =  userDaoImpl.Select(id);
//		connectionPool.txCommit();
//		return userDto;
//	}
//	
}
	

