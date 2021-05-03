import java.util.List;
import java.util.Random;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, and die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Rabbit
{
    // Characteristics shared by all rabbits (class variables).
    private static final int BREEDING_AGE = 5;
    private static final int MAX_AGE = 40;
    private static final double BREEDING_PROBABILITY = 0.12;
    private static final int MAX_LITTER_SIZE = 4;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    // Individual characteristics (instance fields).
    private int age;
    private boolean alive;
    // The rabbit's position.
    private Location location;
    // The field occupied.
    private Field field;

    /**
     * Create a new rabbit with age zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rabbit(boolean randomAge, Field field, Location location)
    {
        age = 0;
        alive = true;
        this.field = field;
        setLocation(location);
        
        if (randomAge) {
            age = rand.nextInt(MAX_AGE);
        }
    }
    
    /**
     * What the rabbit does: it runs around, and will sometimes breed or die of old age.
     * 
     * @param newRabbits A list to return newly born rabbits.
     */
    public void run(List<Rabbit> newRabbits)
    {
        incrementAge();
        
        if (alive) {
            giveBirth(newRabbits);            
            // Try to move into a free location.
            Location newLocation = field.freeAdjacentLocation(location);
            
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    /**
     * Check whether the rabbit is alive or not.
     * @return true if the rabbit is still alive.
     */
    public boolean isAlive()
    {
        return alive;
    }
    
    /**
     * Indicate the rabbit is no longer alive and remove it from the field.
     */
    public void setDead()
    {
        alive = false;
        
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    /**
     * @return The rabbit's location.
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the rabbit at the new location in the given field.
     * 
     * @param newLocation The rabbit's new location.
     */
    private void setLocation(Location newLocation)
    {
        if (location != null) {
            field.clear(location);
        }
        
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Increase the age.
     * This could result in the rabbit's death.
     */
    private void incrementAge()
    {
        age++;
        
        if (age > MAX_AGE) {
            setDead();
        }
    }
    
    /**
     * Check whether or not this rabbit is to give birth at this step.
     * New births will be made into free adjacent locations.
     * 
     * @param newRabbits A list to return newly born rabbits.
     */
    private void giveBirth(List<Rabbit> newRabbits)
    {
        // New rabbits are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = field.getFreeAdjacentLocations(location);
        int births = breed();
        
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            
            Rabbit young = new Rabbit(
                false, 
                field, 
                loc
            );
            
            newRabbits.add(young);
        }
    }
        
    /**
     * Generate a number representing the number of births, if it can breed.
     * 
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        int births = 0;
        
        if (canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
        }

        return births;
    }

    /**
     * A rabbit can breed if it has reached the breeding age.

     * @return true if the rabbit can breed, false otherwise.
     */
    private boolean canBreed()
    {
        return age >= BREEDING_AGE;
    }
}
