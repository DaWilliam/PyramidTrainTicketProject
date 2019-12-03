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

        Date objdate = new Date();
        Calendar cal = Calendar.getInstance();
       // cal.setTime(objdate);

        //Get travel date

        System.out.println("Enter travel Date");
        String str = sc.next();
        Date date = new Date();
        try {
            date = sdf.parse(str);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date);

            while(date.before(objdate))
            {
                System.out.println("Travel Date is before current date");
                System.out.println("Enter travel Date");
                str = sc.next();
                date = sdf.parse(str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //Get number of passengers and their details
        System.out.println("Enter the number of passengers");
        int numOfPass = sc.nextInt();
        String name ="";
        int age = 0;
        char gender =  0;
        for(int i =0; i<numOfPass; i++)
        {
            System.out.println("Enter Passenger Name");
            name = sc.next();

            System.out.println("Enter Age");
            age = sc.nextInt();

            System.out.println("Enter Gender (M/F)");
            gender = sc.next().charAt(0);
        }
        Train runaway;
        TrainDAO running = new TrainDAO();
        runaway = running.findTrain(trainNo);

        Ticket nada = new Ticket(date, runaway);

        nada.addPassenger(name, age,gender);



    }
}