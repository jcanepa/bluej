

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The test class MoveTrackerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MoveTrackerTest
{
    private Compass compass;
    private MoveTracker tracker;

    /**
     * Default constructor for test class MoveTrackerTest
     */
    public MoveTrackerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        compass = new Compass();
        tracker = new MoveTracker();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void tracksMovement()
    {
        var moves = new ArrayList<String>(Arrays.asList(
            "north",
            "east",
            "north",
            "west",
            "south",
            "south",
            "east",
            "west",
            "east",
            "west"
        ));
        
        // Track the moves
        for (String move : moves) {
            tracker.record(move);
        }
        
        // Reverse moves taken and compare against the tracker
        for (int i = moves.size() - 1; i >= 0; i --) {

            String back = compass.getReciprocal(
                            moves.get(i));

            String last = tracker.getDirectionBack();
            
            assertTrue(
                last.equals(back)
            );
        }
    }
    
    @Test
    public void isEmptyAtInit()
    {
        assertTrue(tracker.isEmpty());
    }
    
    @Test
    public void isFinite()
    {
        tracker.record("north");
        
        assertFalse(
            tracker.isEmpty()
        );
        
        tracker.getDirectionBack();
        
        assertTrue(
            tracker.isEmpty()
        );
    }
}
