/**
 * An item available for purchase in the store.
 *
 * @author Julian Canepa
 * @version April 7, 2021
 */
public class Item
{
    private final String name;
    private final int price;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    /**
     * Return the item's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the item's purchase price in dollars.
     */
    public int getPrice()
    {
        return price;
    }
    
    @Override
    public String toString()
    {
        return name + " $" + price;
    }
}