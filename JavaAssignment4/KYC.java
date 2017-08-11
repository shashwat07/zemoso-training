import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class KYC {
	
	private static boolean checkValidity(String date){
		boolean isValid=false;
		if(date.length()==10){
			isValid=true;
		}
		return isValid;
	}
	static int getDateRange(String signup, String current) throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		format.setLenient(false);
		Date signupDate=null, currentDate=null;
		try{
			signupDate = format.parse(signup);
			currentDate = format.parse(current);
		}
		catch(Exception e){
			System.out.println("Invalid Date!");
			return 0;	// will stop the function from performing further operation on invalid date
		}
		
		
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
		return 0;
		
	}

	
	public static void main(String[] args)  {
	
		System.out.println("Enter number of inputs : ");
		Scanner scan = new Scanner(System.in);
		int noOfInputs = scan.nextInt();
		System.out.println("Enter the " + noOfInputs + " set of dates to check for :" );
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
				if(checkValidity(data[i][0]) && checkValidity(data[i][1])){
					getDateRange(data[i][0], data[i][1]);
				}
			} catch (Exception e) {
				System.out.println("Invalid Date!");
			}
		}
		
		scan.close();
		
	}

}
