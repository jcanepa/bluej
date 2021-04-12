/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Book
{
    private String author;
    private String title;
    private String refNumber;
    private int pages;
    private int borrowedCount;
    private Boolean isCourseText;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(
        String bookAuthor, 
        String bookTitle, 
        int bookPages, 
        Boolean bookIsCourseText)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = bookPages;
        refNumber = "";
        isCourseText = bookIsCourseText;
        borrowedCount = 0;
    }

    /**
     * Get the book's author.
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * Get the book's title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Get the book's pages.
     */
    public int getPages()
    {
        return pages;
    }
    
    /**
     * Get the book's reference number.
     */
    public String getRefNumber()
    {
        return refNumber;
    }
    
    /**
     * Get a count of how many times this book has been borrowed.
     */
    public int getBorrowedCount()
    {
        return borrowedCount;
    }

    /**
     * Print the book's author.
     */
    public void printAuthor()
    {
        System.out.println(author);
    }
    
    /**
     * Print the book's title.
     */
    public void printTitle()
    {
        System.out.println(title);
    }
    
    /**
     * Print the book's details.
     */
    public void printDetails()
    {
        String details = title + " by " + author;
        details += "\n";
        details += pages + " pages";
        details += "\n";
        details += "Reference #";
        
        if (refNumber.length() > 0) {
           details += refNumber;
        } else {
            details += "ZZZZ";
        }
        
        details += "Borrowed " + borrowedCount + " times";
        
        System.out.println(details);
    }
    
    /**
     * Set the book's reference number.
     */
    public void setRefNumber(String ref)
    {
        if (ref.length() >= 3) {
            refNumber = ref;
        } else {
            System.out.println(
                "Please provide a reference # longer than three characters"
            );
        }
    }
    
    /**
     * Increment the book's borrowed count.
     */
    public void borrow()
    {
        borrowedCount ++;
    }
    
    /**
     * Return whether the book is a course textbook.
     */
    public Boolean isCourseText()
    {
        return isCourseText;
    }
}
