import java.util.List;
import java.util.Random;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, and die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public class Rabbit extends Animal
{
    private static final int MAX_AGE = 40;
    private static final int BREEDING_AGE = 5;
    private static final int MAX_LITTER_SIZE = 4;
    private static final double BREEDING_PROBABILITY = 0.12;

    /**
     * Create a new rabbit. 
     * A rabbit may be created as a new born or with a random age.
     * 
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rabbit(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        
        int age = (randomAge) 
            ? getRandomInt(MAX_AGE)
            : 0;

        setAge(age);
    }
    
    /**
     * This is what the rabbit does: 
     * it runs around and sometimes breeds or dies of old age.
     * 
     * @param newRabbits A list to return newly born rabbits.
     */
    public void act(List<Actor> newRabbits)
    {
        incrementAge();
        
        if (isAlive()) {
            
            giveBirth(newRabbits);
            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            
            if (newLocation != null) {
                
                setLocation(newLocation);
                
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    @Override
    protected int getBreedingAge() {
        return BREEDING_AGE;
    }
    
    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }
    
    @Override
    protected int getMaxLitterSize() {
        return MAX_LITTER_SIZE;
    }
    
    @Override
    protected double getBreedingProbability() {
        return BREEDING_PROBABILITY;
    }
    
    @Override
    protected Animal getNewAnimal() {
        return new Rabbit(
            false, 
            getField(), 
            getLocation());
    }
}
