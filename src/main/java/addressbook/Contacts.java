package addressbook;

import java.util.Scanner;
//Contact class
public class Contacts {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String mobileNo;
    private String email;
//Getter and setter Method
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getMobNo() {
        return mobileNo;
    }

    public void setMobNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //toString method returns objects
    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", mobNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public Contacts(String firstName, String lastName, String address, String city, String state, int zip, String mobileNo, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.mobileNo = mobileNo;
        this.email = email;
    }
    //Constructor
    public Contacts() {
    }
    //addContact Method
    public static void AddContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter Address");
        String address = sc.nextLine();
        System.out.println("Enter City Name");
        String city = sc.nextLine();
        System.out.println("Enter State Name");
        String state = sc.nextLine();
        System.out.println("Enter Zip");
        String zip = sc.nextLine();
        System.out.println("Enter Email");
        String email = sc.nextLine();
        System.out.println("Enter Mobile Number");
        String mobileNo = sc.nextLine();
    }
}
