import java.util.ArrayList;

/**
 * The cart belongs to a user and holds items.
 *
 * @author Julian Canepa
 * @version April 12, 2021
 */
public class Cart
{
    private final ArrayList<Item> items;

    public Cart()
    {
        items = new ArrayList<Item>();
    }
    
    /**
     * Return the number of items in the cart.
     */
    public int getItemCount()
    {
        return items.size();
    }
    
    /**
     * Add an item to the cart.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }
    
    /**
     * Remove an item from the cart at a given index.
     * Return the item that was removed.
     */
    public Item removeItem(int index)
    {
        return items.remove(index);
    }
    
    /**
     * Get the item at a given  index.
     */
    public Item getItem(int index)
    {
        return items.get(index);
    }
    
    /**
     * Return the sum total of cart items.
     */
    public int getTotalPrice()
    {
        return items.stream()
                   .map(item -> item.getPrice())
                   .reduce(0, (total, price) -> {
                       return total + price;
                    });
    }
}
