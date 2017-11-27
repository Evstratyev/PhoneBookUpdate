import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Евген on 08.11.2017.
 */
public class ContactList {


    private Contact[] contacts = new Contact[1];
    private int contactCount = 0;

    public int getContactCount(){
        return contactCount;
    }

    public void add(Contact contact) {

        contactCount++;

        increaseArraySize();
        if (contacts[0] == null) {
            contacts[0] = contact;
        } else {
            contacts[contactCount - 1] = contact;
        }
    }

    public void addIndex(int index, Contact contact) {

        contactCount++;

        increaseArraySize();
        if (index < contactCount - 1 && index != 0) {
            System.arraycopy(contacts, index, contacts, index + 1, contacts.length - contactCount + 1);
            contacts[index] = contact;
        } else {
            contacts[contactCount - 1] = contact;
        }
        if (index == 0){
            System.arraycopy(contacts, index, contacts, index + 1, contactCount - 1);
            contacts[0] = contact;
        }
    }

    public void trimToSize() {
        float a = (float) (contactCount - 1) / contacts.length;
        if (a < 0.67 && contactCount != 0) {
            Contact[] temp = new Contact[contacts.length + 1 - contacts.length / contactCount];
            contacts = temp;
        }
    }

    public void increaseArraySize() {
        if (contactCount > contacts.length) {
            int newLength = contacts.length * 3 / 2 + 1;
            Contact[] temp = new Contact[newLength];
            System.arraycopy(contacts, 0, temp, 0, contacts.length);
            contacts = temp;                                            // копирование ССЫЛКИ а не ОБЪЕКТОВ
        }
    }

    public void remove(int removeContactIndex) {
        trimToSize();
        if (contactCount > 0) {
            System.arraycopy(contacts, removeContactIndex, contacts, removeContactIndex - 1, contacts.length - removeContactIndex);
            contacts[contactCount - 1] = null;
            contactCount--;
        } else {
            System.out.println("PhoneBook is empty");
        }
    }

    public int size() {
        return contacts.length;
    }

    public Contact get(int index) {
        return contacts[index];
    }

    public void showContacts(){
        Contact[] temp = contacts;

        for (int j = contactCount; j != 0; j--) {

            for (int i = 0; i < j - 1; i++) {

                if (get(i).getName().charAt(0) > get(i + 1).getName().charAt(0)) {

                    Contact[] buf = new Contact[1];
                    buf[0] = contacts[i];
                    contacts[i] = contacts[i+1];
                    contacts[i+1] = buf[0];
                }
            }
        }
    }
}
