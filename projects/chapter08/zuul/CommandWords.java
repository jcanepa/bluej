import java.util.HashMap;

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
    // A mapping between a command word and the CommandWord associated with it.
    private HashMap<String, CommandWord> validCommands;

    public CommandWords()
    {
        validCommands = new HashMap<>();

        for (CommandWord command : CommandWord.values()) {
            
            if (command != CommandWord.UNKNOWN) {
                
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Find the CommandWord associated with a command word.
     * 
     * @param commandWord The word to look up
     * @return The CommandWord correspondng to commandWord | UNKNOWN if not valid
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);

        if (command != null) {

            return command;

        } else {
            
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String string)
    {
        return validCommands.containsKey(string);
    }

    /**
     * Print all valid commands to System.out.
     */
    public String showAll() 
    {
        String commands = "";
        
        for (String command : validCommands.keySet()) {

            commands += command + "  ";
        }
        
        return commands;
    }
}
