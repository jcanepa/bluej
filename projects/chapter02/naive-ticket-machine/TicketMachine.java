/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TicketMachine
{
    /*
     * cost of a ticket
     */
    private int price;
    /*
     * amount of money input by the current user
     */
    private int paid;
    /*
     * total amount of money collected by this machine
     */
    private int total;


    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine()
    {
        price = 1000;
        paid = 0;
        total = 0;
    }
    
    public TicketMachine(int amount)
    {
        price = amount;
        paid = 0;
        total = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return the amount owed.
     */
    public int getBalance()
    {
        return price - paid;
    }
    
    /**
     * Return the amount paid.
     */
    public int getPaid()
    {
        return paid;
    }
    
    /**
     * Return the total amount collected in lifetime of machine.
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * Set the ticket price.
     */
    public void setPrice(int cost)
    {
        price = cost;
    }
    
    public void prompt()
    {
        System.out.println("Please insert the correct amount of money.");
    }
    
    /**
     * Print the single ticket price.
     */
    public void showPrice()
    {
        System.out.println("The price of a ticket is "+ price);
    }
    
    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount)
    {
        paid += amount;
    }

    /**
     * Reduce the price by a given amount.
     */
    public void discount(int amount)
    {
        if (amount < price) {
            price -= amount;
        }
    }
    
    /**
     * Reset the total amount collected to zero.
     */
    public void empty()
    {
        total = 0;
    }
    
    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        boolean customerHasPaid = paid >= price;
        
        if (!customerHasPaid) {
            System.out.println("# Please pay " + getBalance() + " for ticket.");
            System.out.println();
            return;
        }
        
        if (paid > price) {
            int change = paid - price;
            paid = price;
            System.out.println("Your change is "+ change +" cents.");
        }

        // Simulate the printing of a ticket.
        System.out.println();
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents tendered");
        System.out.println("##################");
        System.out.println();

        // Update the total collected with the balance.
        total += paid;

        // Clear the balance.
        paid = 0;
    }
}
