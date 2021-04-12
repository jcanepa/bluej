import java.util.ArrayList;
import java.util.Collections;
    
public class FooBar
{
    private int value;
    private ArrayList<String> list;

    public FooBar()
    {
        init(10);
        seed();
    }

    private void init(int value)
    {
        this.value = value;
        list = new ArrayList<>();
    }

    private void seed()
    {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
    }

    public void shuffleItems()
    {
        Collections.shuffle(list);
    }

    public void getRandom()
    {
        var copy = new ArrayList<String>();

        for (String str : list) {
            copy.add(str);
    }

        var random = new java.util.Random();
        
        int index = copy.size() - 1;
        
        while (index > 0) {
            // do something with the random object.
            index -= 1;
        }
    }
    
    public void foo()
    {
        //
    }
}
