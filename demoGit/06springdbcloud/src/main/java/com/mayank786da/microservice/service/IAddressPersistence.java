package com.mayank786da.microservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayank786da.microservice.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, String> {

	
}
