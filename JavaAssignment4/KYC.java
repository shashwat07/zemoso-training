import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class KYC {
	
	static void getDateRange(String signup, String current) throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date signupDate = format.parse(signup);
		Date currentDate = format.parse(current);
		
		if(signupDate.after(currentDate)){
			System.out.println("No range");
		}
		else{
			
			Calendar calSignup = GregorianCalendar.getInstance();
			calSignup.setTime(signupDate);
			
			Calendar calCurrent = GregorianCalendar.getInstance();
			calCurrent.setTime(currentDate);
			
			int years = calCurrent.get(Calendar.YEAR) - calSignup.get(Calendar.YEAR);
			calSignup.add(GregorianCalendar.YEAR, years);
			
			calSignup.add(GregorianCalendar.DAY_OF_MONTH, -30);
			
			System.out.print(format.format(calSignup.getTime()) + " ");

			calSignup.add(GregorianCalendar.DAY_OF_MONTH, 60);
			
			
			
			if(calSignup.before(calCurrent)){
				System.out.println(format.format(calSignup.getTime()));
			}
			else{
				System.out.println(format.format(calCurrent.getTime()));
			}
			
		}
		
	}

	
	public static void main(String[] args)  {
	
		Scanner scan = new Scanner(System.in);
		int noOfInputs = scan.nextInt();
		String data[][] = new String[noOfInputs][2];
		
		String signupDate = null;
		String currentDate = null;
		
		for(int i=0;i<noOfInputs;i++){
			signupDate = scan.next();
			currentDate = scan.next();
			data[i][0] = signupDate;
			data[i][1] = currentDate;
		}
		
		
		for(int i=0;i<noOfInputs;i++){
			try {
				getDateRange(data[i][0], data[i][1]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		scan.close();
		
	}

}
