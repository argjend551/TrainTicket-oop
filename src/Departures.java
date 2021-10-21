import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Departures {
    Scanner scan = new Scanner(System.in);


    public String timeArrive;
    public String timeDepart;





    // in this method is all departures you chose and destination and checks if it exists and sends values to the klass Tickets.

    public void userChoiceTravel(String departure){
        String destination = "";
        // creating variable String destination that we will use as our destination.




        // if statement that checks if the departure input you gave is true, it will be checked in the method Stations and check if the station exists.
        //if it don't exist it will return false.

        if(allStations(departure)){
            System.out.println("---------Departures from "+ departure + "------------");
            printStations();
            System.out.println("---------------------");
            System.out.println("Destination: ");

            // gets users input for the destination and makes it uppercase.
            destination = scan.nextLine().toUpperCase();

            fastestRouts(departure,destination);
            // if departure and destination is same it will print choose another station.
            if(departure.equals(destination)){
                System.out.println("Choose another station");
            }


            // if destination is not Köpenhamn and departure is köpenhamn OR destination is köpenhamn and departure is not köpenhamn it will cost 250kr

            if (allStations(destination) && !destination.equals("KÖPENHAMN C") && departure.equals("KÖPENHAMN C")|| destination.equals("KÖPENHAMN C")&& !departure.equals("KÖPENHAMN C")){
                // creating object of class Tickets and sending value 250kr the price and the departure info and destination info
                Tickets tickets = new Tickets(250,departure,destination);

                // will print out the price of the ticket for child,adult,pensioner
                tickets.priceOfTickets();

                // will send you to BuyTicket in Ticket class
                tickets.buyTicket();



            }

            // if destination is not Köpenhamn and departure is not köpenhamn it will cost 150kr and departure not equal to destination.


            else if (allStations(destination) && !destination.equals("KÖPENHAMN C")&& !departure.equals("KÖPENHAMN C")&&!departure.equals(destination)){

                // creating object of class Tickets and sending value 150kr the price and the departure info and destination info
                Tickets dest = new Tickets(150,departure,destination);

                // will print out the price of the ticket for child,adult,pensioner
                dest.priceOfTickets();

                // will send you to BuyTicket in Ticket class
                dest.buyTicket();
            }


        }
        // if departure OR destination do not exist, it will print out "Location not found."
        if(!allStations(departure) || !allStations(destination)){
            System.out.println("Location not found");
        }


    }





    // method that checks which route is the fastest for your departure.

    public void fastestRouts(String departure, String destination) {

        // if your departure is Lund it will add those departures to the list and check if your destination is in any of the strings
        if(departure.equals("LUND C")){
            ArrayList<String>routes=new ArrayList<>();
            routes.add("LUND C - HJÄRUP - MALMÖ C - TRIANGELN - HYLLIE - OXIE STATION - SVEDALA - SKURUP - SVARTE - YSTAD");
            routes.add("MALMÖ C - LUND C - HÄSSLEHOLM C - KRISTIANSTAD C - BROMÖLLA");
            routes.add("MALMÖ C - HJÄRUP - LUND C - ESLÖV C - HÄSSLEHOLM C - KRISTIANSTAD C");
            for (String s:routes) {
                if(s.contains(departure)){
                    if(s.contains(destination)){
                        System.out.println("Shortest rout");
                        System.out.println(s);
                        break;
                    }


                }

            }
        }

        // if your departure is Malmö it will add those departures to the list and check if your destination is in any of the strings
        if(departure.equals("MALMÖ C")){
            ArrayList<String>routes=new ArrayList<>();
            routes.add("MALMÖ C - LUND C - HÄSSLEHOLM C - KRISTIANSTAD C - BROMÖLLA");
            routes.add("MALMÖ C - HJÄRUP - LUND C - ESLÖV C - HÄSSLEHOLM C - KRISTIANSTAD C");
            for (String s:routes) {
                if(s.contains(departure)){
                    if(s.contains(destination)){
                        System.out.println("Shortest rout");
                        System.out.println(s);
                        break;
                    }


                }

            }
        }


        // if your departure is KÖPENHAMN it will add those departures to the list and check if your destination is in any of the strings
        if(departure.equals("KÖPENHAMN C")){
            ArrayList<String>routes=new ArrayList<>();
            routes.add("KÖPENHAMN C - HYLLIE - MALMÖ C - TRIANGELN");
            routes.add("KÖPENHAMN C - HYLLIE - MALMÖ C - TRIANGELN - LUND C - HÄSSLEHOLM C - KRISTIANSTAD C");
            for (String s:routes) {
                if(s.contains(departure)){
                    if(s.contains(destination)){
                        System.out.println("Shortest rout");
                        System.out.println(s);
                        break;
                    }


                }

            }
        }


        // if your departure is not Lund or not köpenhamn and not LUND c it will add those departures to the list and check if your destination is in any of the strings
        else if(!departure.equals("MALMÖ C")&&!departure.equals("KÖPENHAMN C")&&!departure.equals("LUND C")){
            ArrayList<String>routes=new ArrayList<>();
            routes.add("KÖPENHAMN C - HYLLIE - MALMÖ C - TRIANGELN");
            routes.add("KÖPENHAMN C - HYLLIE - MALMÖ C - TRIANGELN - LUND C - HÄSSLEHOLM C - KRISTIANSTAD C");
            routes.add("MALMÖ C - LUND C - HÄSSLEHOLM C - KRISTIANSTAD C - BROMÖLLA");
            routes.add("MALMÖ C - HJÄRUP - LUND C - ESLÖV C - HÄSSLEHOLM C - KRISTIANSTAD C");
            routes.add("LUND C - HJÄRUP - MALMÖ C - TRIANGELN - HYLLIE - OXIE STATION - SVEDALA - SKURUP - SVARTE - YSTAD");
            for (String s:routes) {
                if(s.contains(departure)){
                    if(s.contains(destination)){
                        System.out.println("Shortest rout");
                        System.out.println(s);
                        break;
                    }


                }

            }
        }
  }








// method to print out the text file avgångar.txt where you can get some tips for departures.

    public void departureTips(){

        //BufferedReader reads the text file from Avgångar.txt

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Avgångar.txt"));
            //String line to hold every line, the while loop adds every line to the String variable and prints every line and prints until its null

            String line;
            while((line = reader.readLine()) != null){
                    System.out.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }








// method to get your departure and arrival time

    public void timeForTravel(){

        System.out.println("What time do you want to depart?");
        System.out.print("Time:"); String departureTime = scan.next();


            // for loop that checks if you gave a 4digit number

        for (int i = 4; i > departureTime.length();) {

            System.out.println("Invalid enter a time 0000-2400");
            System.out.print("Time: ");
            departureTime = scan.next();
        }


        // for loop that checks if you gave a 4digit number

        System.out.println("What time do you want to arrive?");
        System.out.print("Time:"); String ariveTime = scan.next();

        for (int i = 2400; i < ariveTime.length();) {

            System.out.println("Invalid enter a time 0000-2400");
            System.out.print("Time: ");
            ariveTime = scan.next();

        }
        char twoDots = ':';

        // adds two dots to the time so instead of 2200 it will appear 22:00
        if(!departureTime.contains(":") && !ariveTime.contains(":")){
            departureTime = departureTime.substring(0,2) + twoDots + departureTime.substring(2,4);
            ariveTime = ariveTime.substring(0,2) + twoDots + ariveTime.substring(2,4);
        }


        // gives the value to the variable timeDepart and TimeArrive
        timeDepart = departureTime;
        timeArrive = ariveTime;

    }




    public void printStations(){

        //BufferedReader reads the text file from Stationer.txt

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Stationer.txt"));


            //String line to hold every line, the while loop adds every line to the String variable and prints every line and prints until its null
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    //Method that checks if the station you entered exists.

    public boolean allStations(String station){
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Malmö C");
        stations.add("Hjärup");
        stations.add("Lund C");
        stations.add("Eslöv C");
        stations.add("Hässleholm C");
        stations.add("Kristianstad C");
        stations.add("Bromölla");
        stations.add("Köpenhamn C");
        stations.add("Hyllie");
        stations.add("Triangeln");
        stations.add("Oxie");
        stations.add("Svedala");
        stations.add("Skurup");
        stations.add("Svarte");
        stations.add("Ystad");


        // for loop that loops through all stations and checks if the station you entered exists, if it don't exist it will return false.
        for (String s:stations) {
            if(s.equalsIgnoreCase(station)) {
                return true;

            }

        }
        return false;
    }



}
