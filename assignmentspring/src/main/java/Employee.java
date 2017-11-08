public class Employee{
    private Person shyam;
    private Person geeta;

    public Person getShyam() {
        return shyam;
    }

    public void setShyam(Person shyam) {
        this.shyam = shyam;
    }

    public Person getGeeta() {
        return geeta;
    }

    public void setGeeta(Person geeta) {
        this.geeta = geeta;
    }

    public void details(){
        System.out.println(getGeeta().name + " " + getGeeta().age + " " + getGeeta().gender);
        System.out.println(getShyam().name + " " + getShyam().age + " " + getShyam().gender);
    }
}
