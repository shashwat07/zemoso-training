
public class BookAppointment {
	private Doctor cardiologist;
	private Doctor dentist;
	private Doctor dermatologist;
	private Doctor epidemiologist;
	private Doctor gynecologist;
	private Doctor immunologist;
	private Doctor microbiologist;
	private Doctor neurologist;
	private Doctor psychiatrist;
	private Doctor psychologist;
	
	public BookAppointment(){
		cardiologist = new Cardiologist();
		dentist = new Dentist();
		dermatologist = new Dermatologist();
		epidemiologist = new Epidemiologist();
		gynecologist = new Gynecologist();
		immunologist = new Immunologist();
		microbiologist = new Microbiologist();
		neurologist = new Neurologist();
		psychiatrist = new Psychiatrist();
		psychologist = new Psychologist();
	}
	
	public void bookCardiologist(){
		cardiologist.book();
	}
	
	public void bookDentist(){
		dentist.book();
	}
	
	public void bookDermatologist(){
		dermatologist.book();
	}
	
	public void bookEpidemiologist(){
		epidemiologist.book();
	}
	
	public void bookGynecologist(){
		gynecologist.book();
	}
	
	public void bookImmunologist(){
		immunologist.book();
	}
	
	public void bookMicrobiologist(){
		microbiologist.book();
	}
	
	public void bookNeurologist(){
		neurologist.book();
	}
	
	public void bookPsychiatrist(){
		psychiatrist.book();
	}
	
	public void bookPsychologist(){
		psychologist.book();
	}
	
}
