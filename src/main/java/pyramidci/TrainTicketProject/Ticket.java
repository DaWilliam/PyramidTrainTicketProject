package pyramidci.TrainTicketProject;

import java.util.Date;
import java.util.TreeMap;

public class Ticket {
	int counter;
	String pnr;
	Date travelDate;
	Train train;
	TreeMap<Integer, Integer> passengers;
	
	public Ticket(Date date, Train train)
	{
	
	}
	
	private String generatePNR()
	{

		setCounter(99);
		char source = train.getSource().charAt(0);
		char destination = train.getDestination().charAt(0);
		travelDate = getTravelDate();

		StringBuffer str = new StringBuffer();
		str.append(source);
		str.append(destination);
		str.append("_");
		str.append(travelDate.toString());
		str.append("_");
		str.append(getCounter());

		return str.toString();
	}
	
	private double calcPassengerFare(Passenger passenger)
	{
		
	}
	
	public void addPassenger(String name, int age, char gender)
	{
		
	}
	
	private StringBuilder generateTicket()
	{
		
	}
	
	public void writeTicket()
	{
		
	}

	//	Getters and Setters below
	public int getCounter() {
		counter += 1;
		setCounter(counter);
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
