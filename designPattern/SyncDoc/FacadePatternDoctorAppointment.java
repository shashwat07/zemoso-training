import java.util.Scanner;


public class FacadePatternDoctorAppointment {

	
	public static void main(String[] args) {
		BookAppointment bookAppointment = new BookAppointment();
		
		boolean bookStatus[] = new boolean[10];
		
		Scanner scan = new Scanner(System.in);
		String doc = null;
		
		while(true){
			System.out.println("Choose the specialist to book appointment with , -1 to exit :");
			System.out.println("Cardiologist, Dentist, Dermatologist, Epidemiologist, Gynecologist, Immunologist, Microbiologist, Neurologist, Psychiatrist, Psychologist");
			doc = scan.nextLine();
			if(doc.equals("-1")){
				System.out.println("Thank you for using our service!");
				break;
			}
			doc.toLowerCase();
			switch(doc){
				case "cardiologist" :
					if(bookStatus[0]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[0] = true;
						bookAppointment.bookCardiologist();
					}
					break;
				case "dentist" :
					if(bookStatus[1]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[1] = true;
						bookAppointment.bookDentist();
					}
					break;
				case "dermatologist" :
					if(bookStatus[2]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[2] = true;
						bookAppointment.bookDermatologist();
					}
					break;
				case "epidemiologist" :
					if(bookStatus[3]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[3] = true;
						bookAppointment.bookEpidemiologist();
					}
					break;
				case "gynecologist" :
					if(bookStatus[4]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[4] = true;
						bookAppointment.bookGynecologist();
					}
					break;
				case "immunologist" :
					if(bookStatus[5]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[5] = true;
						bookAppointment.bookImmunologist();
					}
					break;
				case "microbiologist" :
					if(bookStatus[6]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[6] = true;
						bookAppointment.bookMicrobiologist();
					}
					break;
				case "neurologist" :
					if(bookStatus[7]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[7] = true;
						bookAppointment.bookNeurologist();
					}
					break;
				case "psychiatrist" :
					if(bookStatus[8]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[8] = true;
						bookAppointment.bookPsychiatrist();
					}
					break;
				case "psychologist" :
					if(bookStatus[9]){
						System.out.println("Appointment already booked!");
					}
					else{
						bookStatus[9] = true;
						bookAppointment.bookPsychologist();
					}
					break;
				default : 
					System.out.println("Invalid response! Try again!");
			}
		}
		scan.close();
	}

}
