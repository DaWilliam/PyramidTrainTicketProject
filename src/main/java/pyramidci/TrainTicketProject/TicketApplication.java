package pyramidci.TrainTicketProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class TicketApplication {


    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Train Number");
        int trainNo = sc.nextInt();
        //Check to see if train exist

        //Prompt user for input until valid train number entered
        while (trainNo <1001 || trainNo >1006)
        {
            System.out.println("Train with given number does not exist");
            System.out.println("Enter the Train Number");
            trainNo = sc.nextInt();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        //Get travel date

        System.out.println("Enter travel Date (mm/dd/yyyy)");
        String str = sc.next();
        Date date = new Date();
        try {
            date = sdf.parse(str);
            cal2.setTime(date);
            
            while(cal2.before(cal))
            {
                System.out.println("Travel Date is before current date");
                System.out.println("Enter travel Date");
                str = sc.next();
                date = sdf.parse(str);
                cal2.setTime(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Get number of passengers and their details
        System.out.println("Enter the number of passengers");
        int numOfPass = sc.nextInt();
        String name ="";
        int age = 0;
        char gender = 0;
        Train runaway;
        TrainDAO running = new TrainDAO();
        runaway = running.findTrain(trainNo);
        Ticket nada = new Ticket(cal2.getTime(), runaway);
        for(int i =0; i<numOfPass; i++)
        {
            System.out.println("Enter Passenger Name");
            name = sc.next();

            System.out.println("Enter Age");
            age = sc.nextInt();

            System.out.println("Enter Gender (M/F)");
            gender = Character.toUpperCase(sc.next().charAt(0));
            		
            nada.addPassenger(name,age,gender);
        }
        for(Map.Entry<Passenger, Integer> p:nada.getPassengers().entrySet()) {
        	System.out.println(p.getKey().getName());
        }
        nada.writeTicket();
    }
}