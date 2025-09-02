/**
 * @author Bryan Erickson
 */
import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintStream;


public class MyMain {

    //Reads the input data from a file and then stores it in a linked list
    static void store(FileReader instream, LinkedList<Person> peopleList){
        //Creating a scanner
        Scanner personScanner = new Scanner(instream);

        //Scans the input file line by line to make a new person and then adds it to the linked list
        while(personScanner.hasNext()){
            String firstName = personScanner.next();
            String lastName = personScanner.next();
            int id = personScanner.nextInt();

            Person newPerson = new Person(firstName, lastName, id);

        peopleList.add(newPerson);
        }

        //Closes the scanner to release resources when done
        personScanner.close();
    }

    //Prints the elements of the linked list to the terminal
    static void display(PrintStream outStream, LinkedList<Person> peopleList){

       for (int i = 0; i < peopleList.size(); i++ ){
        outStream.println(peopleList.get(i).toString());
       }
    }

    //Finds the index of a person's id within the personList. Returns the index if found, or -1 if not found
    static int find(int searchId, LinkedList<Person> peopleList){

        boolean found = false;
        int index = 0;

        while (!found){
            
            if(peopleList.get(index).getId() == searchId){
                found = true;
                return index;
            }else{
                index ++;

                if(index >= peopleList.size()){
                    return -1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {

        //A linked list that holds the Person datatype
        LinkedList<Person> peopleList = new LinkedList<Person>();

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
                        store(instream, peopleList);
                        System.out.println("Input file was stored");
                        break;
                    case 2: //Searches for an ID that the user provides

                        //Store is called here incase the user didn't store the data beforehand
                        store(instream, peopleList);
                        System.out.println("Enter an ID to search:");
                        Scanner idScanner = new Scanner(System.in);

                        int idToFind = idScanner.nextInt();

                        int idLocation = find(idToFind, peopleList);

                        if(idLocation == -1){
                            System.out.println("ID was not found");
                        }else{
                            System.out.println("ID was found at index: " + idLocation);
                        }
                        

                        break;
                    case 3: //Displays all the people in the personList

                        display(System.out, peopleList);
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


