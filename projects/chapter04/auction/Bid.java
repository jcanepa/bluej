/**
 * A class that models an auction bid.
 * It contains a reference to the Person bidding and the amount bid.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Bid
{
    private final Person bidder;
    private final long value;

    /**
     * Create a bid.
     * @param bidder Who is bidding for the lot.
     * @param value The value of the bid.
     */
    public Bid(Person bidder, long value)
    {
        this.bidder = bidder;
        this.value = value;
    }

    /**
     * Return the bidder.
     */
    public Person getBidder()
    {
        return bidder;
    }

    /**
     * Return the bid value.
     */
    public long getValue()
    {
        return value;
    }
}