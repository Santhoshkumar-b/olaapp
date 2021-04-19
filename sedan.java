package com.santhoshkumar;

public class sedan {
	public double fareprices_sedan(int kilometer)
	{
		int price=kilometer*firstpage.sedan_price;
		System.out.println("Your fare price with out Gst: "+(price));
		return(price);
	}


	public double fareprices_sedanPeakHour(int kilometer)
	{
		
		double peak_prices=(firstpage.sedan_price*firstpage.peak_price)/100.0;
		double price=(kilometer*firstpage.sedan_price)+peak_prices;
		System.out.println("Your fare price with out Gst: "+(price));
		return (price);
	}
		
	

}
