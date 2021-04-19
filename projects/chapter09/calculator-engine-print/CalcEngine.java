/**
 * The main part of the calculator doing the calculations.
 * This version incorporates debugging print statements. 
 * @author Hacker T. Largebrain (version 1.0)
 * @version 1.1
 */
public class CalcEngine
{
    // The value in the display.
    private int displayValue;
    // The previous operator typed (+ or -).
    private char previousOperator;
    // The left operand to previousOperator.
    private int leftOperand;

    /**
     * Create a CalcEngine instance.
     */
    public CalcEngine()
    {
        displayValue = 0;
        previousOperator = ' ';
        leftOperand = 0;
    }

    /**
     * Return the value currently displayed
     * on the calculator.
     */
    public int getDisplayValue()
    {
        return displayValue;
    }

    /**
     * A number button was pressed.
     */
    public void numberPressed(int number)
    {
        System.out.println("numberPressed(" + number + ")");
        
        displayValue = displayValue * 10 + number;
        
        reportState("end numberPressed");
    }

    /**
     * The '+' button was pressed. 
     */
    public void plus()
    {
        System.out.println("plus()");

        applyPreviousOperator();
        previousOperator = '+';
        displayValue = 0;

        reportState("end plus()");
    }

    /**
     * The '-' button was pressed.
     */
    public void minus()
    {
        System.out.println("minus()");
        
        applyPreviousOperator();
        previousOperator = '-';
        displayValue = 0;
        
        reportState("end minus()");
    }
    
    /**
     * The '=' button was pressed.
     */
    public void equals()
    {
        System.out.println("equals()");

        if (previousOperator == '+') {
            displayValue = leftOperand + displayValue;
        } else {
            displayValue = leftOperand - displayValue;
        }
        
        leftOperand = 0;
        
        reportState("end equals()");
    }

    /**
     * The 'C' (clear) button was pressed.
     */
    public void clear()
    {
        System.out.println("clear()");
        
        displayValue = 0;
        
        reportState("end clear()");
    }

    /**
     * Return the title of this calculation engine.
     */
    public String getTitle()
    {
        return "Super Calculator";
    }

    /**
     * Return the author of this engine.
     */
    public String getAuthor()
    {
        return "Hacker T. Largebrain";
    }

    /**
     * Return the version number of this engine.
     */
    public String getVersion()
    {
        return "version 0.2";
    }

    /**
     * Print the values of this object's fields.
     * @param where Where this state occurs.
     */
    public void reportState(String where)
    {
        System.out.println("displayValue: " + displayValue);
        System.out.println("leftOperand: " + leftOperand);
        System.out.println("previousOperator: " + previousOperator);
        System.out.println();
    }
    
    /**
     * An operator button has been pressed.
     * Apply the immediately preceding operator to
     * calculate an intermediate result. This will
     * form the left operand of the new operator.
     */
    private void applyPreviousOperator()
    {
        System.out.println("applyPreviousOperator called");
        
        if(previousOperator == '+') {
            leftOperand += displayValue;
        } else if(previousOperator == '-') {
            leftOperand -= displayValue;
        } else {
            // There was no preceding operator.
            leftOperand = displayValue;
        }
        
        reportState("end of applyPreviousOperator");
    }
}
