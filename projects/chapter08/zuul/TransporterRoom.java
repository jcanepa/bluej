
/**
 * A transporting room.
 *
 * @author Julian Canepa
 * @version April 15, 2021
 */
public class TransporterRoom extends Room
{
    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom()
    {
        super("Transporter");
    }

    /**
     * @Override
     * Return a random room independent of the direction parameter.
     * 
     * @param direction Ignored.
     * @return A random room.
     */
    public Room getExit(String direction)
    {
        return Map.getRandomRoom();
    }
    
    /**
     * Transporter rooms don't support normal exits.
     */
    @Override public void setExit(String direction, Room neighbor) {}
    @Override public void setExits(Room north, Room east, Room south, Room west) {}
    @Override public String getExitDirections() 
    {
        return "A great mystery.";
    }
}
