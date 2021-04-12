import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Auction
{
    private ArrayList<Lot> lots;
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber ++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    /**
     * Make a bid for a lot.
     * Prints output indicating whether the bid is successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);

        if(selectedLot != null) {
            boolean isHighestBid = selectedLot.bidFor(new Bid(bidder, value));

            if(isHighestBid) {
                System.out.println("The bid for lot  "+ lotNumber + " accepted.");
            } else {
                Bid highestBid = selectedLot.getHighestBid();

                System.out.println(
                    "Lot number: " + 
                    lotNumber +" has a high bid of: "+ 
                    highestBid.getValue()
                );
            }
        }
    }

    /**
     * Return the lot with the given number.
     * Return null if the lot number does not exist.
     * 
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        if((lotNumber > 0) && (lotNumber < nextLotNumber)) {

            int index = 0;
            boolean lotNumberFound = false;
            
            while (!lotNumberFound && (index < lots.size())) {
                if (lots.get(index).getNumber() == lotNumber) {
                    lotNumberFound = true;
                    return lots.get(index);
                }
                index ++;
            }
            return null;
        }
        else {
             System.out.println("Lot " + lotNumber +" does not exist.");
             return null;
        }
    }
    
    /**
     * Close the auction and deturmine each lot's winning bidder.
     */
    public void close()
    {
        for (Lot lot : lots) {
            Bid bid = lot.getHighestBid();

            if (bid == null) {
                System.out.println(
                    lot.getNumber() +": "+ 
                    lot.getDescription() +" (no bids)"
                );
            } else {
                System.out.println(
                    lot.getNumber() +": "+ 
                    lot.getDescription() +" sold for " +
                    bid.getValue() +" to "+
                    bid.getBidder().getName()
                );
            }
        }
    }
    
    /**
     * @return all the unsold lots.
     */
    public ArrayList<Lot> getUnsold()
    {
        var unsold = new ArrayList<Lot>();
        
        for (Lot lot : lots) {
            if (lot.getHighestBid() == null) {
                unsold.add(lot);
            }
        }
        return unsold;
    }
    
    /**
     * Remove the lot with the given lot number.
     * @param number The number of the lot to be removed.
     * @return Lot | null
     */
    public Lot removeLot(int number)
    {
        Lot lot = getLot(number);
        
        if (lot == null) {
            return lot;
        }
        
        int index = lots.indexOf(lot);
        lots.remove(index);
        
        return lot;
    }
}
