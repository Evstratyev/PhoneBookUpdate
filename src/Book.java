import java.util.Scanner;

/**
 * Created by Евген on 08.11.2017.
 */
public class Book {

    public static void main(String[] args) {

        ContactList newContactList = new ContactList();

        while (true) {

            System.out.println("Menu: " + "\n 1 - Add contact " + "\n 2 - Add contact by index" + "\n 3 - Show all" + "\n 4 - delete contact" + "\n 5 - Exit ");
            System.out.println("Contacts value: " + newContactList.getContactCount());
            System.out.println("Array length: " + newContactList.getSize());
            System.out.print("Choise option: ");
            //Scanner sc = new Scanner(System.in);
            //int option = sc.nextInt();

            String option = inputInformation();

            if (option == "1") {
                newContactList.add(recordContact());

            } else if (option == "2") {
                System.out.print("Enter index contact add: ");
                int index = Integer.parseInt(inputInformation());
                newContactList.addIndex(index, recordContact());

            } else if (option == "3") {
                for (int i = 0; i < newContactList.getContactCount(); i++) {
                        System.out.println(newContactList.get(i).toString());
                }

            } else if (option == "4") {
                System.out.print("Delete contact number: ");
                int removeTemp = Integer.parseInt(inputInformation());
                newContactList.remove(removeTemp);
            } else break;
        }
    }

    public static Contact recordContact() {         // не сразу понял что должно вернутся в ответ (получаю контакт),// думал что это просто меню
                                                    // почему Static ???
        Contact newContact = new Contact();

        System.out.print("Enter name: ");
        newContact.setName(inputInformation());
        System.out.print("Enter phone: ");
        newContact.setPhone(inputInformation());
        System.out.print("Enter e-mail: ");
        newContact.setEmail(inputInformation());

        return newContact;
    }

    public static String inputInformation(){
        Scanner sc = new Scanner(System.in);
            return sc.next();
        }
    }



