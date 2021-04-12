import java.util.HashMap;

/**
 * This class tests capabilities of Java's HashMap construct.
 *
 * @author Julian Canepa
 * @version Feb 21, 2021
 */
public class MapTester
{
    protected HashMap<String, String> contacts;

    /**
     * Constructor for objects of class MapTester
     */
    public MapTester()
    {
        contacts = new HashMap<>();
    }
    
    public void enterNumber(String name, String phone)
    {
        contacts.put(name, phone);
    }
    
    /**
     * Get a given contact's phone number.
     * 
     * @return The number to which the given name is matched | null when the name contains no mapping.
     */
    public String lookupNumber(String name)
    {
        return contacts.get(name);
    }
    
    /**
     * Detuermine if the given name is a stored contact.
     */
    public boolean contactExists(String name)
    {
        return contacts.containsKey(name);
    }
    
    /**
     * Provide a Set view of all contacts.
     */
    public void printContactList()
    {
        System.out.println(contacts.keySet());
    }
}
