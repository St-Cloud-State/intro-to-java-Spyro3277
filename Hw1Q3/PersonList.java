/**
 * @author Bryan Erickson
 */

import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {

    private LinkedList<Person> internalList;

    //Constructor
    public PersonList(){
        this.internalList = new LinkedList<>();
    }

    
    //Reads the input data from a file and then stores it in a linked list
    public void store(FileReader instream){
        //Creating a scanner
        Scanner personScanner = new Scanner(instream);

        //Scans the input file line by line to make a new person and then adds it to the linked list
        while(personScanner.hasNext()){
            String firstName = personScanner.next();
            String lastName = personScanner.next();
            int id = personScanner.nextInt();

            Person newPerson = new Person(firstName, lastName, id);

        internalList.add(newPerson);
        }

        //Closes the scanner to release resources when done
        personScanner.close();
    }

    //Prints the elements of the linked list to the terminal
    public void display(PrintStream outStream){

       for (int i = 0; i < this.internalList.size(); i++ ){
        outStream.println(this.internalList.get(i).toString());
       }
    }

    //Finds the index of a person's id within the personList. Returns the index if found, or -1 if not found
    public int find(int searchId){

        boolean found = false;
        int index = 0;

        while (!found){
            
            if(this.internalList.get(index).getId() == searchId){
                found = true;
                return index;
            }else{
                index ++;

                if(index >= this.internalList.size()){
                    return -1;
                }
            }
        }
        return -1;
    }
}