import java.util.ArrayList;

/**
 * This class stores information about a news feed post in a 
 * social network. Posts can be stored and displayed. This class
 * serves as a superclass for more specific post types.
 * 
 * @author Julian Canepa
 * @version April 25, 2021
 */
public class Post 
{
    private String username;  // username of the post's author
    private long timestamp;
    private int likes;

    /**
     * Constructor for objects of class Post.
     * 
     * @param author    The username of the author of this post.
     */
    public Post(String author)
    {
        likes = 0;
        username = author;
        timestamp = System.currentTimeMillis();
    }

    /**
     * Return the time of creation of this post.
     * 
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }
    
    /**
     * Return the author's username.
     * 
     * @return The post author's username.
     */
    protected String getUsername()
    {
        return username;
    }
    
    /**
     * Return the number of likes.
     */
    protected String getLikes()
    {
        String string = "";
        
        if (likes > 0) {
            string += likes + " people like this.";
        }
        
        return string;
    }

    /**
     * Display the details of this post.
     * Print to the text terminal to simulate display web browser.
     */
    public void display()
    {
        System.out.println(username);
        System.out.print(timeString(timestamp));
        System.out.println(getLikes());
    }
    
    /**
     * Create a string describing a time point in the past in terms 
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     * 
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */
    
    protected String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        
        if (minutes > 0) {
            return minutes + " minutes ago";
        } else {
            return seconds + " seconds ago";
        }
    }
    
    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes ++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if (likes > 0) {
            likes --;
        }
    }
    
    /**
     * Return a String of the class name, with a white space between non-leading capital letters.
     */
    public String getClassName()
    {
        return this.getClass()
                   .getSimpleName()
                   .replaceAll(
                       "(.)([A-Z])", 
                       "$1 $2");
    }
}
