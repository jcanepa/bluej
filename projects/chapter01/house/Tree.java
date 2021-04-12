/**
 * This class models a fir tree.
 *
 * @author Julian Canepa
 * @date Feb 5, 2021
 */
public class Tree
{
    private Triangle leaves;
    private Square trunk;
    
    public Tree()
    {
        leaves = new Triangle();
        trunk = new Square();
        setup();
    }
    
    private void setup() {
        trunk.changeColor("black");
        trunk.changeSize(30);
        trunk.moveHorizontal(-115);
        trunk.makeVisible();
        
        leaves.moveVertical(-75);
        leaves.makeVisible();
    }
}