package com.santhoshkumar;

import java.time.LocalDate;
import java.time.LocalTime;

public class farecalculateSedan extends firstpage {
	public void finalfareCalculateSedan(String cab_name,double finalBillPrice,LocalDate date,LocalTime time) {
		System.out.println("Do you want to conform your booking type yes/no:");
		firstpage.booking_choice = sc.next();
		if (firstpage.booking_choice.equals("yes") || firstpage.booking_choice.equals("YES")) {

			bill.billingDetails(cab_name, finalBillPrice, date, time);
		} else {
			System.exit(0);
		}
		
	}

}
