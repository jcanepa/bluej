public class Screen
{
    // instance variables - replace the example below with your own
    private int xRes;
    private int yRes;

    public Screen(int xRes, int yRes)
    {
        this.xRes = xRes;
        this.yRes = yRes;
    }

    public int numberOfPixels()
    {
        return xRes * yRes;
    }
    
    public void clear(boolean invert)
    {
        //
    }
}
