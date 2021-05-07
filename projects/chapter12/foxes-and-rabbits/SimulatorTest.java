import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SimulatorTest.
 *
 * @author Julian Canepa
 * @version May 4, 2021
 */
public class SimulatorTest
{
    private Simulator simulation;

    /**
     * Default constructor for test class SimulatorTest
     */
    public SimulatorTest()
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
        simulation = new Simulator();
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
    public void testAnimalListsMatchField()
    {
        simulation.simulateOneStep();
        
        // no animal (dead or alive) in the field that is not in one of the lists
        
        // no animal (dead or alive) in one of the lists that is not in the field
    }
}
