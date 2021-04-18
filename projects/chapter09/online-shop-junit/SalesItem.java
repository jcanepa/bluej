import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class represents sales items on an online e-commerce site (such as Amazon.com).
 * Objects store all information relevant to this item, including name, price and customer comments
 * 
 * @author Julian Canepa
 * @version April 18, 2021
 */
public class SalesItem
{
    private final String name;
    private final int price;  // in cents
    private final ArrayList<Comment> comments;
    
    /**
     * Create a new sales item.
     */
    public SalesItem(String name, int price)
    {
        this.name = name;
        this.price = price;
        
        comments = new ArrayList<>();
    }

    /**
     * Return the name of this item.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the price of this item.
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Return the number of customer comments for this item.
     */
    public int getNumberOfComments()
    {
        return comments.size();
    }
    
    /**
     * Add a comment to the comment list of this sales item. Return true if successful;
     * false if the comment was rejected.
     * 
     * The comment will be rejected if the same author has already left a comment, or
     * if the rating is invalid. Valid ratings are numbers between 1 and 5 (inclusive).
     */
    public boolean addComment(String author, String text, int rating)
    {
        // reject invalid ratings
        if (ratingInvalid(rating)) {
            return false;
        }
        
        // reject mutiple comments by same author
        if (findCommentByAuthor(author) != null) {
            return false;
        }
        
        comments.add(
            new Comment(author, text, rating));

        return true;
    }
    
    /**
     * Remove the comment stored at the index given. If the index is invalid, do nothing.
     */
    public void removeComment(int index)
    {
        if (isIndexValid(index)) {
            comments.remove(index);
        }
    }
    
    /**
     * Upvote the comment at 'index'. That is: count this comment as more helpful.
     * If the index is invalid, do nothing.
     */
    public void upvoteComment(int index)
    {
        if (isIndexValid(index)) {
            comments.get(index).upvote();
        }
    }
    
    /**
     * Downvote the comment at 'index'. That is: count this comment as less helpful.
     * If the index is invalid, do nothing.
     */
    public void downvoteComment(int index)
    {
        if (isIndexValid(index)) {
            comments.get(index).downvote();
        }
    }
    
    private boolean isIndexValid(int index)
    {
        return index >= 0 && index < comments.size();
    }
    
    /**
     * Show all comments on screen.
     */
    public void showInfo()
    {
        System.out.println("*** " + name + " ***");
        System.out.println("Price: " + priceString(price));
        System.out.println();
        System.out.println("Customer comments:");
        
        for (Comment comment : comments) {
            System.out.println("-------------------------------------------");
            System.out.println(comment.getFullDetails());
        }

        System.out.println();
        System.out.println("===========================================");
    }
    
    /**
     * Return the most helpful comment. The most useful comment is the one with the highest vote
     * balance. If there are multiple comments with equal highest balance, return any one of
     * them.
     */
    public Comment findMostHelpfulComment()
    {
        Iterator<Comment> it = comments.iterator();
        Comment best = it.next();
        
        while (it.hasNext()) {
            Comment current = it.next();
            
            if (current.getVoteCount() > best.getVoteCount()) {
                best = current;
            }
        }
        
        return best;
    }
    
    /**
     * Check whether the given rating is invalid. Return true if it is invalid.
     * Valid ratings are in the range [1..5].
     */
    private boolean ratingInvalid(int rating)
    {
        return rating < 1 || rating > 5;
    }
    
    /**
     * Find the comment by the author with the given name.
     * 
     * @return The comment if it exists; null if it doesn't.
     */
    private Comment findCommentByAuthor(String author)
    {
        for (Comment comment : comments) {
            
            if (comment.getAuthor().equals(author)) {
                return comment;
            }
        }
        
        return null;
    }
    
    /**
     * For a given int, return a readable String representing the same price in whole cents.
     * For example given a price 12345, "$123.45" is returned.
     */
    private String priceString(int price)
    {
        int dollars = price / 100;
        int cents = price - (dollars*100);
        
        if (cents <= 9) {
            // include zero padding if necessary
            return "$" + dollars + ".0" + cents;
        } else {
            return "$" + dollars + "." + cents;
        }
    }
}