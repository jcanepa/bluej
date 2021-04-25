/**
 * The main part of the calculator doing the calculations.
 * 
 * @author: Julian Canepa
 * @version April 18, 2021
 */
public class CalcEngine
{
    private int result;
    private char operator;
    private int operand;
    
    private static final char ADD = '+';
    private static final char SUB = '-';

    /**
     * Create a CalcEngine.
     */
    public CalcEngine()
    {
        operator = '\u0000'; // null
        operand = 0;
        result = 0;
    }

    /**
     * @return The value that should currently be displayed on the calculator display.
     */
    public int getDisplayValue()
    {
        return result;
    }

    /**
     * A number button was pressed.
     * Start a new operand, or incorporate this number as the least significant digit of an existing one.
     * @param number The number pressed on the calculator.
     */
    public void numberPressed(int number)
    {
        result = (result * 10) + number;
    }

    /**
     * The 'plus' button was pressed. 
     */
    public void plus()
    {
        operator = '+';
        operand += result;
        result = 0;
    }

    /**
     * The 'minus' button was pressed.
     */
    public void minus()
    {
    }

    /**
     * The '=' button was pressed.
     */
    public void equals()
    {
        switch (operator) {
            case ADD:
                result = operand + result;
                break;
            case SUB:
                result = operand - result;
                break;
        }
        
        operand = 0;
    }

    /**
     * The 'C' (clear) button was pressed.
     * Reset class fields to their initial values.
     */
    public void clear()
    {
    }

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "";
    }

    /**
     * @return The author of this engine. This string is displayed as it is,
     * so it should say something like "Written by H. Simpson".
     */
    public String getAuthor()
    {
        return "";
    }

    /**
     * @return The version number of this engine. This string is displayed as 
     * it is, so it should say something like "Version 1.1".
     */
    public String getVersion()
    {
        return "";
    }
}
