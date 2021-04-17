package addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program !!!");
      //  HashMap will store the contact Details
        Map<String, Contacts> addressBook = new HashMap<String, Contacts>();
        menuChoice(addressBook);
    }
    public static void menuChoice(Map<String ,Contacts> addressBook) {
        Scanner sc=new Scanner(System.in);
        Contacts contacts = new Contacts();
        int choice;
        while(true){
            System.out.println("\n *****Enter Your Choice*****\n1.Add Contact\t\t2.Exit");
            choice=sc.nextInt();
            switch(choice) {
                case 1:
                    contacts.AddContact();
                    addressBook.put(contacts.getFirstName(), contacts);
                    break;
                case 2:System.exit(0);
            }
        }
    }
}
