import java.util.Random;
import java.util.ArrayList;

/**
 * The responder class generates an automatic response to an input string.
 * 
 * @author Julian Canepa
 * @version 0.2 (Feb 21, 2021)
 */
public class Responder
{
    private ArrayList<String> responses;
    private static final Random generator = new Random();

    public Responder()
    {
        responses = new ArrayList<String>();
        seedResponses();
    }

    /**
     * Generate a response.
     */
    public String generateResponse()
    {        
        return responses.get(
            generator.nextInt(
                responses.size()
        ));
    }
    
    /**
     * Supply possible responses.
     */
    protected void seedResponses()
    {
        responses.add("That's odd, can you go into a little more detail?");
        responses.add("That sounds like a browser issue, what is your configuration?");
        responses.add("I need more information.");
        responses.add("This is covererd in the manual, have you read the manual?");
        responses.add("This is a known issue, your patience is appreciated.");
        responses.add("This isn't a bug, it's a feaature of the app.");
    }
}
