package pyramidci.TrainTicketProject;

import java.util.*;




public class TicketApplication {


    public static void main(String[] args) {

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
        System.out.println("Enter travel Date");



    }
}