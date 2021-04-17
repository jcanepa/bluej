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

    public Map()
    {
        layout = new Room[][] {
            new Room[] {
                new Room("Appliances"),
                new Room("Athletic"),
                new Room("Audio"),
            },
            new Room[] {
                new Room("Bedroom"),
                new Room("Bathroom"),
                new Room("Baby"),
            },
            new Room[] {
                new Room("Checkout"),
                new Room("Camping"),
                new Room("Computer"),
            }
        };
        
        connectRooms();
        
        setEntrance(layout[2][0]);
        
        // add items to various rooms
    }
    
    /**
     * Build exits between rooms.
     */
    private void connectRooms()
    {
        for (int row = 0; row < layout.length; row++) {
            
            for (int col = 0; col < layout[row].length; col++) {
                
                Room room = layout[row][col];
                
                /*
                 * north exit
                 */
                if (!isOnNorthWall(room)) {
                    
                    // add an exit to the room above
                    room.setExit(
                        "north", 
                        layout[row - 1][col]
                    );
                }

                /*
                 * east exit
                 */
                if (!isOnEastWall(room)) {
                    
                    // add an exit to the room below
                    room.setExit(
                        "east", 
                        layout[row][col + 1]
                    );
                }
                
                /*
                 * south exit
                 */
                if (!isOnSouthWall(room)) {
                    
                    // add an exit to the room below
                    room.setExit(
                        "south", 
                        layout[row + 1][col]
                    );
                }
                
                /*
                 * west exit
                 */
                if (!isOnWestWall(room)) {
                    
                    // add an exit to the room below
                    room.setExit(
                        "west", 
                        layout[row][col - 1]
                    );
                }
            }
        }
    }
    
    /**
     * Print the map.
     */
    public void printLayout()
    {
        for (Room[] row : layout) {

            for (Room room : row) {
                System.out.print(room);
            }

            System.out.println();
        }
    }
    /**
     * Create all the rooms and link their exits together.
     * Place items around the map.
     */
    private void createRooms()
    {
        // create the store's departments and initialize their exits
        final var transporter = new TransporterRoom();
        
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
        
        entrance = checkout;
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
    
    /**
     * Deturmine if a given room is in the first row.
     */
    private boolean isOnNorthWall(Room room)
    {
        for (Room northRoom : layout[0]) {
            if (northRoom == room) {
                return true;
            }
        }

        return false;
    }

        /**
     * Deturmine if a given room is in the last row.
     */
    private boolean isOnSouthWall(Room room)
    {
        for (Room southRoom : layout[2]) {
            if (southRoom == room) {
                return true;
            }
        }

        return false;
    }
    
        /**
     * Deturmine if a given room is in the first row.
     */
    private boolean isOnEastWall(Room room)
    {
        for (int i = 0; i < 3; i++) {
            if (layout[i][2] == room) {
                return true;
            }
        }

        return false;
    }
    
        /**
     * Deturmine if a given room is in the first row.
     */
    private boolean isOnWestWall(Room room)
    {
        for (int i = 0; i < 3; i++) {
            if (layout[i][0] == room) {
                return true;
            }
        }

        return false;
    }
}