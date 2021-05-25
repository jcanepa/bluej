import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;
import java.util.List;

/**
 * Write a description of class PopulationGenerator here.
 *
 * @author Julian Canepa
 * @version
 */
public class PopulationGenerator
{
    // The probability that a given animal will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;
    
    private Field field;
    
    /**
     * Constructor for objects of class PopulationGenerator
     */
    public PopulationGenerator(Field field)
    {
        this.field = field;
    }
    
    public Class getPredator()
    {
        return Fox.class;
    }
    
    public Class getPrey()
    {
        return Rabbit.class;
    }
    
    public List<Animal> create()
    {
        Random rand = Randomizer.getRandom();
        var progeny = new ArrayList<Animal>();
        
        for (int row = 0; row < field.getDepth(); row++) {
            
            for (int col = 0; col < field.getWidth(); col++) {
                
                if (rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    progeny.add(fox);
                    
                } else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    progeny.add(rabbit);
                }
                // else leave the location empty.
            }
        }
        
        return progeny;
    }
}
