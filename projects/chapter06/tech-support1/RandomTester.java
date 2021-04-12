import java.util.Random;
import java.util.ArrayList;

public class RandomTester
{
    private Random generator;

    public RandomTester()
    {
        generator = new Random();
    }
    
    public void printOneRandom()
    {
        System.out.println(generator.nextInt(3));
    }
    
    public void printMultiRandom(int amount)
    {
        int i = 0;

        while (i < amount) {
            System.out.println(generator.nextInt(3));
            i ++;
        }
    }
    
    /**
     * Return a number between 1 and 6.
     */
    public int throwDie()
    {
        return generator.nextInt(6) + 1;
    }
    
    /**
     * Return a random response.
     */
    public String getResponse()
    {
        var responses = new ArrayList<String>(3);
        
        // seed the array with responses
        responses.add("yes");
        responses.add("no");
        responses.add("maybe");
        
        return responses.get(
            generator.nextInt(
                responses.size()
        ));
    }
    
    public int randomNumberUpTo(int max)
    {
        return randomNumberBetween(1, max);
    }
    
    /**
     * Return a random number within the given minimum and maximum.
     */
    public int randomNumberBetween(int min, int max)
    {
        return generator.nextInt(max) + min;
    }
}
