
/**
 * An animal is the base class for multiple species in a simulation.
 *
 * @author Julian Canepa
 * @version May 6, 2021
 */
public class Animal
{
    private boolean alive;
    private Location location;
    private Field field;

    /**
     * Constructor for objects of class Animal
     */
    public Animal(boolean randomAge, Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
    /**
     * Check whether the fox is alive or not.
     * @return True if the fox is still alive.
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Return the fox's location.
     * @return The fox's location.
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the fox at the new location in the given field.
     * @param newLocation The fox's new location.
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
     * @return the field.
     */
    protected Field getField()
    {
        return field;
    }
    
    /**
     * Indicate that the fox is no longer alive.
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
}
