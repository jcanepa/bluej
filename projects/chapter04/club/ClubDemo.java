
/**
 * Provide a demonstration of the Club and Membership
 * classes.
 * 
 * @author Julian Canepa
 * @version Feb 12, 2021
 */
public class ClubDemo
{
    private Club club;

    /**
     * Constructor for objects of class ClubDemo
     */
    public ClubDemo()
    {
        club = new Club();
        demo();
    }

    /**
     * Add some members to the club, and then
     * show how many there are.
     * Further example calls could be added if more functionality
     * is added to the Club class.
     */
    public void demo()
    {
        club.join(new Member("David", 2, 2004));
        club.join(new Member("Michael", 1, 2004));
        System.out.println(
            "The club has "+ club.numberOfMembers() +" members."
        );
    }
}
