package Logic;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class driver {
	

	public static void main(String[] args) {
		Logic logic= new Logic();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your length of Stream you want to generate: ");
		long length=sc.nextLong();
		String text=generateString(length);
		System.out.println();
		System.out.println("String is: "+ text);
		System.out.print("Enter the sub-string you want to search: ");
		Scanner sc1= new Scanner(System.in);
		String pattern=sc1.nextLine();
		System.out.println();
		long t1=getTime();
		System.out.println("Pattern matched at: " +logic.findSubString(text, pattern).toString());
		long t2= getTime();
		//SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss");
		System.out.println("Time Taken for search is: " + (t2-t1) + " msec");
		sc.close();
		sc1.close();
	}
	
	public static long getTime(){
		
		Calendar cal = Calendar.getInstance();
		return cal.getTimeInMillis();
		
		
	}
	
	public static String generateString(long i){
		
		Random random= new Random();
		StringBuffer sb= new StringBuffer();
		for(long j=0;j<i;j++){
			int x=random.nextInt(125);
		if(x>44){	
		sb.append((char)x);}
		else
			--j;
		}
		return sb.toString();
		
	}

}
