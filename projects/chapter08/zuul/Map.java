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
                new Room("Audio"),
                new TransporterRoom(),
            },
            new Room[] {
                new Room("Batteries"),
                new Room("Bedroom"),
                new Room("Books"),
            },
            new Room[] {
                new Room("Checkout"),
                new Room("Camping"),
                new Room("Computers"),
            }
        };
        
        connectRooms();
        
        setEntrance(layout[2][0]);
        
        if (layout[0][2] instanceof TransporterRoom) {
            var transport = (TransporterRoom) layout[0][2];
            transport.setDestination(entrance);
        }
        
        addItems();
    }
    
    /**
     * Print the map.
     * @param description Details of the room including name and purpose.
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
     * Build exits between rooms on the map's layout.
     */
    private void connectRooms()
    {
        for (int row = 0; row < layout.length; row++) {

            for (int col = 0; col < layout[row].length; col++) {

                Room room = layout[row][col];

                /*
                 * Add a north exit to the room above
                 */
                if (!isOnNorthWall(room)) {

                    room.setExit(
                        "north", 
                        layout[row - 1][col]
                    );
                }

                /*
                 * Add an east exit to the room on the right.
                 */
                if (!isOnEastWall(room)) {

                    room.setExit(
                        "east", 
                        layout[row][col + 1]
                    );
                }

                /*
                 * Add a south exit to the room below.
                 */
                if (!isOnSouthWall(room)) {

                    room.setExit(
                        "south", 
                        layout[row + 1][col]
                    );
                }

                /*
                 * Add a west exit to the room to the left.
                 */
                if (!isOnWestWall(room)) {

                    room.setExit(
                        "west", 
                        layout[row][col - 1]
                    );
                }
            }
        }
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
    
    /**
     * Add various items around the map.
     */
    private void addItems()
    {
        // add items to the map
        entrance.addItem("Macbook", 1500);
        entrance.addItem("Macbook Pro", 2500);
        entrance.addItem("M1 Mac Mini", 1650);
        entrance.addItem("5k Monitor", 650);
        entrance.addItem("Thunderbolt cable", 25);
        
        // add gift cards to the room
        entrance.addItem("Gift card", -100);
        
    }
}