package org.tekSystems.automation.SeleniumAutomation;

import org.testng.annotations.Test;

import pageClasses.CleartripHomePage;
import pageClasses.HotelBookingPage;
import pageClasses.HotelDetailsPage;
import pageClasses.HotelsSearchPage;
import pageClasses.HotelsSearchPage2;
import pageClasses.ResultsPage;

public class ClearTrip extends TekBase{
	
	@Test
	public void hotelReservation() throws Exception {

		HotelsSearchPage2 hotelSearch = new HotelsSearchPage2(driver);
		CleartripHomePage homePage = new CleartripHomePage(driver);
		ResultsPage resultspage = new ResultsPage(driver);
		HotelDetailsPage hotelDetailsPage = new HotelDetailsPage(driver);
		HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
		
		
		homePage.naviagtetoHotels();
		hotelSearch.searchForHotels();
		resultspage.hotelNames();
		resultspage.sortbyPrice();		
		hotelDetailsPage.switchtoHotelPage();
		hotelBookingPage.bookingHotel();
		hotelBookingPage.emailAddress();
		hotelBookingPage.guestDetails();
		hotelBookingPage.paymentverification();
		

	}

}
