import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a rectangular field containing 
 * rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // Grid dimentions
    private static final int DEFAULT_WIDTH = 120;
    private static final int DEFAULT_DEPTH = 80;
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;

    // Lists of animals in the field.
    private List<Rabbit> rabbits;
    private List<Fox> foxes;
    private Field field;
    private int step;
    private SimulatorView view;
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(
            DEFAULT_DEPTH, 
            DEFAULT_WIDTH
        );
    }
    
    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width)
    {
        if (width <= 0 || depth <= 0) {
            
            System.out.println("The dimensions must be >= zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        
        rabbits = new ArrayList<>();
        foxes = new ArrayList<>();
        field = new Field(depth, width);

        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        view.setColor(Rabbit.class, Color.ORANGE);
        view.setColor(Fox.class, Color.BLUE);
        
        // Setup a valid starting point.
        reset();
    }
    
    /**
     * Run the simulation from its current state for a reasonably long period (4000 steps).
     */
    public void runLongSimulation()
    {
        simulate(4000);
    }
    
    /**
     * Run the simulation for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * 
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for (int step=1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
            //delay(60);
        }
    }
    
    /**
     * Run the simulation from its current state for a single step. Iterate
     * over the whole field updating the state of each fox and rabbit.
     */
    public void simulateOneStep()
    {
        step ++;

        // Provide space for newborn rabbits.
        List<Rabbit> newRabbits = new ArrayList<>();

        // Let all rabbits act.
        for (Iterator<Rabbit> it = rabbits.iterator(); it.hasNext(); ) {

            Rabbit rabbit = it.next();
            rabbit.run(newRabbits);
            
            if (! rabbit.isAlive()) {
                it.remove();
            }
        }
        
        // Provide space for newborn foxes.
        List<Fox> newFoxes = new ArrayList<>();

        // Let all foxes act.
        for (Iterator<Fox> it = foxes.iterator(); it.hasNext(); ) {
            
            Fox fox = it.next();
            fox.hunt(newFoxes);
            
            if (! fox.isAlive()) {
                it.remove();
            }
        }
        
        // Add the newly born foxes and rabbits to the main lists.
        rabbits.addAll(newRabbits);
        foxes.addAll(newFoxes);

        view.showStatus(step, field);
    }
    
    /**
     * Check field and animal lists match. That is,
     * no animal (dead or alive) in the field that is not in one of the lists
     */
    private boolean doesFieldMatchAnimalLists()
    {
        int rows = field.getWidth();
        int cols = field.getDepth();
        
        for (int row = 0; row < rows; row ++) {
            
            for (int col = 0; col < cols; col ++) {
                
                Object animal = field.getObjectAt(row, col);
                
                boolean match1 = foxes.contains(animal);
                boolean match2 = rabbits.contains(animal);
                
                if (animal != null & !(match1 || match2)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Check field and animal lists match. That is,
     * no animal (dead or alive) in one of the lists that is not in the field
     */
    private boolean doAnimalListsMatchField()
    {
        for (Fox fox : foxes) {
            if (fox != field.getObjectAt(fox.getLocation())) return false;
        }
        
        for (Rabbit rabbit : rabbits) {
            if (rabbit != field.getObjectAt(rabbit.getLocation())) return false;
        }
        
        return true;
    }
        
    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        step = 0;
        rabbits.clear();
        foxes.clear();
        populate();
        
        // Show the starting state in the view.
        view.showStatus(step, field);
    }
    
    /**
     * Randomly populate the field with foxes and rabbits.
     */
    private void populate()
    {
        Random rand = Randomizer.getRandom();
        field.clear();

        for (int row = 0; row < field.getDepth(); row++) {
            
            for (int col = 0; col < field.getWidth(); col++) {
                
                if (rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    
                    Location location = new Location(row, col);
                    Fox fox = new Fox(false, field, location);
                    foxes.add(fox);
                    
                } else if (rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(false, field, location);
                    rabbits.add(rabbit);
                }
                // else leave the location empty.
            }
        }
    }
    
    /**
     * Pause for a given time.
     * @param millisec  The time to pause for, in milliseconds
     */
    private void delay(int millisec)
    {
        try {
            Thread.sleep(millisec);
            
        } catch (InterruptedException ie) {
            // wake up
        }
    }
}
