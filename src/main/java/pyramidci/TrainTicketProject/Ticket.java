package pyramidci.TrainTicketProject;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.io.*;

public class Ticket {
	int counter;
	String pnr;
	Date travelDate;
	Train train;
	TreeMap<Passenger, Integer> passengers;
	
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
		double discount = 0;
		
		//	Gets the appropriate discount
		if(passenger.getAge() <= 12)
			discount = train.getTicketPrice() * .5;
		else if(passenger.getAge() >= 60)
			discount = train.getTicketPrice() * .6;
		else if (passenger.getGender() == 'F')
			discount = train.getTicketPrice() * .25d;
		
		//	Subtract the discount from the total price
		return train.getTicketPrice() - discount;
	}
	
	private double calculateTotalTicketPrice()
	{	
		double sum = 0;
		for(Map.Entry<Passenger, Integer> p : passengers.entrySet())
		{
			sum += p.getValue();	//	Adds price of each passenger to sum 
		}
		
		return sum;	//	Returns total price
	}
	
	//	Adds passenger and their passengerFare to passengers map
	public void addPassenger(String name, int age, char gender)
	{
		Passenger passenger = new Passenger(name, age, gender);
		passengers.put(passenger, (int)calcPassengerFare(passenger));
	}
	
	private StringBuilder generateTicket()
	{
		
	}
	
	public void writeTicket()
	{
		//	Writes initial values
		String ticketText = "PNR\t\t: " + generatePNR() + "\n"
				+ "Train no\t: " + train.getTrainNo() + "\n"
				+ "Train Name\t: " + train.getTrainName() + "\n"
				+ "From\t: " + train.getSource() + "\n"
				+ "To\t: " + train.getDestination() + "\n"
				+ "Travel Date\t: " +  travelDate.toString() + "\n\n"
				+ "Passengers:"  + "\n"
				+ "Name\t\tAge\t\tGender\t\tFare" + "\n";
		
		//	Writes list of passengers
		for(Map.Entry<Passenger, Integer> p : passengers.entrySet())
		{
			ticketText += p.getKey().getName() + "\t\t" 
						+ p.getKey().getAge() + "\t\t"
						+ p.getKey().getGender() + "\t\t"
						+ p.getValue() + "\n";
		}
		
		//	TODO Write text to file
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
