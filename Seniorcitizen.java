package com.santhoshkumar;

public class Seniorcitizen {
	
	public double seniorcitizenDeductionPrice(double finalfareprice)
	{
			double senior_citizen=(finalfareprice*50)/100.0;
			return(finalfareprice-senior_citizen);

			
	}

}
