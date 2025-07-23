class Participant{
    private int participantId;
    private String name;
    private double baseRegistrationFee;
    private int numberOfEvents;
    private double eventChargePerEvent;
    public void setParticipantId(int p){
        participantId=p;
    }
    public void setName(String n){
        name=n;
    }
    public void setBaseRegistrationFee(double b){
        baseRegistrationFee=b;
    }
    public void setNumberOfEvents(int e){
        numberOfEvents=e;
    }
    public void setEventChargePerEvent(double c){
        eventChargePerEvent=c;
    }
    public int getParticipantId(){
        return participantId;
    }
    public String getName(){
        return name;
    }
    public double getBaseRegistrationFee(){
        return baseRegistrationFee;
    }
    public int getNumberOfEvents(){
        return numberOfEvents;
    }
    public double getEventChargePerEvent(){
        return eventChargePerEvent;
    }
    public double calculateTotalFee(){
        return baseRegistrationFee + (numberOfEvents * eventChargePerEvent);
    }
    public void displayDetails(){
        System.out.println("Participant Record");
        System.out.println("ID: "+getParticipantId());
        System.out.println("Name: "+getName());
        System.out.println("Base Registration Fee: "+getBaseRegistrationFee());
        System.out.println("Event Charges: "+getNumberOfEvents()+" events @ "+getEventChargePerEvent()+"/event");
        System.out.println("Total Fee: "+calculateTotalFee());
    }
}
public class TechFestRegistration{
    public static void main(String[] args){
        Participant pa=new Participant();
        pa.setParticipantId(501);
        pa.setName("Rahul");
        pa.setBaseRegistrationFee(200.0);
        pa.setNumberOfEvents(3);
        pa.setEventChargePerEvent(100.0);
        pa.displayDetails();
    }
}