package pyramidci.TrainTicketProject;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Ticket {
	int counter;
	String pnr;
	Date travelDate;
	Train train;
	TreeMap<Passenger, Integer> passengers;
	StringBuilder ticketGen;
	public Ticket(Date date, Train train)
	{
	
	}
	
	private String generatePNR()
	{
		
	}
	
	private double calcPassengerFare(Passenger passenger)
	{
		
	}
	
	private double calcTotalTicketPrice() {
		
	}
	
	public void addPassenger(String name, int age, char gender)
	{
		
	}
	
	private StringBuilder generateTicket()
	{
		ticketGen = new StringBuilder();
		ticketGen.append("PNR\t: "+pnr
						+"\nTrain No\t: "+train.getTrainNo()
						+"\nTrain Name\t: "+train.getTrainName()
						+"\nFrom\t: "+train.getSource()
						+"\nTo\t: "+train.getDestination()
						+"\nTravel Date\t : "+travelDate
						+"\n\nPassengers :"
						+"Name\tAge\tGender\tFare");
		for(Map.Entry<Passenger, Integer> p:passengers.entrySet()) {
			ticketGen.append(p.getKey().getName()+"\t"
							+p.getKey().getAge()+"\t"
							+p.getKey().getGender()+"\t"
							+p.getValue());
		}
		ticketGen.append("\nTotal Price: "+ calcTotalTicketPrice());
	}
	
	public void writeTicket()
	{
		
	}

	//	Getters and Setters below
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public TreeMap<Integer, Integer> getPassengers() {
		return passengers;
	}

	public void setPassengers(TreeMap<Integer, Integer> passengers) {
		this.passengers = passengers;
	}
	
	
}
