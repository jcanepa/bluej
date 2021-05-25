import java.util.List;
import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public abstract class Animal extends Actor
{
    private int age;
    private boolean alive;
    private Field field;
    private Location location;
    
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        age = 0;
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
    /**
     * Return the maximum age of animal's lifespan.
     */
    abstract protected int getMaxAge();
    
    /**
     * Return the animal's breeding age.
     */
    abstract protected int getBreedingAge();
    
    /**
     * Return the likelyhood that the animal will breed.
     */
    abstract protected double getBreedingProbability();
    
    /**
     * Return the maximum young the animal can bear per litter.
     */
    abstract protected int getMaxLitterSize();
    
    /**
     * Return a new member of the animal species.
     */
    abstract protected Actor getNewAnimal();
    
    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }
    
    /**
     * Active status for animals is based on life.
     */
    @Override
    public boolean isActive()
    {
        return isAlive();
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if (location != null) {
            field.clear(location);
        }
        
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
    
    /**
     * @return the age of the animal.
     */
    protected int getAge()
    {
        return age;
    }
    
    /**
     * Set the animal's age.
     */
    protected void setAge(int age)
    {
        this.age = age;
    }

    /**
     * Increase the age. This could result in the fox's death.
     */
    protected void incrementAge()
    {
        age ++;
        
        if (getAge() > getMaxAge()) {
            setDead();
        }
    }
 
    /**
     * A fox can breed if it has reached the breeding age.
     */
    protected boolean canBreed()
    {
        return getAge() >= getBreedingAge();
    }
    
    protected int getRandomInt(int bound)
    {
        return rand.nextInt(bound);
    }
    
    /**
     * Generate a number representing the number of births, if it can breed.
     * @return The number of births.
     */
    protected int breed()
    {
        int births = 0;
        
        if (canBreed() 
            && rand.nextDouble() <= getBreedingProbability()) {
            
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        
        return births;
    }
    
    /**
     * Check whether or not this animal is able to give birth at this step.
     * New births will be made into free adjacent locations.
     * 
     * @param newborns A list to return newly born animals.
     */
    protected void giveBirth(List<Actor> newborns)
    {
        // Get a list of adjacent free locations.
        List<Location> free = field.getFreeAdjacentLocations(
                                        getLocation());
        int births = breed();
        
        for (int b = 0; b < births && free.size() > 0; b++) {
            
            Location loc = free.remove(0);
            newborns.add(getNewAnimal());
        }
    }
}
