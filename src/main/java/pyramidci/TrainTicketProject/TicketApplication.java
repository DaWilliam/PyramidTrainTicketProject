package pyramidci.TrainTicketProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class TicketApplication {


    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        
        
        //==========================================================================
        //			GET TRAIN NUMBER
        //==========================================================================
        int trainNo = 0;        
        
        //Check to see if train exist
        //Prompt user for input until valid train number entered
        while (trainNo < 1001 || trainNo > 1006)
        {
        	try
        	{	
	        	System.out.println("Enter the Train Number");
	        	trainNo = sc.nextInt();
	        	
	        	if(trainNo < 1001 || trainNo > 1006)
	        		throw new Exception();
        	            	           
        	} catch (Exception e) { 
        		System.out.println("Train with given number does not exist. There are only trains between 1001 and 1006.\n\n");
        	}
        }

        
        
        //==========================================================================
        //			GET DATE
        //==========================================================================
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);	//	Subtract a day so you can create a ticket on the same day.
        cal2.set(0, 0, 0);	//	Set cal2 to 0 so it will go into the while loop.
        
        //Get travel date
        String str = "";
        Date date = new Date();
        
        while(cal2.before(cal))
        {
        	try {        		
        		
        		System.out.println("Enter travel Date (mm/dd/yyyy)");
                str = sc.next();
                
	            date = sdf.parse(str);
	            cal2.setTime(date);	
	            
	            if(cal2.before(cal))           
	            	System.out.println("Travel Date is cannot be before current date\n\n");                                              	                           
	            
	        } catch (ParseException e) {
	        	System.out.println("Invalid date\n\n");

	        }
        }

        

        //==========================================================================
        //			GET NUMBER OF PASSENGERS
        //==========================================================================
        //Get number of passengers and their details
        int numOfPass = 0;
        while(numOfPass <= 0)
        {
        	try
        	{
		        System.out.println("Enter the number of passengers");
		        numOfPass = sc.nextInt();
		        
		        if(numOfPass <= 0)
		        	System.out.println("You must have at least one passenger.\n\n");
        	} catch (Exception e)
        	{
        		System.out.println("Invalid input. Try again.\n\n");
        		sc.next();
        	}
        }
        
       
        
        //==========================================================================
        //			CREATE TRAIN
        //==========================================================================
        TrainDAO running = new TrainDAO();
        Train runaway = running.findTrain(trainNo);
        Ticket nada = new Ticket(cal2.getTime(), runaway);
        
        
        
        //==========================================================================
        //			GET PASSENGERS INFORMATION
        //==========================================================================
        //	Passenger Variables
        String name ="";
        int age = 0;
        char gender = 0;

        for(int i =0; i<numOfPass; i++)
        {
        	try
        	{
	            System.out.println("Enter Passenger Name");
	            name = sc.next();
	            
	            System.out.println("Enter Age");
	            age = sc.nextInt();
	            if(age <= 0)
	            	throw new Exception();
	            
	            System.out.println("Enter Gender (M/F)");
	            gender = Character.toUpperCase(sc.next().charAt(0));
	            if(gender != 'M' && gender != 'F')
	            	throw new Exception();
	            	            
	            nada.addPassenger(name,age,gender);
        	} catch (Exception e)
        	{
        		System.out.println("Invalid passenger value. Re-Enter information for this passenger.\n\n");        	
        		i--;
        	}
        }
        

        nada.writeTicket();
    }
}