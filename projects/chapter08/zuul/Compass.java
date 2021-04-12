import java.util.HashMap;

/**
 * A static class that tracks map movement orientation.
 *
 * @author Julian Canepa
 * @version April 12, 2021
 */
public class Compass
{
    private static final HashMap<String, String> directions = new HashMap<>()
    {{
        put("north", "south");
        put("east", "west");
        put("south", "north");
        put("west", "east");
    }};
    
    public Compass()
    {
        //
    }
    
    /**
     * Return the opposite of a given direction.
     */
    public static String getReciprocal(String direction)
    {
        return directions.get(direction);
    }
}
