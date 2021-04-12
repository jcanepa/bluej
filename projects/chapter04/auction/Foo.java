import java.util.Random;
import java.math.BigInteger;

public class Foo
{
    private Random r = new Random();

    public Foo()
    {
        //
    }
    
    public void fourteen()
    {
        int top;
        int k = r.nextInt(10);
        int m = r.nextInt(10);
        
        System.out.println("k: "+ k);
        System.out.println("m: "+ m);
        
        if (k > 0 && k > m) {
            top = k;
        } else {
            top = m;
        }
        
        System.out.println("Result is: "+ top);
    }
    
    public void fifteeen(String name, int age)
    {
        System.out.println(
            "Hello "+ name +", you are "+ age +" years old."
        );
    }

    /**
     * Demonstrate immutability of BigInteger objects.
     */
    public void sixteen()
    {        
        var bi = new java.math.BigInteger("256");
        bi.setBit(8);
        bi.clearBit(7);
        bi.shiftLeft(1);
        System.out.println(bi);
    }
}
