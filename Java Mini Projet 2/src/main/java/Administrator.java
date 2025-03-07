/**
 * Describes an administrator who can interact with a library
 * @author m.droz
 */
public class Administrator extends Person implements IDisplayable
{
    public Administrator(String name, String address, Library library)
    {
        super(name, address);
        this.library = library;
    }

    private Library library;

    /**
     * Adds a book to the library
     * @param book
     */
    public void addBook(Book book) throws IllegalArgumentException
    {
        library.addBook(book);
    }

    /**
     * Removes a book from library
     * @param book
     */
    public void removeBook(Book book) throws IllegalArgumentException
    {
        library.deleteBook(book);
    }

    /**
     * Adds a member to the library
     * @param member
     */
    public void addMember(Member member) throws IllegalArgumentException
    {
        library.addMember(member);
    }

    /**
     * Removes a member from library
     * @param member
     */
    public void removeMember(Member member) throws IllegalArgumentException
    {
        library.removeMember(member);
    }

    /**
     * Displays the name and address of the administrator
     */
    @Override
    public void displayDetails()
    {
        System.out.println("Administrator : " + getName() + ", address : " + getAddress());
    }
}
