/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MailItem
{
    private String from;
    private String to;
    private String subject;
    private String message;

    /**
     * Create a mail item from sender to the given recipient,
     * containing the given message.
     * @param from The sender of this item.
     * @param to The intended recipient of this item.
     * @param message The text of the message to be sent.
     */
    public MailItem(String from, String to, String subject, String message)
    {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    /**
     * return the sender of this message.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * return The intended recipient of this message.
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return the content of the message.
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * return the subject of the message.
     */
    public String getSubject()
    {
        return message;
    }

    /**
     * Print this mail message to the text terminal.
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
