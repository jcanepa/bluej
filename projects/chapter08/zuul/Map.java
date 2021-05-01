import java.util.ArrayList;

/**
 * The map is responsible for the store's layout.
 * It builds all the rooms, defines their exits and the items they contain.
 * The map only supports a rectangle grid layouts with no empty roooms in between.
 *
 * @author Julian Canepa
 * @version April 9, 2021
 */
public class Map
{
    private Room entrance;
    private Room[][] layout;
    private TransporterRoom transporter;

    public Map()
    {       
        createRooms();
    }
    
    /**
     * Create all the rooms and link their exits together.
     * Place items around the map.
     */
    private void createRooms()
    {
        final var appliances = new Room("Appliances (north west)");
        final var athletics = new Room("Athletic clothing & sports (north center)");
        final var audio = new Room("Audio department (north east)");
        final var bedroom = new Room("Bedroom furnishings (mid west)");
        final var bath = new Room("Bathroom & fixures (mid center)");
        final var baby = new Room("Baby, children & toys (mid east)");
        final var checkout = new Room("The register queue. Ready to checkout?");
        final var camping = new Room("Camping supplies (south center)");
        final var computers = new Room("Computer and electronics (south east)");
        
        Room firedoor = new Room("Fire door is a one-way exit. You are locked out!");

        // initialise room's exits
        appliances.setExit("east", athletics);
        appliances.setExit("south", bedroom);
        
        athletics.setExit("east", audio);
        athletics.setExit("south", bath);
        athletics.setExit("west", appliances);
        athletics.setExit("north", firedoor);
        
        audio.setExit("south", baby);
        audio.setExit("west", athletics);
        
        bedroom.setExit("north", appliances);
        bedroom.setExit("east", bath);
        bedroom.setExit("south", checkout);
        
        bath.setExit("north", athletics);
        bath.setExit("east", baby);
        bath.setExit("south", camping);
        bath.setExit("west", bedroom);
        
        baby.setExit("north", audio);
        baby.setExit("south", computers);
        baby.setExit("west", bath);
        
        checkout.setExit("north", bedroom);
        checkout.setExit("east", camping);
        
        camping.setExit("north", bath);
        camping.setExit("east", computers);
        camping.setExit("west", checkout);
        
        computers.setExit("north", baby);
        computers.setExit("west", camping);
        
        // add items to the map
        checkout.addItem("Macbook", 1500);
        checkout.addItem("Macbook Pro", 2500);
        checkout.addItem("M1 Mac Mini", 1650);
        checkout.addItem("5k Monitor", 650);
        checkout.addItem("Thunderbolt cable", 25);
        
        // add gift cards to the room
        checkout.addItem("Gift card", -100);
        
        // create the store's departments and initialize their exits
        transporter = new TransporterRoom(checkout);
        transporter.setExit("south", audio);
        audio.setExit("north", transporter);
        
        entrance = checkout;
    }
    
    /**
     * Create a new room with a given description
     * @param description Details of the room including name and purpose.
     */
    private void createRoom(String description)
    {
        new Room(description);
    }

    /**
     * Set the entrance point of the store.
     */
    private void setEntrance(Room room)
    {
        entrance = room;
    }

    /**
     * Return the entrance point of the store.
     */
    public Room getEntrance()
    {
        return entrance;
    }
}