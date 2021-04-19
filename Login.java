package com.santhoshkumar;

public class Login extends firstpage {
		public long getMobileNo()
		{
			System.out.println("Enter your mobile number");
			long mobileNo=sc.nextLong();
			isvalidateMobileNo(mobileNo);
			return mobileNo;
		}
		
		public boolean isvalidateMobileNo(long  mobileNo)
		{
			String MobileNO=String.valueOf(mobileNo);
			if(MobileNO.length()!=10)
			{
				System.out.println("Enter a valid mobile number");
				getMobileNo();
				return false;
			}
			return true;
		}
			
		
		public String getpassword()
		{
			System.out.println("Enter your password");
			String password=sc.next();
			isvalidatepassword(password);
			
			return password;
		}
		public boolean isvalidatepassword(String password)
		{
			if(password.length()<8) {
				System.out.println("Enter password with Atleast 8 character");
				getpassword();
				return false;
			}
			return true;
		
		}
		
		
		
		
	}


