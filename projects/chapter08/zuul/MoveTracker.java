import java.util.HashMap;
import java.util.Stack;

/**
 * Keep track of the the Shopper's move history.
 *
 * @author Julian Canepa
 * @version April 9, 2021
 */
public class MoveTracker
{
    private Stack<String> history;
    private static final Compass compass = new Compass();
    
    public MoveTracker()
    {
        history = new Stack<String>();
    }
    
    /**
     * Record the reciprocal of a given direction.
     */
    public void record(String direction)
    {
        history.push(
            compass.getReciprocal(direction));
    }
    
    /**
     * Return the last move's opposite direction.
     */
    public String getDirectionBack()
    {
        return history.pop();
    }
    
    /**
     * Return whether the user can go back any further.
     */
    public boolean isEmpty()
    {
        return history.empty();
    }
}