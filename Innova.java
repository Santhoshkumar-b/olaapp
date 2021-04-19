package com.santhoshkumar;

public class Innova {
	public double fareprices_innova(int kilometer)
	{
		int price=kilometer*firstpage.innova_price;
		System.out.println("Your fare price with out Gst: "+(price));
		return(price);
	}


	public double fareprices_innovaPeakHour(int kilometer)
	{
		
		double peak_prices=(firstpage.innova_price*firstpage.peak_price)/100.0;
		double price=(kilometer*firstpage.innova_price)+peak_prices;
		System.out.println("Your fare price with out Gst: "+(price));
		return (price);
	}

}
