package com.mayank786da.microservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mayank786da.microservice.entities.Vendor;

@Component
public class VendorService {

  //this is like an internal table which contains multiple records	
  HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();	
  
  @Autowired
  IVendorPersistence vendor;
//  @Autowired
//  Vendor ven1;
//  
//  @Autowired
//  Vendor ven2;
//  
//  @Autowired
//  Vendor ven3;  
	  
//  private void fillVendors() {
////	  vendors.put("1", ven1);
////	  vendors.put("2", ven2);
////	  vendors.put("3", ven3);	  
//  }
//  
//  public void VendorService() {
//	  fillVendors();
//  }
  
  public List<Vendor> getAllVendors(){
	  //fillVendors();
	  
	  // Spring JPA will fire a select query behind the scene
	  return vendor.findAll();
	  //return vendors;
  }
  
  public Optional<Vendor> getVendorByKey(String vendorId) {
	  //fillVendors();
	  // Read table itab into wa with key vendor id
	  //return (Vendor)vendors.get(vendorId);
	  
	  // Send SELECT SINGLE * to database
	  return vendor.findById(vendorId);
  }
  
  public Vendor createVendor(Vendor vendorObject) {
//	  fillVendors();
//	  vendors.put("4", vendor);;
//	  return vendor;
	  
	  // Spring JPA will fire INSERT command to the database 
	  return vendor.save(vendorObject);
  }
  
  public Vendor updateVendor(Vendor vendorObject) {
//	  fillVendors(); 
//	 return vendor;
	  
	  // Handle the update call
	  Optional<Vendor> searchedRecord = vendor.findById(vendorObject.getCode());
	  if(!searchedRecord.isPresent()) {
		  return new Vendor();
	  }
	  return vendor.save(vendorObject);
  }
  
  public List <Vendor> searchByCompanyName(String company){
	  return vendor.findBycompanyName(company);
  }
  
  public List <Vendor> lookupByFirstName(String firstname){
	  return vendor.lookupByFirstName(firstname);
  }
  
  public String deleteVendor(String vendorId) {
//	  fillVendors();
//	  vendors.remove(vendorId);
	  
	  vendor.deleteById(vendorId);
	  return "Deleted Succefully";
  }
}
