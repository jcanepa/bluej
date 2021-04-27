
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Julian Canepa
 * @version April 25, 2021
 */
public class Student extends Participant
{
    // the student ID
    private String id;
    // the amount of credits for study taken so far
    private int credits;

    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        super(fullName);
        
        if (fullName.length() < 4) {
            System.out.println("Name too short to generate user ID.");
        }
        
        if (studentID.length() < 3) {
            System.out.println("Student ID is not of sufficient length.");
        }

        id = studentID;
        credits = 0;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID()
    {
        return id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        String login;
        
        boolean nameLengthIsValid = getName().length() >= 4;
        boolean idLengthIsValid = id.length() >= 3;
        
        if (nameLengthIsValid) {
            
            login = getName().substring(0,4);
        } else {
            
            login = getName();
        }
        
        if (idLengthIsValid) {
            
            return login + id.substring(0,3);
        }
        
        return login += id;
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(
            getName() + 
            ", student ID: " + id + 
            ", credits: " + credits
        );
    }
}
