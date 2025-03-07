import java.util.ArrayList;
import java.util.HashSet;

/**
 * Describes a member of the library
 * @author m.droz
 */
public class Member extends Person implements IDisplayable
{
    public Member(String name, String address)
    {
        super(name, address);
    }

    private HashSet<Book> borrowedBooks = new HashSet<>();
    public ArrayList<Book> getBorrowedBooks() { return new ArrayList<>(borrowedBooks); }

    /**
     * Borrows a book from a borrow manager if that book is not already borrowed
     * @param borrowManager
     * @param book
     * @throws IllegalArgumentException in the case of a problem during borrow
     */
    public void borrowBook(IBorrowManager borrowManager, Book book) throws IllegalArgumentException
    {
        if (borrowedBooks.contains(book))
            throw new IllegalArgumentException("Member already borrowed this book");

        borrowManager.borrowBook(book, this);

        borrowedBooks.add(book);
    }

    /**
     * Returns a book to a borrow manager if that book is not already borrowed
     * @param borrowManager
     * @param book
     * @throws IllegalArgumentException in the case of a problem during return
     */
    public void returnBook(IBorrowManager borrowManager, Book book) throws IllegalArgumentException
    {
        if (borrowedBooks.contains(book) == false)
            throw new IllegalArgumentException("Member does not have this book");

        borrowManager.returnBook(book, this);

        borrowedBooks.remove(book);
    }

    /**
     * Displays the name and address of the member as well as the number of borrowed books and lists them
     */
    @Override
    public void displayDetails()
    {
        System.out.println("Member : " + getName() + ", address : " + getAddress() + ", borrowed books : " + borrowedBooks.size());

        for (Book book : borrowedBooks)
        {
            System.out.print("   - ");
            book.displayDetails();
        }
    }
}
