import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store details of club members.
 * 
 * @author Julian Canepa
 * @version Feb 21, 2021
 */
public class Club
{
    private ArrayList<Member> members;
    
    public Club()
    {
        members = new ArrayList<Member>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Member member)
    {
        members.add(member);
    }

    /**
     * @return The number of members (Member objects) in the club.
     */
    public int numberOfMembers()
    {
        return members.size();
    }
    
    /**
     * Deturmine enrollment numbers of a given month.
     * 
     * @param month
     * @return The number of new members who enrolled in said month.
     */
    public int joinedInMonth(int month)
    {
        if (month < 1 || month > 12) {
            System.out.println("Invalid month provided. Enter a value from 1-12.");
            return 0;
        }
        
        int count = 0;
        
        for (Member member : members) {
            if (member.getMonth() == month) {
                count ++;
            }
        }

        return count;
    }
    
    /**
     * Remove members who enrolled in a given month and year.
     * Return them in a separate collection.
     * 
     * @param month
     * @param year
     * @return The members who have been removed.
     */
    public ArrayList<Member> purge(int month, int year)
    {
        if (month < 1 || month > 12) {
            System.out.println("Invalid month provided. Enter a value from 1-12.");
            return new ArrayList<Member>();
        }
        
        var retired = new ArrayList<Member>();
        Iterator<Member> it = members.iterator();
        
        while (it.hasNext()) {
            Member member = it.next();
            
            if (member.getMonth() == month && member.getYear() == year) {
                retired.add(member);
                it.remove();
            }
        }
        return retired;
    }
}
