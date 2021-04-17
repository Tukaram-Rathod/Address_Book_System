package addressbook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome To The Address Book System");
        //Created object of Contact class
        Contacts contacts = new Contacts();
        contacts.AddContact();
    }
}
