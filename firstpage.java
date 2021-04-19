package com.santhoshkumar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class firstpage {
	static Scanner sc = new Scanner(System.in);
	final static int gst_cabs = 7;
	final static double peak_price = 5;
	final static double total_tariff = 0.0;
	final static int micro_price=10;
	final static int sedan_price=15;
	final static int innova_price=20;
	static double finalBillPrice=0.0;
	static String booking_choice = "";
	static Bill bill = new Bill();

	static Map<Long,userdetails> map=new HashMap<>();
	static String cab_name = " ";
	static double final_prices = 0.0;
	static int kiloMeter=0,hour=0,age=0;
	static LocalDate date=null;
	static LocalTime time = null;
	public static void main(String []args) {

		System.out.println("       -------------------------------------------------------");
		System.out.println("                            Welcome to uber             ");
		System.out.println("       ------------------------------------------------------");
		System.out.println(" ");
		System.out.println("    1.Login");
		System.out.println("    2.New User");
		System.out.println("    3.Exit");
		
		int Login_start = sc.nextInt();
		if (Login_start == 1) {
			Login login = new Login();
			long userMobileNumber=login.getMobileNo();
			if(map.containsKey(userMobileNumber))
			{
				userdetails userDetails=map.get(userMobileNumber);
				String userPassword=login.getpassword();
				if(userDetails.getPassword().equals(userPassword))
				{
					System.out.println("Login Successfull");
				}
				else {
					System.out.println("Password wrong");
					main(args);
				}
			}
			else {
				System.out.println("Your mobile is not registered");
				main(args);
			}
			
			

		} else if (Login_start == 2) {
			
			useraccount userAccount=new useraccount();
			long newuserMobileNo=userAccount.getUserMobileNo();
			String newuserPassword=userAccount.getUserPassword();
			userdetails user=new userdetails(newuserMobileNo,newuserPassword);
			map.put(newuserMobileNo,user);
			System.out.println("Registeration Successfull");
			main(args);
			

		} else if (Login_start == 3) {
			System.out.println("Thank You for using uber");
			System.exit(0);
		} else {
			System.out.println("Please Enter a valid Number");
		}
		
		
		
		
		Gst gst=new Gst();
		Seniorcitizen seniorcitizen=new Seniorcitizen();
		System.out.println("-----------------------LOGIN SUCCESSFULL---------------------------");	
		System.out.println("Enter the your destination kilometer: ");
		Scanner sc=new Scanner(System.in);
		int kiloMeter = sc.nextInt();
		
		LocalDate date ;
		LocalDate current_date = LocalDate.now();
			do {
				
				System.out.println("Please Enter your journey data :");
				String Booking_date = sc.next();
				date = LocalDate.parse(Booking_date);
			} while (date.isBefore(current_date));
		
		System.out.println("Please Enter your Pick up time: ");
		String PickupTime = sc.next();
		
		LocalTime time = LocalTime.parse(PickupTime);
		int hour = time.getHour();
		
		System.out.println("Enter your date of birth: ");
		String datebirth = sc.next();
		LocalDate dateofBirth = LocalDate.parse(datebirth);
		
		int age = Period.between(dateofBirth, current_date).getYears();
		
		System.out.println("Select your cab choice");
		System.out.println("1.Micro");
		System.out.println("2.Sedan");
		System.out.println("3.Innova");
		int choice;
		do {
			choice = sc.nextInt();
			switch (choice) {
				case 1:
				micro m = new micro();
				cab_name = "Micro";
				farecalculateMicro calculatemicro=new farecalculateMicro(); 
				if(hour<17 || hour<19)
				{
					 double micro_priceNOGst = m.fareprices_micro(kiloMeter);
					 double micro_priceWithGst=gst.calculateGst(micro_priceNOGst);
					 double finalpriceWithGst=micro_priceNOGst+micro_priceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalpriceWithGst);
						 calculatemicro.finalfareCalculateMicro(cab_name,finalBillPrice,date,time);
						 
					 }else {
						 calculatemicro.finalfareCalculateMicro(cab_name,finalpriceWithGst,date,time);
						 
					 }
					 
				}
				else {
					double micro_priceNOGst=m.fareprices_microPeakHour(kiloMeter);
					double micro_priceWithGst=gst.calculateGst(micro_priceNOGst);
					double finalpriceWithGst=micro_priceNOGst+micro_priceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalpriceWithGst);
						 calculatemicro.finalfareCalculateMicro(cab_name,finalBillPrice,date,time);
						 
						 
					 }else {
						 calculatemicro.finalfareCalculateMicro(cab_name,finalpriceWithGst,date,time);
					 }
				}
				break;
				
				
			case 2:
				sedan s = new sedan();
				cab_name="Sedan";
				farecalculateSedan calculatesedan=new farecalculateSedan(); 
				if(hour<17 || hour<19)
				{
					 double sedan_priceNOGst = s.fareprices_sedan(kiloMeter);
					 double sedan_priceWithGst=gst.calculateGst(sedan_priceNOGst);
					 double finalpriceWithGst=sedan_priceNOGst+sedan_priceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalpriceWithGst);
						 calculatesedan.finalfareCalculateSedan(cab_name,finalBillPrice,date,time);
						 
					 }else {
						 calculatesedan.finalfareCalculateSedan(cab_name,finalpriceWithGst,date,time);	 
					 }
					 
					 
					 
				}
				else {
					double sedan_priceNOGst=s.fareprices_sedanPeakHour(kiloMeter);
					double sedan_priceWithGst=gst.calculateGst(sedan_priceNOGst);
					double finalpriceWithGst=sedan_priceNOGst+sedan_priceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalpriceWithGst);
						 calculatesedan.finalfareCalculateSedan(cab_name,finalBillPrice,date,time);
						 
						 
					 }else {
						 calculatesedan.finalfareCalculateSedan(cab_name,finalpriceWithGst,date,time);	
						 
					 }
				}
				
	
				break;
				
			case 3:
				Innova innova = new Innova();
				farecalculateInnova calculateinnova=new farecalculateInnova(); 
				cab_name = "Innova";
				if(hour<17 || hour<19)
				{
					 double innova_priceNOGst = innova.fareprices_innova(kiloMeter);
					 double innova_priceWithGst=gst.calculateGst(innova_priceNOGst);
					 double finalpriceWithGst=innova_priceNOGst+innova_priceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalpriceWithGst);
						 calculateinnova.finalfareCalculateInnova(cab_name,finalBillPrice,date,time);
						 
					 }else {
						 calculateinnova.finalfareCalculateInnova(cab_name,finalpriceWithGst,date,time);
						 
					 }
					 
					 
					 
				}
				else {
					double innova_priceNOGst=innova.fareprices_innovaPeakHour(kiloMeter);
					double innova_priceWithGst=gst.calculateGst(innova_priceNOGst);
					double finalpriceWithGst=innova_priceNOGst+innova_priceWithGst;
					 if(age>=60)
					 {
						 finalBillPrice=seniorcitizen.seniorcitizenDeductionPrice(finalpriceWithGst);
						 calculateinnova.finalfareCalculateInnova(cab_name,finalBillPrice,date,time);
						
						 
					 }else {
						 calculateinnova.finalfareCalculateInnova(cab_name,finalpriceWithGst,date,time);
					 }
				}
				
				break;
	
			default:
				System.out.println("Please select a valid cab name");
			}
		}while(choice!=1 || choice!=2 || choice!=3);
			//sc.close();

	}
	// TODO Auto-generated method stub
	

}
