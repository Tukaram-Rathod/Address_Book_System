package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

    private ArrayList<Contacts> data=new ArrayList<Contacts>();
    Scanner sc = new Scanner(System.in);
    //method to read string value from user
    public String readString(String displayMessage){
        Scanner sc = new Scanner(System.in);
        System.out.println(displayMessage);
        String input=sc.nextLine();
        return input;
    }
    //method to get index of Contacts object in addressBook
    public int indexOfContacts(){
        System.out.println();
        String name=readString("Enter First Name : ");
        int index=0;
        for(Contacts p : this.data)
        {
            if(p.getFirstName().equals(name) ){
                return index;
            }
            ++index;
        }
        return -1;
    }
    //method to add Contacts to address book
    public void addContacts(){
        System.out.println();
        String firstName=readString("Enter First Name : ");
        String lastName = readString("Enter Last Name : ");
        String address=readString("Enter Address : ");
        String city=readString("Enter City Name : ");
        String state=readString("Enter State: ");
        String zipCode=readString("Enter Zip Code : ");
        String mobileNo=readString("Enter Mobile number: ");
        String email=readString("Enter email : ");
        Contacts newEntry=new Contacts(firstName, lastName, city, state, address, email, zipCode, mobileNo);
        this.data.add(newEntry);
        System.out.println(firstName+" The Data Added Successfully To The  AddressBook.");
    }
    //method to edit conatcts details using first name
    public void editContacts(){
        int index=this.indexOfContacts();
        if(index != -1){
            System.out.println("What Do You Want To Change.\n 1.FirstName  2.LastName 3.Address  4.city  5.State  6.Zip  7.Email  8.MobileNumber");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    this.data.get(index).setFirstName(readString("Enter new First name Code: "));
                    System.out.println("First Name Updated");
                    break;
                case 2:
                    this.data.get(index).setLastName(readString("Enter new Last name Code: "));
                    System.out.println("Last Name Updated");
                    break;
                case 3:
                    this.data.get(index).setCity(readString("Enter new City: "));
                    System.out.println("City Updated");
                    break;
                case 4:
                    this.data.get(index).setState(readString("Enter new State: "));
                    System.out.println("State Updated");
                    break;
                case 5:
                    this.data.get(index).setAddress(readString("Enter new Address: "));
                    System.out.println("Address Updated");
                    break;
                case 6:
                    this.data.get(index).setZip(readString("Enter new Zip Code: "));
                    System.out.println("Zip Code Updated");
                    break;
                case 7:
                    this.data.get(index).setEmail(readString("Enter new email : "));
                    System.out.println("Email Updated");
                    break;
                case 8:
                    this.data.get(index).setMobNo(readString("Enter new Mobile Number: "));
                    System.out.println("Mobile Number Updated");
                    break;
                default:
                    System.out.println("invalid Input!");
            }
        }
        else
            System.out.println("No such Contact found!");
    }
    //method to delete contact using their first name
    public void deleteContacts(){
        int index=this.indexOfContacts();
        if(index != -1){
            Contacts p=this.data.remove(index);
            System.out.println("Contacts "+p.getFirstName()+" removed successfully.");
        }
        else
            System.out.println("No one with these details found!");
    }
    //method to show contact details
    public void showContacts(){
        int index=this.indexOfContacts();
        if(index != -1)
            this.data.get(index).showContactsDetails();
        else
            System.out.println("No one with these details found!");
    }

    //method to select which operation we want to do in AddressBook
    public void Menu(){
        int choice;
        while(true)
        {
            System.out.println("\n *****Enter Your Choice*****\n1.Add Contact\t\t2.Edit Contact\n3.show Contact\t\t4.Delete Contact\n5.Exit");
            choice=sc.nextInt();
            switch(choice) {
                case 1: addContacts();
                    break;
                case 2: editContacts();
                    break;
                case 3: showContacts();
                    break;
                case 4: deleteContacts();
                    break;
                case 5: System.exit(0);
                    break;
                default: System.out.println("Invalid Input ");
            }
        }
    }

}

