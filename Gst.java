package com.santhoshkumar;

public class Gst {
	public double calculateGst(double micro_priceWithoutGst)
	{
		double gst=(micro_priceWithoutGst*firstpage.gst_cabs)/100.0;
		return gst;
	}

}
