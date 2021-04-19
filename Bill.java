package com.santhoshkumar;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bill {
	public void billingDetails(String cabname,double fprices,LocalDate jdate,LocalTime jtime)
	{
		System.out.println(" ");
		System.out.println("           ----------------------------------------");
		System.out.println("                      Your Booking Details");
		System.out.println("           -----------------------------------------");
		System.out.println("           |                                        ");
		System.out.println("           | Your cab model :"+cabname +"                 ");
		System.out.println("           |                                        ");
		System.out.println("           | Your Booking Date: "+jdate+"          ");
		System.out.println("           |                                        ");
		System.out.println("           | Your Pickup Time: "+jtime+"             ");
		System.out.println("           |                                        ");
		System.out.println("           | Your fare price:  "+fprices+"               ");
		System.out.println("           |                                        ");
		System.out.println("           | Thank You, Have a nice day!            ");
		System.out.println("           ------------------------------------------");
		
		
	}

}
