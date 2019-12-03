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
	StringBuilder ticketGen;
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
		ticketGen.append("\nTotal Price: "+ calculateTotalTicketPrice());
		return ticketGen;
	}
	
	public void writeTicket()
	{
		//	Writes initial values
		StringBuilder sb = generateTicket();
			
		//	TODO Write text to file
		try {
			PrintWriter pw = new PrintWriter("ticket" + generatePNR() + ".txt");			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public TreeMap<Passenger, Integer> getPassengers() {
		return passengers;
	}

	public void setPassengers(TreeMap<Passenger, Integer> passengers) {
		this.passengers = passengers;
	}
	
	
}
