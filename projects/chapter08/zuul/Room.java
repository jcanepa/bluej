import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * A room in an adventure game.
 *
 * This class is part of the "Black Market Friday" application,
 * a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author Julian Canepa
 * @version April 7, 2021
 */

public class Room 
{
    private final String description;
    private final HashMap<String, Room> exits;
    private final ArrayList<Item> items;

    /**
     * Create a room with a given description. Initially, it has no exits. 
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<Item>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Define the exits of this room.
     * Every direction either leads to another room or is null (no door).
     * 
     * @param north The north exit.
     * @param east The east exit.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west)
    {
        if (north != null) setExit("north", north);
        if (east != null) setExit("east", east);
        if (south != null) setExit("south", south);
        if (west != null) setExit("west", west);
    }

    /**
     * Return whether the room contains an item.
     */
    private boolean hasItems()
    {
        return items.size() > 0;
    }

    /**
     * Return the number of items in the room.
     */
    public int getItemCount()
    {
        return items.size();
    }
    
    /**
     * Place an item in the room.
     * @param name The item's name.
     * @param price The cost of the item in dollars.
     */
    public void addItem(String name, int price)
    {
        items.add(
            new Item(name, price)
        );
    }
    
    /**
     * Place an item in the room.
     * @param item The item to add.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }
    
    /**
     * Remove an item from the room.
     */
    public Item removeItem(int index)
    {
        return items.remove(index);
    }
    
    /**
     * Return a string listing all of the room's items.
     */
    private String getItemsList()
    {
       String list = ""; 
       
        for (int i = 0; i < items.size(); i++) {
            
            // [0] Item name $40
            list += "[" + i + "] " + items.get(i) + "\n";
        }
        
        return list;
    }
    
    /**
     * Return a string representation of the room's items
     * or an empty string if the room has none.
     */
    private String getItemsDescription()
    {
        return hasItems()
            ? "Items: " + "\n" + getItemsList()
            : "No items.";
    }
    
    /**
     * Return the room's description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Return a description of the room, it exits and contents.
     * @return A detailed description of this room
     */
    public String getLongDescription()
    {
        return "You are in " + description 
            + "\n" + getExitDirections()
            + "\n" + getItemsDescription();
    }

    /**
     * Return a string describing the room's available exit directions.
     * @return Details of the room's exits.
     */
    public String getExitDirections()
    {
        String output = "Exits:";
        
        for (String direction : exits.keySet()) {
            output += " " + direction;
        }

        return output;
    }

    /**
     * Return the room that is reached if we go from this room in the given direction.
     * If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Return whether the room has an exit in the given direction.
     */
    public boolean hasExit(String direction)
    {
        return getExit(direction) != null;
    }
    
    /**
     * @Override
     */
    public String toString()
    {
        return getDescription() + " (" + getExitDirections() + ")\n";
    }
}