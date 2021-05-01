
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CompassTest.
 *
 * @author Julian Canepa
 * @version April 26, 2021
 */
public class CompassTest
{
    /**
     * Default constructor for test class CompassTest
     */
    public CompassTest()
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
    public void knowsDirections()
    {
        final var compass = new Compass();
        
        assertEquals(
            compass.getReciprocal("north"),
            "south"
        );
        
        assertEquals(
            compass.getReciprocal("east"),
            "west"
        );
        
        assertEquals(
            compass.getReciprocal("south"),
            "north"
        );
        
        assertEquals(
            compass.getReciprocal("west"),
            "east"
        );
    }
}
