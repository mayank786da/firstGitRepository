package com.mayank786da.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayank786da.microservice.entities.Address;
import com.mayank786da.microservice.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressSrv;
	
	@RequestMapping("/address")
	public List<Address> getAddress() {
		return addressSrv.getAddress();
	}
	
	@PostMapping("/address")
	public Address createNewAddress(@RequestBody Address payload) {
		return addressSrv.createAddress(payload);
	}
}
