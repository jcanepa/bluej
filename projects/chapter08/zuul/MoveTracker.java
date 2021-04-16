import java.util.HashMap;
import java.util.Stack;

/**
 * Keep track of the the Shopper's move count and direction history.
 *
 * @author Julian Canepa
 * @version April 9, 2021
 */
public class MoveTracker
{
    private int moves;
    private Stack<String> history;
    private static final Compass compass = new Compass();
    
    public MoveTracker()
    {
        moves = 0;
        history = new Stack<String>();
    }
    
    /**
     * Record the reciprocal of a given direction.
     * Increment the move counter.
     */
    public void record(String direction)
    {
        moves ++;

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
    
    /**
     * Return the number of moves made by the player over the course of the game.
     */
    public int getMoves()
    {
        return moves;
    }
}