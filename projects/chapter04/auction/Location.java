/**
 * Midterm exam, question seventeen.
 * 
 * @author Julian Canepa
 * @version Feb 13, 2021
 */
public class Location
{
    private int a;
    private int b;

    public Location()
    {
        a = 0;
        b = 0;
    }
    
    /**
     * Initialize a new instance given values a and b.
     */
    public Location(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    
    /**
     * @return The value of a.
     */
    public int getA()
    {
        return a;
    }
    
    /**
     * @return The value of b.
     */
    public int getB()
    {
        return b;
    }
    
    /**
     * Set the value of a to a given integer.
     */
    public void setA(int newValue)
    {
        a = newValue;
    }
    
    /**
     * Set the value of b to a given integer.
     */
    public void setB(int newValue)
    {
        b = newValue;
    }
    
    /**
     * @return A String representing the state of object fields.
     */
    public String toString()
    {
        return "a is " + a + ", b is "+ b;
    }
}
