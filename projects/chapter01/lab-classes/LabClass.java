import java.util.*;

/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 */
public class LabClass
{
    private String instructor;
    private String room;
    private String timeAndDay;
    private ArrayList<Student> students;
    private int capacity;
    
    /**
     * Create a class with a maximum number of enrolments.
     * All other details are set to default values.
     */
    public LabClass(int maxNumberOfStudents)
    {
        room = "unknown";
        instructor = "unknown";
        timeAndDay = "unknown";
        capacity = maxNumberOfStudents;
        students = new ArrayList<Student>();
    }
    
    /**
     * Add a student.
     */
    public void enrollStudent(Student newStudent)
    {
        if (students.size() == capacity) {
            
            System.out.println(
                "The class is full, you cannot enroll.");
        } else {
            students.add(newStudent);
        }
    }
    
    /**
     * Return the number of students currently enrolled.
     */
    public int numberOfStudents()
    {
        return students.size();
    }
    
    /**
     * Set the room number.
     */
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }
    
    /**
     * Set the time for this LabClass.
     * @param timeAndDayString Should define the day and time. Ex: "Friday, 10am".
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }
    
    /**
     * Set the name of the instructor for this LabClass.
     */
    public void setInstructor(String instructorName)
    {
        instructor = instructorName;
    }
    
    /**
     * Print out a class list with details.
     */
    public void printList()
    {
        System.out.println("Lab class " + timeAndDay);
        System.out.println("Instructor: " + instructor);
        System.out.println("Room: " + room);
        
        System.out.println("Class list:");
        
        for (Student student : students) {
            student.print();
        }
        
        System.out.println(
            "Number of students: " + 
            numberOfStudents()
        );
    }
}
