import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * A shopper enters the store on Black Friday.
 *
 * @author Julian Canepa
 * @version April 7, 2021
 */
public class Shopper
{
    private int wallet;
    private Room location;
    private final Cart cart;
    
    // transporter beamer
    private Room origin;
    
    public Shopper(Room startingPosition)
    {
        wallet = 1200;
        cart = new Cart();
        setLocation(startingPosition);
    }
    
    /**
     * Return the amount of money the player has in their wallet.
     * @return Money the player has left to spend.
     */
    public int getWallet()
    {
        return wallet;
    }
    
    /**
     * Set the user's position.
     */
    public void setLocation(Room room)
    {
        location = room;
    }
    
    /**
     * Get the shopper's current location.
     */
    public Room getLocation()
    {
        return location;
    }
    
    /**
     * Move to the next room in a given direction.
     */
    public void move(String direction)
    {
        location = getLocation().getExit(direction);
    }
    
    /**
     * Determine whether the user can exit their location in a given direction.
     */
    public boolean canExit(String direction)
    {
        return location.hasExit(direction);
    }
    
    /**
     * Return the number of items in the cart.
     */
    public int itemsInCart()
    {
        return cart.getItemCount();
    }
    
    /**
     * Return whether there are items in the cart.
     */
    private boolean hasItems()
    {
        return itemsInCart() > 0;
    }
    
    /**
     * Return the number of items in the cart.
     */
    public int itemsOnShelf()
    {
        return location.getItemCount();
    }
    
    /**
     * Take the first item in the room and add it to the cart.
     */
    public void takeItem(int index)
    {
        cart.addItem(
            location.removeItem(
                index));
    }
    
    /**
     * Remove an item from the cart and place it in the current room.
     */
    public void dropItem(int index)
    {
        location.addItem(
            cart.removeItem(
                index));
    }
    
    /**
     * Print a list of the items in the cart.
     */
    private String getCartContents()
    {
       String list = ""; 
       
        for (int i = 0; i < cart.getItemCount(); i++) {
            
            // [0] Item name $40
            list += "[" + i + "] " + cart.getItem(i) + "\n";
        }
        
        return list;
    }
    
    /**
     * Return a string describing the cart's items.
     */
    public String getCartDetails()
    {
        return hasItems()
            ? "Items in cart: " + "\n" + getCartContents() + "Total cart value: $" + getCartTotal()
            : "Cart is empty.";
    }
    
    /**
     * Return the total price of all items in cart.
     */
    public int getCartTotal()
    {
        return cart.getTotalPrice();
    }
    
    /**
     * Determine if the cart's value is disproportionate to the shopper's budget.
     */
    public boolean hasExceededCartValueLimit()
    {
        return getCartTotal() > (2 * getWallet());
    }
    
    /**
     * Remeber where the beamer was equipped.
     */
    public void equipBeamer()
    {
        origin = location;
    }
    
    /**
     * Execute the beamer.
     */
    public void fireBeamer()
    {
        setLocation(origin);
    }
}