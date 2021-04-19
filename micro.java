package com.santhoshkumar;

public class micro {
public double fareprices_micro(int kilometer)
{
	int price=kilometer*firstpage.micro_price;
	System.out.println("Your fare price with out Gst: "+(price));
	return(price);
}


public double fareprices_microPeakHour(int kilometer)
{
	
	double peak_prices=(firstpage.micro_price*firstpage.peak_price)/100.0;
	double price=(kilometer*firstpage.micro_price)+peak_prices;
	System.out.println("Your fare price with out Gst: "+(price));
	return (price);
	
	
	
}
		
//		

}


