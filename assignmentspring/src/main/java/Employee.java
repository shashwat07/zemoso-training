public class Employee{
    private Person manager;
    private Person assistant;

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public Person getAssistant() {
        return assistant;
    }

    public void setAssistant(Person assistant) {
        this.assistant = assistant;
    }

    public void details(){
        System.out.println("Manager : " + getManager().name + " " + getManager().age + " " + getManager().gender);
        System.out.println("Assistant : " + getAssistant().name + " " + getAssistant().age + " " + getAssistant().gender);

    }
}
