package com.example.demo.controller;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.HotelDetails;
import com.example.demo.entities.ReservationDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



@RestController
public class HotelController {

	@RequestMapping("/hotelsList")
	public List<HotelDetails> getHotelsList() {
		return getListOfHotels();
	}
	
	
	@RequestMapping(value="/reservation",method=RequestMethod.POST, consumes="application/json")
	public String reserveHotel(@RequestBody ReservationDetails reservationdetails) {
		return reservationdetails.getHotel_name();
	}
	
	public List<HotelDetails> getListOfHotels(){
		List<HotelDetails> hotelsList = new ArrayList<HotelDetails>();
		List<String> hotelNames = Arrays.asList("Seasons Inn", "Wedgewood Hotel", "Holiday Inn", "Comfort Inn","The Hollis");
		Random random = new Random();
		for(int i=0; i<hotelNames.size();i++) {
			HotelDetails hoteldetails = new HotelDetails();
			hoteldetails.setHotelName(hotelNames.get(i));
			hoteldetails.setAvailability(true);
	
			int randomPrice = random.nextInt(300 - 50 + 1) + 50;
			hoteldetails.setPrice(randomPrice);
			hotelsList.add(hoteldetails);
			hoteldetails = null;
		}
		
		return hotelsList;
		
		
	}
}