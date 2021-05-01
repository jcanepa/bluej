/**
 *  This class is the main class of the "Black Market Friday" application, a simple, 
 *  text based adventure game. Shoppers can walk around the map and interact with items.
 * 
 *  This main class initialises all others and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *  
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 * @author Julian Canepa
 * @version April 7, 2021
 */

public class Game 
{
    private Parser parser;
    private final Map store;
    private final Shopper shopper;
    private final MoveTracker tracker;
    
    /**
     * Initialize all the game components.
     */
    public Game()
    {
        store = new Map();
        parser = new Parser();
        tracker = new MoveTracker();
        shopper = new Shopper(store.getEntrance());
    }

    /**
     *  Enter the main command loop.
     *  Repeatedly reads and executes user commands until the game is over.
     */
    public void play()
    {            
        printWelcome();

        boolean finished = false;
        int moves = 0;

        while (! finished && moves < 99) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            moves = tracker.getMoves();
        }
        
        System.out.println("Game over! Thank you for playing.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Black Market Friday!");
        System.out.println();
        System.out.println("You are one of many shoppers hunting a store for discounted computers.");
        System.out.println("Search around to find items and take them to checkout to purchase, ");
        System.out.println("or wheel and deal with fellow shoppers to bolster your wallet.");
        System.out.println("Your goal is to make as much profit as you can by the time the store closes.");
        System.out.println();
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }
    
    /**
     * Print location info about the current room.
     */
    private void printLocationInfo()
    {
        System.out.println(
            shopper.getLocation()
                   .getLongDescription()
        );
    }

    /**
     * Execute a given command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
        
        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case SEARCH:
                search();
                break;
                
            case WALLET:
                wallet();
                break;
                
            case BACK:
                back();
                break;
                
            case TAKE:
                takeItem(command);
                break;
                
            case DROP:
                dropItem(command);
                break;
                
            case EQUIP:
                shopper.equipBeamer();
                break;
                
            case FIRE:
                shopper.fireBeamer();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        
        // The command wasn't recognized
        return wantToQuit;
    }

    /**
     * Print out some helpful information and available commands.
     */
    private void printHelp() 
    {
        System.out.println("Find a computer on the shelf and take it to checkout, or wheel and deal");
        System.out.println("with fellow shoppers to bolster your wallet as much as possible.");
        System.out.println("Your goal is to make as much profit as you can by the time the store closes.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.showCommands());
    }

    /** 
     * Try to move in a given direction.
     * If there is an exit, enter the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if (!command.hasSecondWord()) {
            System.out.println("Go where? Please provide a direction");
            return;
        }

        String direction = command.getSecondWord();

        move(direction);
    }
    
    /**
     * Try to leave the current room in a given direction.
     * @param A direction used to exit the current room.
     */
    private void move(String direction)
    {
        if (shopper.canExit(direction)) {

            shopper.move(direction);
            tracker.record(direction);
            printLocationInfo();

        } else {
            System.out.println("There is no door!");
        }
    }
    
    /**
     * Attempt to move back to the previous room.
     */
    private void back()
    {
        if (! tracker.isEmpty()) {

            shopper.move(tracker.getDirectionBack());
            printLocationInfo();

        } else {
            System.out.println(
                "You are at the beginning of your journey. Can't go back any further.");
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if (command.hasSecondWord()) {

            System.out.println("Quit what?");
            return false;
        }
        
        // signal that we want to quit
        return true;
    }
    
    /**
     * The "search" command was input.
     */
    private void search()
    {
        System.out.println(
            shopper.getLocation().getLongDescription());

        System.out.println(
            "Searching the shelves for a black friday special.");
    }
    
    /**
     * Print the amount of money the shopper has to spend.
     */
    private void wallet()
    {
        System.out.println(shopper.getWallet());
    }

    /**
     * Pick up an item in the room.
     */
    private void takeItem(Command command)
    {
        if (!command.hasSecondWord()) {
            System.out.println("Please include the item index.");
            return;
        }
        
        int index = Integer.parseInt(command.getSecondWord());
        boolean indexIsNumber = (index == (int) index);
        boolean indexIsValid = index < shopper.itemsOnShelf();
        
        if (indexIsNumber && indexIsValid) {
                        
            if (!shopper.hasExceededCartValueLimit()) {
                
                shopper.takeItem(index);
                System.out.println(shopper.getCartDetails());

            } else {
                System.out.println(
                    "Your cart has $" + shopper.getCartTotal() + " worth of goods "
                    + "while your wallet has only $" + shopper.getWallet() + ".\n"
                    + "It's probably best to only take what you're going to buy. " + "\n"
                    + "Try bargaining with other shoppers to be able to pick up more." + "\n"
                    + "I bet they'd be willing to pay for you to drop your finds!");
            }

        } else {
            System.out.println("Please provide a valid index value.");
        }
    }
    
    /**
     * Drop an item in the room.
     */
    private void dropItem(Command command)
    {
        if (!command.hasSecondWord()) {
            System.out.println("Please include the item index.");
            return;
        }
        
        int index = Integer.parseInt(command.getSecondWord());
        boolean indexIsNumber = (index == (int) index);
        boolean indexIsValid = index < shopper.itemsInCart();
        
        if (indexIsNumber && indexIsValid) {

            shopper.dropItem(index);
            System.out.println(shopper.getCartDetails());

        } else {
            System.out.println("Please provide a valid index value.");
        }
    }
}
