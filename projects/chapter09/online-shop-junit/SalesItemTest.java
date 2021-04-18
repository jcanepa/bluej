import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    private SalesItem hammer;
    private SalesItem nail;

    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture. Called before every test case method.
     * Create two items and add two comments to the first.
     */
    @Before
    public void setUp()
    {
        hammer = new SalesItem("Hammer", 3000);
        nail = new SalesItem("Nails", 120);
        
        hammer.addComment("A", "Great hammer!", 5);
        hammer.addComment("B", "Sinks nails and pries nicely.", 4);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem item = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, item.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, item.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem item = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, item.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        String name = "Test";
        int price = 1000;
        
        SalesItem item = new SalesItem(name, price);
        
        assertEquals(name, item.getName());
        assertEquals(price, item.getPrice());
    }

    @Test
    public void addComment()
    {
        SalesItem item = new SalesItem("Brain Surgery for Dummies.", 9899);
        assertEquals(true, item.addComment("Fred", "Great - I perform brain surgery every week now!", 4));
    }

    /**
     * Test ratings outside the range of 1-5 are rejected.
     */
    @Test
    public void reviewsWithInvalidRatingsFail()
    {
        SalesItem item = new SalesItem("Sweater", 5000);
        
        assertEquals(
            false, 
            item.addComment("A", "Terrible", 0)
        );
        assertEquals(
            false, 
            item.addComment("Z", "Excellent", 6)
        );
    }

    /**
     * Only allows one comment per author per sales item.
     */
    @Test
    public void secondCommentByAuthorFails()
    {
        SalesItem item = new SalesItem("Book", 1000);
        item.addComment("J", "Good", 4);
        
        assertEquals(
            false, 
            item.addComment("J", "Bad", 1)
        );
    }
    
    public void mostHelpfulCommentReturned()
    {
        SalesItem item = new SalesItem("Wrench", 2000);
        
        item.addComment("A", "Nice", 4);
        Comment mostHelpful = item.findMostHelpfulComment();
        
        item.addComment("B", "Cool", 3);
        
        item.upvoteComment(0);
        item.upvoteComment(0);
        item.upvoteComment(1);
        
        assertEquals(
            mostHelpful,
            item.findMostHelpfulComment()
        );
    }
    
    public void commentCount()
    {
        assertEquals(
            hammer.getNumberOfComments(),
            2
        );
    }
    
    public void itemCreatedWithNoComments()
    {
        SalesItem item = new SalesItem("Knife", 1000);
        
        assertEquals(
            item.getNumberOfComments(),
            0
        );
    }
    
    public void itemGetNumberOfCommentsMatchesCount()
    {
        SalesItem item = new SalesItem("Shovel", 3900);
        
        int count = 3;
        
        for (int i = 0; i < count; i ++) {
            item.addComment(
                "" + i, 
                "Test", 
                i
            );
        }
        
        assertEquals(
            item.getNumberOfComments(),
            count
        );
    }
    
    public void itemUpvotesMatchUpvotes()
    {
        SalesItem item = new SalesItem("Bucket", 500);
        item.addComment("A", "This bucket leaks", 1);
        
        int upvotes = 6;
        int downvotes = 4;
        
        for (int i = 0; i < upvotes; i ++) {
            item.upvoteComment(0);
        }
        
        for (int i = 0; i < downvotes; i ++) {
            item.downvoteComment(0);
        }
        
        int votes = upvotes - downvotes;
        
        assertEquals(
            item.findMostHelpfulComment().getVoteCount(),
            votes
        );
    }
}




