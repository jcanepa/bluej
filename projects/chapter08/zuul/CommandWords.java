/**
 * This class is part of the "Black Market Friday" application,
 * a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Julian Canepa
 * @version April 7, 2021
 */

public class CommandWords
{
    private static final String[] validCommands = {
        "go", "quit", "help", "search", "wallet", "back", "take", "drop"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        //
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String string)
    {
        for (int i = 0; i < validCommands.length; i++) {

            if (validCommands[i].equals(string)) return true;
        }
        
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Return a list of all valid commands.
     * @return a String of registered commands.
     */
    public String getList() 
    {
        String list = "";
        
        for (String command: validCommands) {
            list += command + " ";
        }

        return list;
    }
}
