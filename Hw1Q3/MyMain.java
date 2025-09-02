/**
 * @author Bryan Erickson
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class MyMain {
    public static void main(String[] args) {

        //A a datatype the uses a linked list to hold a list of people
        PersonList listOfPeople = new PersonList();

        try{
            //Reads the input file, throws an error if it doesn't exist
            FileReader instream = new FileReader("input.txt");

            //A scanner for the menu selection
            Scanner menuScanner = new Scanner(System.in);

            //A variable to control the menu's while loop
            boolean endMenu = false;
            
            //A simple menu to control the porgram
            while (!endMenu){
                System.out.println("Here are your options:");
                System.out.println("1: Store data from a premade file");
                System.out.println("2: Search for an ID");
                System.out.println("3: Display all data");
                System.out.println("4: End the program");
                System.out.println("Enter a selection:");

                int menuSelection = menuScanner.nextInt();

                switch (menuSelection) {
                    case 1: //Stores data from a file that must be called "input.txt"
                        listOfPeople.store(instream);
                        System.out.println("Input file was stored");
                        break;
                    case 2: //Searches for an ID that the user provides

                        //Store is called here incase the user didn't store the data beforehand
                        listOfPeople.store(instream);
                        System.out.println("Enter an ID to search:");
                        Scanner idScanner = new Scanner(System.in);

                        int idToFind = idScanner.nextInt();

                        int idLocation = listOfPeople.find(idToFind);

                        if(idLocation == -1){
                            System.out.println("ID was not found");
                        }else{
                            System.out.println("ID was found at index: " + idLocation);
                        }
                        

                        break;
                    case 3: //Displays all the people in the personList

                        listOfPeople.display(System.out);
                        break;

                    case 4://Ends the program
                        endMenu = true;
                        break;
                    default: //Shows up if an invalid selection is chosen
                        System.out.println("Invalid Selection");
                        break;
                }



            }

            menuScanner.close();

        }catch (IOException e){
            System.err.println("There was an error:" + e.getMessage());
            e.printStackTrace();
        }
        
    }
}


