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

    /**
     * Constructor for objects of class Cart
     */
    public Cart()
    {
        items = new ArrayList<Item>();
    }
    
    public int getItemCount()
    {
        return items.size();
    }
    
    public void addItem(Item item)
    {
        items.add(item);
    }
    
    public Item removeItem(int index)
    {
        return items.remove(index);
    }
    
    public Item getItem(int index)
    {
        return items.get(index);
    }
    
    public int getTotalPrice()
    {
        return items.stream()
                   .map(item -> item.getPrice())
                   .reduce(0, (total, price) -> {
                       return total + price;
                    });
    }
}
