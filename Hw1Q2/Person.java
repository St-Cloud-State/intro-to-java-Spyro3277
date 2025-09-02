public class Person {

    private String firstName;
    private String lastName;
    private int id;
   
    //Constructor
    public Person(String firstName, String lastName, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    //Accessor Methods
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getId(){
        return id;
    }

    public void changeFirstName(String firstName){
        this.firstName = firstName;
    }

     public void changeLastName(String lastName){
        this.lastName = lastName;
    }

     public void changeId(int id){
        this.id = id;
    }

    //toString
    @Override
    public String toString(){
        return firstName + " "+ lastName + " "+ id;
    }

    public static void main(String[] args) {
       
       
        
    }

}