import java.util.ArrayList;

public class Main
{
    public Main()
    {
        //
    }
    
    /**
     * Interact with Location objects.
     */
    public void tester()
    {
        var f1 = new Location();
        var f2 = new Location(3, -9);
        
        f1.setA(8);
        f1.setB(8);
        
        int sum = f2.getA() + f2.getB();
        
        var survey = new ArrayList<Location>();
        
        System.out.println(f2);
    }
}
