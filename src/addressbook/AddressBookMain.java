package addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    //Add multiple persons
    public ArrayList<Contacts> contactbook = new ArrayList<>();
    ArrayList<AddressBookList> addressBookNameList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    /* @Description- Add new contacts in address book  */
    public void addContact()
    {
        System.out.println("Enter First Name");
        String first = scan.nextLine();
        //duplicateCheck(first);
        System.out.println("Enter Last Name");
        String last = scan.nextLine();
        System.out.println("Enter Address");
        String address = scan.nextLine();
        System.out.println("Enter City");
        String city = scan.nextLine();
        System.out.println("Enter State");
        String state = scan.nextLine();
        System.out.println("Enter Zip Code");
        int zip = Integer.parseInt(scan.nextLine());
        System.out.println("Enter Phone Number");
        long mobileNo = Long.parseLong(scan.nextLine());
        System.out.println("Enter E-mail");
        String email = scan.nextLine();
        Contacts contact = new Contacts(first, last, address, city, state, zip, mobileNo, email);
        contactbook.add(contact);
        System.out.println("Contact added Successfully");

    }

    /* Description - display contacts address book */
    public void displayPerson()
    {
        System.out.println("\nEntered Person Details is:");
        for (Contacts person : contactbook)
        {
            System.out.println(person.toString());
        }
    }

    /* Description - edit contacts address book */
    public void editPerson()
    {
        System.out.println("\n enter First name to edit details:");
        String name = scan.nextLine();
        for (Contacts person : contactbook) {
            System.out.println(person.toString());
            if (name.equals(person.firstName)) {
                System.out.println("\"Select the option to edit: \n"
                        + "1) Mobile no\n"
                        + "2) Email-Id\n"
                        + "3) Address\n"
                        + "4) Quit");
                int numb = Integer.parseInt(scan.nextLine());
                switch (numb) {
                    case 1 : {
                        System.out.println("enter new Mobile number:");
                        long mobileNo = Long.parseLong(scan.nextLine());
                        person.setMobNo(mobileNo);
                        System.out.println("mobile no. is updated\n");
                        break;
                    }
                    case 2 : {
                        System.out.println("enter new Email-id:");
                        String email = scan.nextLine();
                        person.setEmail(email);
                        System.out.println("Email-id is updated\n");
                        break;
                    }
                    case 3 : {
                        System.out.println("enter your city");
                        String city = scan.nextLine();
                        System.out.println("enter your state");
                        String state = scan.nextLine();
                        System.out.println("enter your zip code");
                        int zip = Integer.parseInt(scan.nextLine());
                        person.setCity(city);
                        person.setState(state);
                        person.setZip(zip);
                        System.out.println("Address is updated\n");
                        break;
                    }
                    default : System.out.println("please enter right choice");
                }
            }
            else
                System.out.println("Person is not registered");
        }
    }

    /* Description - delete contacts in address book  using their name */
    public void deletePerson()
    {
        System.out.println("enter First name to delete details:");
        String name = scan.nextLine();
        for (int i=0; i < contactbook.size(); i++)
        {
            String personName = contactbook.get(i).firstName;
            if (name.equals(personName))
            {
                contactbook.remove(i);
                System.out.println("this person details is deleted");
                break;
            }
            else
                System.out.println("please enter valid name");
        }
    }


    /* Description - to create address book */
    public void newAddressBook()
    {
        System.out.println("Enter AddressBook Name");
        String userInputBookName = scan.nextLine();
        AddressBookList addressbook = new AddressBookList(userInputBookName);
        addressBookNameList.add(addressbook);
        System.out.println("New Address Book Name is added to list");
    }

    /* Description - display new address book */
    public void displayAddressBook()
    {
        System.out.println("Existing AddressBook Names are : ");
        for (AddressBookList addressBookList : addressBookNameList)
        {
            System.out.println(addressBookList);
        }
    }
    /* to check duplicate entry if find duplicate are not allowed */
    public void duplicateCheck(String first)
    {
        for (int k = 0; k < contactbook.size(); k++)
        {
            String contactName = contactbook.get(k).firstName;
            if (first.equals(contactName))
                System.out.println("This Person is Already Present");
            else {
                System.out.println("You can Add this Person");
                break;
            }
        }
    }
    /* Description - to search person by state wise */
    public void searchPersonByState()
    {
        System.out.println("Enter the state name to search Person by state name");
        String userState = scan.nextLine();
        Dictionary Statewisedict = new Hashtable();
        contactbook.stream().filter(map -> map.getState().contains(userState)).forEach(contactbook -> Statewisedict.put(contactbook.getFirstName(),userState));
        System.out.println("State Name: " + userState);
        for (Enumeration i = Statewisedict.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }
    /* Description - to search person by city name */
    public void searchPersonByCity()
    {
        System.out.println("Enter City name to search Person by city name");
        String userCity = scan.nextLine();
        Dictionary Citywisedict = new Hashtable();
        contactbook.stream().filter(map -> map.getCity().contains(userCity)).forEach(contactbook -> Citywisedict.put(contactbook.getFirstName(),userCity));
        System.out.println("City Name: " + userCity);
        for (Enumeration i = Citywisedict.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }
    /* Description - to count  person by city name */
    public void countByCity(){
        System.out.println(contactbook.stream().collect(Collectors.groupingBy((Contacts C) -> C.getCity())));
        System.out.println((contactbook.stream().collect(Collectors.groupingBy((Contacts C) -> C.getCity(),Collectors.counting()))));
    }

    /* Description - to count  person by state name */
    public void countByState(){
        System.out.println(contactbook.stream().collect(Collectors.groupingBy((Contacts C) ->C.getState(),Collectors.counting())));
    }


    public static void main(String[] args)
    {
        AddressBookMain address = new AddressBookMain();
        System.out.println("-------------Welcome To the ADDRESS_BOOK_MANAGEMENT_SYSTEM------------------");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Valid Option (1-->ENTER,2-->EXIT):");
        int option=sc.nextInt();
        while(option!=2) {
            System.out.println("\n *****Enter Your Choice*****\n1.Add Contact\t\t\t\t2.Edit Contact\n3.Display Contact\t\t\t4.Delete Contact\n" +
                                "5.Add New Address Book\t\t6.Display New Address Book\n7.Search Person By City\t\t8.Search Person By State" +
                                "\n9.Count by city\t\t\t\t10.Count by state");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    address.addContact();
                    break;
                case 2:
                    address.editPerson();
                    break;
                case 3:
                    address.displayPerson();
                    break;

                case 4:
                    address.deletePerson();
                    break;
                case 5:
                    address.newAddressBook();
                    break;
                case 6:
                    address.displayAddressBook();
                    break;
                case 7:
                    address.searchPersonByCity();
                    break;
                case 8:
                    address.searchPersonByState();
                    break;
                case 9:
                    address.countByCity();
                    break;
                case 10:
                    address.countByState();
                    break;
                default:
                    System.out.println("select valid operation[1/2]");

            }
            System.out.println("Enter choice(1-Enter \t\t 2-Exit):");
            int option1=sc.nextInt();
            if (option1==2)
            {
                System.out.println("OOPS!! you are choosing an Exit mode");
                break;
            }
        }
        System.out.println("THANKS FOR USING ADDRESS BOOK MANAGEMENT SYSTEM");
    }
}
