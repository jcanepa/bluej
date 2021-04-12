/**
 * The map is responsible for the store's layout.
 * It builds all the rooms, defines their exits and the items they contain.
 *
 * @author Julian Canepa
 * @version April 9, 2021
 */
public class Map
{
    private Room entrance;

    public Map()
    {
        createLayout();
    }
    
    /**
     * Create all the rooms and link their exits together.
     * Place items around the map.
     */
    private void createLayout()
    {
        // create the store's departments
        final Room appliances, athletics, audio;
        final Room bedroom, bath, baby;
        final Room checkout, camping, computers;
        
        appliances = new Room("Appliances (north west)");
        athletics = new Room("Athletic clothing & sports (north center)");
        audio = new Room("Audio department (north east)");
        bedroom = new Room("Bedroom furnishings (mid west)");
        bath = new Room("Bathroom & fixures (mid center)");
        baby = new Room("Baby, children & toys (mid east)");
        checkout = new Room("The register queue. Ready to checkout?");
        camping = new Room("Camping supplies (south center)");
        computers = new Room("Computer and electronics (south east)");

        // initialise room's exits
        appliances.setExit("east", athletics);
        appliances.setExit("south", bedroom);
        
        athletics.setExit("east", audio);
        athletics.setExit("south", bath);
        athletics.setExit("west", appliances);
        
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
        
        entrance = checkout;
    }

    /**
     * Return the entrance point of the store.
     */
    public Room getEntrance()
    {
        return entrance;
    }
}