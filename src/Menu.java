import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


    public static void main(String[] args) {

        //creating scanner object.

        Scanner scan = new Scanner(System.in);

        // int variable for you choice in the menu
        int choice = 0;

        System.out.println("-----------------------------");
        System.out.println("Welcome to the train ticket machine");
        System.out.println("1- Search Trip");
        System.out.println("2- Show my ticket");
        System.out.println("3- Ticket prices");
        System.out.println("4- Show Departures");
        System.out.println("5- Exit");
        System.out.println("-----------------------------");


//while loop condition is true so the menu will repeat all the time.

        while(true){

            // object of the class Departures.
            Departures depart = new Departures();

            /*
                    Try catch to catch wrong inputs.
                    boolean again set to true and the while loop runs as long as its true until your input is correct it will turn false and exit the loop.
             */
            boolean again = true;
            while(again){
                try{
                    choice = scan.nextInt();
                    again = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Error! choose between 1-4 in the menu");
                    scan.next();
                }
            }

            // Switch-Case for your choices in the menu.

            switch (choice){

                case 1:

                    System.out.println("Where are you going to departure from?");

                    // object of departures that will print out all the stations from a text-file.
                    depart.printStations();
                    //Scanner that scans the next line and makes it uppercase and sends the value (the choice of your departure) to Travel method in Departures class
                    scan.nextLine();
                   String departure = scan.nextLine().toUpperCase();


                    depart.userChoiceTravel(departure);

                    break;


                case 2:

                    //BufferedReader reads the text file from Ticket.txt

                      try {

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
                    break;





                case 3:

                    System.out.println("Prices within Sweden");
                    System.out.println("Adult: 150kr");
                    System.out.println("Pensioner: 75kr");
                    System.out.println("Child: 50kr");
                    System.out.println("---------------------------");

                    System.out.println("Prices outside Sweden");
                    System.out.println("Adult: 250kr");
                    System.out.println("Pensioner: 125kr");
                    System.out.println("Child: 83kr");


                    break;



                case 4:

                    // prints out Avgångar.txt

                   depart.departureTips();

                    break;


                case 5:
                    // Exits the program

                    System.out.println("Exiting Program...");
                    System.exit(0);
                default:
                    System.out.println("Error! choose between 1-4 in the menu");
        }


            System.out.println("-------------------");
            System.out.println("1- Search Trip");
            System.out.println("2- Show my ticket");
            System.out.println("3- Ticket prices");
            System.out.println("4- Show Departures");
            System.out.println("5- Exit");
            System.out.println("-------------------");



    }


}

}