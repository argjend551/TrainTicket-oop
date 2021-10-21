import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tickets {
    // string variable for departure
    private String departure;
    // string variable for destination
    private String destination;
    // int variable for the child ticket sum if you add more tickets of the same type, the sum of how many tickets you buy.
    private int childTicketSum = 0;
    // int variable for the adult ticket sum if you add more tickets of the same type, the sum of how many tickets you buy.
    private int adultTicketSum = 0;
    // int variable for the pensioner ticket sum if you add more tickets of the same type, the sum of how many tickets you buy.
    private int pensionerTicketSum = 0;
    // int variable for price adult.
    private int priceAdult;
    // int variable for price child.
    private int priceChild;
    // int variable for price pensioner.
    private int pricePensioner;
    // the priceOfTickets variable will hold the value of tickets * the price of one ticket.
    private int priceOfTickets;
    // int variable for the final price sum when you buy a lot of tickets.
    private int priceSum;
    Scanner scan = new Scanner(System.in);
    Departures dep = new Departures();


    // constructor for the class tickets inside the parameters you enter the price of the destination and departure and destination
    public Tickets(int priceArrival,String departure,String destination) {
        this.departure = departure;
        this.destination = destination;
        this.priceAdult = priceArrival;
    }


    // prints out the prices of the ticket that you entered through the constructor
    public void priceOfTickets() {
        System.out.println("Price Adult: " + priceAdult+"kr");
        pricePensioner = priceAdult / 2;
        System.out.println("Price Pensioner: " + pricePensioner+"kr");
        priceChild = priceAdult / 3;
        System.out.println("Price Child: " + priceChild+"kr");
    }


    // Method for buying a ticket.

    public void buyTicket() {

        System.out.println("Do you want to buy this ticket? press Y for yes or N for no");
        // takes user input
        String choice = scan.next();


        // if user input is Y it will ask you what kind of ticket you want
        if (choice.equals("y") || choice.equals("Y")) {
            dep.timeForTravel();
            System.out.println("What kind of ticket do you wan to buy? 1. Child 2. Adult 3. Pensioner");

            //int variable for your choice of ticket
            int kindOfTicket = 0;


             /*
                    Try catch to catch wrong inputs.
                    boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
             */

            boolean again = true;
            while(again){
                try{
                    // scans your choice.
                    kindOfTicket  = scan.nextInt();
                    again = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Error! choose between 1-3");
                    scan.next();
                }
            }





            // While loop runs as long as your choice is y (yes) and kind of ticket is lower than 4.
            while(choice.equals("y") && kindOfTicket < 4){


                // if your kindOfTicket choice is 1 it will run the code for child tickets.
                if (kindOfTicket == 1) {
                    System.out.println("You have chosen to buy a Child ticket");
                    System.out.println("how many tickets do you want to buy?");


                    // scans how many tickets you want
                    int ticketAmount = 0;


                    // scans your money you insert to the machine
                    int money = 0;

                    /*
                    Try catch to catch wrong inputs.
                    boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
                     */
                    boolean validInput = true;
                    while(validInput){
                        try{
                            //scans your input
                            ticketAmount  = scan.nextInt();
                            validInput = false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Error! Enter how many tickets you want, it haves to be a number.");
                            scan.next();
                        }
                    }

                    // multiplies the price of child ticket and how many tickets.
                    priceOfTickets = priceChild * ticketAmount;

                    // adds to childTicketSum how many tickets you bought of the child ticket
                    childTicketSum += ticketAmount;
                    // price sum adds the sum of numberOfTickets and holds the price
                    priceSum += priceOfTickets;

                    System.out.println("please insert " + priceOfTickets + "kr in to the machine");


                    /*
                    Try catch to catch wrong inputs.
                    boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
                    the money variable will scan the input of how much money you insert to the machine.
                     */

                    boolean validInput2 = true;
                    while(validInput2){
                        try{
                            money = scan.nextInt();
                            validInput2 = false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Error! Enter the amount you want to insert, it have to be a digit.");
                            scan.next();
                        }
                    }

                    System.out.println("The machine receives your money....");





                    // while loop runs as long as the choice input is Y

                    while (true) {


                        // if the money you entered is exactly the same amount as priceOfTickets the code inside the if statement will run
                        if (money == priceOfTickets) {
                            System.out.println("thank you for your purchase");
                            System.out.println("Do you wish to buy more of this ticket? press Y for yes or N to proceed to you ticket ");
                            // scans your choice
                            choice = scan.next();


                            // if your choice is y it will print out how many tickets do you want to buy, and send value of childTicketSum to the WriteTicket method
                            if (choice.equals("y") || choice.equals("Y")) {
                                writeTicket(childTicketSum, 0, 0,0);
                                System.out.println("What kind of ticket do you want to buy? 1. Child 2. Adult 3. Pensioner");

                                /*
                                  Try catch to catch wrong inputs.
                                     boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.

                              */

                                boolean validInput3 = true;
                                while(validInput3){
                                    try{
                                        kindOfTicket = scan.nextInt();
                                        validInput3 = false;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("Error! Enter what kind of ticket you want to buy 1-3");
                                        scan.next();
                                    }
                                }

                                // if the choice is not y, it will send all the values to the WriteTicket method and print out your recipe.
                            } else  {
                                writeTicket(childTicketSum, pensionerTicketSum, adultTicketSum, priceSum);
                                System.out.println("Your recipe");
                                displayTicket();

                            }
                            break;




                            /* if the money you entered is lower than the amount priceOfTickets the code inside the if statement will run.
                                 It will ask you to insert more money until you reach the amount
                             */

                        } else if (money <= priceOfTickets) {

                            System.out.println("You need to insert more money the ticket costs " + priceOfTickets + " you have inserted " + money + "kr");



                            /*
                             Try catch to catch wrong inputs.
                               boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
                                the money variable will scan the input of how much money you insert to the machine.
                             */

                            boolean validInput3 = true;
                            while(validInput3){
                                try{
                                    money += scan.nextInt();
                                    validInput3 = false;
                                }
                                catch (InputMismatchException e){
                                    System.out.println("Error! Enter the amount you want to insert, it have to be a digit.");
                                    scan.next();
                                }
                            }




                            /* if the money you entered is higher than the amount priceOfTickets the code inside the if statement will run.
                                 It will give you a exchange back and ask if you wish to buy more tickets.
                             */

                        } else if (money > priceOfTickets) {
                            money = money - priceOfTickets;
                            System.out.println("your exchange back " + money + "kr");
                            System.out.println("thank you for your purchase");
                            System.out.println("Do you wish to buy more of this ticket? press Y for yes or N to proceed to you ticket ");
                            choice = scan.next();

                            // if your choice is y it will print out how many tickets do you want to buy, and send value of childTicketSum to the WriteTicket method
                            if (choice.equals("y") || choice.equals("Y")) {
                                writeTicket(childTicketSum, 0, 0,0);
                                System.out.println("What kind of ticket do you want to buy? 1. Child 2. Adult 3. Pensioner");
                                  /*
                                  Try catch to catch wrong inputs.
                                     boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.

                              */

                                boolean validInput3 = true;
                                while(validInput3){
                                    try{
                                        kindOfTicket = scan.nextInt();
                                        validInput3 = false;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("Error! Enter what kind of ticket you want to buy 1-3");
                                        scan.next();
                                    }
                                }



                                // if the choice is not y, it will send all the values to the WriteTicket method and print out your recipe.
                            } else  {
                                writeTicket(childTicketSum, pensionerTicketSum, adultTicketSum, priceSum);
                                System.out.println("Your recipe");
                                displayTicket();
                            }
                            break;
                        }

                    }

                }



                // if your kindOfTicket choice is 2 it will run the code for adult tickets.

                if (kindOfTicket == 2) {



                    System.out.println("You have chosen to buy a Adult ticket");
                    System.out.println("how many tickets do you want to buy?");
                    // scans how many tickets you want
                    int ticketAmount = 0;


                    // scans your money you insert to the machine
                    int money = 0;

                    /*
                    Try catch to catch wrong inputs.
                    boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
                     */

                    boolean validInput = true;
                    while(validInput){
                        try{
                            ticketAmount  = scan.nextInt();
                            validInput = false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Error! Enter how many tickets you want, it haves to be a number.");
                            scan.next();
                        }
                    }


                    // multiplies the price of adult ticket and how many tickets.
                    priceOfTickets = priceAdult * ticketAmount;
                    // adds to adultTicketSum how many tickets you bought of the child ticket
                    adultTicketSum += ticketAmount;
                    // price sum adds the sum of numberOfTickets and holds the price
                    priceSum += priceOfTickets;

                    System.out.println("please insert " + priceOfTickets + "kr in to the machine");


                      /*
                    Try catch to catch wrong inputs.
                    boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
                     */

                    boolean validInput2 = true;
                    while(validInput2){
                        try{
                            money = scan.nextInt();
                            validInput2 = false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Error! Enter the amount you want to insert, it have to be a digit.");
                            scan.next();
                        }
                    }
                    System.out.println("The machine receives your money....");




                    // while loop will run as long as your choice input is Y
                    while (true) {


                        // if the money you entered is exactly the same amount as priceOfTickets the code inside the if statement will run
                        if (money == priceOfTickets) {
                            System.out.println("thank you for your purchase");
                            System.out.println("Do you wish to buy more of this ticket? press Y for yes or N to proceed to you ticket ");
                            // scans your choice
                            choice = scan.next();




                            // if your choice is y it will print out how many tickets do you want to buy, and send value of adultTicketSum to the WriteTicket method

                            if (choice.equals("y") || choice.equals("Y")) {
                                writeTicket(0, 0, adultTicketSum, 0);
                                System.out.println("What kind of ticket do you want to buy? 1. Child 2. Adult 3. Pensioner");
                                      /*
                                  Try catch to catch wrong inputs.
                                     boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.

                              */

                                boolean validInput3 = true;
                                while(validInput3){
                                    try{
                                        kindOfTicket = scan.nextInt();
                                        validInput3 = false;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("Error! Enter what kind of ticket you want to buy 1-3");
                                        scan.next();
                                    }
                                }



                                // if the choice is not y, it will send all the values to the WriteTicket method and print out your recipe.

                            } else {
                                writeTicket(childTicketSum, pensionerTicketSum, adultTicketSum, priceSum);
                                System.out.println("Your recipe");
                                displayTicket();
                            }
                            break;




                            /* if the money you entered is lower than the amount priceOfTickets the code inside the if statement will run.
                              It will ask you to insert more money until you reach the amount
                             */

                        } else if (money <= priceOfTickets) {

                            System.out.println("You need to insert more money the ticket kosts " + priceOfTickets + " you have inserted " + money + "kr");


                            /*
                             Try catch to catch wrong inputs.
                               boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
                                the money variable will scan the input of how much money you insert to the machine.
                             */

                            boolean validInput3 = true;
                            while(validInput3){
                                try{
                                    money += scan.nextInt();
                                    validInput3 = false;
                                }
                                catch (InputMismatchException e){
                                    System.out.println("Error! Enter the amount you want to insert, it have to be a digit.");
                                    scan.next();
                                }
                            }



                            /* if the money you entered is higher than the amount priceOfTickets the code inside the if statement will run.
                                 It will give you an exchange back and ask if you wish to buy more tickets.
                             */

                        } else if (money > priceOfTickets) {
                            money = money - priceOfTickets;
                            System.out.println("your exchange back " + money + "kr");
                            System.out.println("thank you for your purchase");
                            System.out.println("Do you wish to buy more of this ticket? press Y for yes or N to proceed to you ticket ");
                            choice = scan.next();


                            // if your choice is y it will print out how many tickets do you want to buy, and send value of adultTicketSum to the WriteTicket method
                            if (choice.equals("y") || choice.equals("Y")) {
                                writeTicket(0, 0, adultTicketSum,0);
                                System.out.println("What kind of ticket do you want to buy? 1. Child 2. Adult 3. Pensioner");


                                      /*
                                  Try catch to catch wrong inputs.
                                     boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.

                              */

                                boolean validInput3 = true;
                                while(validInput3){
                                    try{
                                        kindOfTicket = scan.nextInt();
                                        validInput3 = false;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("Error! Enter what kind of ticket you want to buy 1-3");
                                        scan.next();
                                    }
                                }



                                // if the choice is not y, it will send all the values to the WriteTicket method and print out your recipe.
                            } else  {
                                writeTicket(childTicketSum, pensionerTicketSum, adultTicketSum, priceSum);
                                System.out.println("Your recipe");
                                displayTicket();
                            }
                            break;
                        }

                    }
                }




                // if your kindOfTicket choice is 3 it will run the code for pensioner tickets.
                if (kindOfTicket == 3) {
                    System.out.println("You have chosen to buy a Pensioner ticket");
                    System.out.println("how many tickets do you want to buy?");

                    // scans how many tickets you want
                    int ticketAmount = 0;


                    // scans your money you insert to the machine
                    int money = 0;

                    /*
                    Try catch to catch wrong inputs.
                    boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
                     */


                    boolean validInput = true;
                    while(validInput){
                        try{
                            ticketAmount  = scan.nextInt();
                            validInput = false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Error! Enter how many tickets you want, it haves to be a number.");
                            scan.next();
                        }
                    }





                    // multiplies the price of pensioner ticket and how many tickets.
                    priceOfTickets = pricePensioner * ticketAmount;

                    // adds to pensionerTicketSum how many tickets you bought of the child ticket
                    pensionerTicketSum += ticketAmount;

                    // price sum adds the sum of numberOfTickets and holds the price
                    priceSum += priceOfTickets;


                    System.out.println("please insert " + priceOfTickets + "kr in to the machine");




                     /*
                    Try catch to catch wrong inputs.
                    boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
                     */

                    boolean validInput2 = true;
                    while(validInput2){
                        try{
                            money = scan.nextInt();
                            validInput2 = false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Error! Enter the amount you want to insert, it have to be a digit.");
                            scan.next();
                        }
                    }




                    System.out.println("The machine receives your money....");

                    // while loop loops as long as choice is y

                    while (true) {


                        // if the money you entered is exactly the same amount as priceOfTickets the code inside the if statement will run
                        if (money == priceOfTickets) {
                            System.out.println("thank you for your purchase");
                            System.out.println("Do you wish to buy more of this ticket? press Y for yes or N to proceed to you ticket ");

                            // scans your choice
                            choice = scan.next();

                            // if your choice is y it will print out how many tickets do you want to buy, and send value of pensionerTicketSum to the WriteTicket method
                            if (choice.equals("y") || choice.equals("Y")) {
                                writeTicket(0, pensionerTicketSum, 0,0);
                                System.out.println("What kind of ticket do you want to buy? 1. Child 2. Adult 3. Pensioner");


                                      /*
                                  Try catch to catch wrong inputs.
                                     boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.

                              */

                                boolean validInput3 = true;
                                while(validInput3){
                                    try{
                                        kindOfTicket = scan.nextInt();
                                        validInput3 = false;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("Error! Enter what kind of ticket you want to buy 1-3");
                                        scan.next();
                                    }
                                }

                                // if the choice is not y, it will send all the values to the WriteTicket method and print out your recipe.
                            } else {
                                writeTicket(childTicketSum, pensionerTicketSum, adultTicketSum, priceSum);
                                System.out.println("Your recipe");
                                displayTicket();
                            }
                            break;



                                 /* if the money you entered is lower than the amount priceOfTickets the code inside the if statement will run.
                                     It will ask you to insert more money until you reach the amount
                             */
                        } else if (money <= priceOfTickets) {

                            System.out.println("You need to insert more money the ticket kosts " + priceOfTickets + " you have inserted " + money + "kr");


                              /*
                             Try catch to catch wrong inputs.
                               boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.
                                the money variable will scan the input of how much money you insert to the machine.
                             */


                            boolean validInput3 = true;
                            while(validInput3){
                                try{
                                    money += scan.nextInt();
                                    validInput3 = false;
                                }
                                catch (InputMismatchException e){
                                    System.out.println("Error! Enter the amount you want to insert, it have to be a digit.");
                                    scan.next();
                                }
                            }



                            /* if the money you entered is higher than the amount priceOfTickets the code inside the if statement will run.
                                 It will give you an exchange back and ask if you wish to buy more tickets.
                             */


                        } else if (money > priceOfTickets) {
                            money = money - priceOfTickets;
                            System.out.println("your exchange back " + money + "kr");
                            System.out.println("thank you for your purchase");
                            System.out.println("Do you wish to buy more of this ticket? press Y for yes or N to proceed to you ticket ");
                            choice = scan.next();
                            if (choice.equals("y") || choice.equals("Y")) {
                                writeTicket(0, pensionerTicketSum, 0,0);
                                System.out.println("What kind of ticket do you want to buy? 1. Child 2. Adult 3. Pensioner");

                                      /*
                                  Try catch to catch wrong inputs.
                                     boolean again set to true and the while loop runs as long as its true until your input is correct it will return false and exit the loop.

                              */

                                boolean validInput3 = true;
                                while(validInput3){
                                    try{
                                        kindOfTicket = scan.nextInt();
                                        validInput3 = false;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("Error! Enter what kind of ticket you want to buy 1-3");
                                        scan.next();
                                    }
                                }


                            } else {
                                writeTicket(childTicketSum, pensionerTicketSum, adultTicketSum, priceSum);
                                System.out.println("Your recipe");
                                displayTicket();
                            }
                            break;
                        }


                    }

                }

            }

        }

    }


    // method to print out ticket
    public void displayTicket(){

        try {
            //BufferedReader reads the text file from Ticket.txt
            BufferedReader reader = new BufferedReader(new FileReader("src/Ticket.txt"));

            //String line to hold every line, the while loop adds every line to the String variable and prints every line and prints until its null
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    // method to write your ticket

    public void writeTicket(int Child, int Pensioner, int Adult, int price){

        try {

            //BufferedWriter writes to the text file Ticket.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Ticket.txt"));


            /*
            if statement if you buy an adult/pensioner/child ticket it will write it to the file
                it will write your departure and destination and the total price.
             */
            writer.write("\n----------TRAIN TICKET-------------------");
            writer.write("\n                               ");
            if(Adult>0){
                writer.write("\nADULT: "+ Adult+"         ");

            }
            if(Pensioner > 0){
                writer.write("\nPENSIONER: "+ Pensioner+"         ");

            }
            if(Child > 0){
                writer.write("\nCHILD: "+ Child+"         ");

            }
            writer.write("\nFROM: " + departure);
            writer.write("\nTO: "+ destination);
            writer.write("\nTIME DEPARTURE: "+ dep.timeDepart);
            writer.write("\nTIME ARRIVAL: "+ dep.timeArrive);
            writer.write("\nPRICE: " + price +"kr");
            writer.write("\n                               ");
            writer.write("\n                               ");
            writer.write("\n--------------------------------------------");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}