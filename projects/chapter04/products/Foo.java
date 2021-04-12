public class Foo
{
    public Foo()
    {
        bar();
    }

    public void bar()
    {
        int iterations = 1;
        
        do {
            System.out.println(iterations);
            iterations ++;
        } while (iterations < 11);
    }
}
