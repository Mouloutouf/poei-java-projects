import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLibrary
{
    public static Library library;
    public static Administrator admin;

    /**
     * Initializes a library and administrator to interact with it
     */
    @BeforeAll
    public static void initLibrary()
    {
        library = new Library();
        admin = new Administrator("Maxence", "Paris", library);
    }

    /**
     * Clears all the books and members of the library
     */
    @BeforeEach
    public void resetLibrary()
    {
        library.clearBooks();
        library.clearMembers();
    }

    /**
     * Checks if a member is added to the library
     */
    @Test
    public void testAddMember()
    {
        admin.addMember(new Member("Alice", "Montpellier"));

        Assertions.assertEquals(1, library.getMembers().size());
    }

    /**
     * Checks if a member is removed from library
     */
    @Test
    public void testRemoveMember()
    {
        Member member = new Member("Max", "Stockholm");
        admin.addMember(member);
        admin.removeMember(member);

        Assertions.assertEquals(0, library.getMembers().size());
    }

    /**
     * Checks if an exception is thrown if we try to remove a member that is not registered in library
     */
    @Test
    public void testWrongRemoveMember()
    {
        admin.addMember(new Member("John", "London"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> admin.removeMember(new Member("None", "Nowhere")));
    }

    /**
     * Checks if a book is added to library
     */
    @Test
    public void testAddBook()
    {
        admin.addBook(new Book("Les Misérables", "Victor Hugo", true, 1));

        Assertions.assertEquals(1, library.getBooks().size());
    }

    /**
     * Checks if a book is removed from library
     */
    @Test
    public void testRemoveBook()
    {
        Book book = new Book("Les Misérables", "Victor Hugo", true, 1);
        admin.addBook(book);
        admin.removeBook(book);

        Assertions.assertEquals(0, library.getBooks().size());
    }

    /**
     * Checks if a book can be borrowed by a member
     */
    @Test
    public void testBorrowBook()
    {
        Member member = new Member("John", "London");
        admin.addMember(member);
        Book book = new Book("Les Misérables", "Victor Hugo", true, 1);
        admin.addBook(book);

        Assertions.assertDoesNotThrow(() -> member.borrowBook(library, book));
    }

    /**
     * Checks if a borrowed book can be returned by its member
     */
    @Test
    public void testReturnBook()
    {
        Member member = new Member("John", "London");
        admin.addMember(member);
        Book book = new Book("Les Misérables", "Victor Hugo", true, 1);
        admin.addBook(book);
        member.borrowBook(library, book);

        Assertions.assertDoesNotThrow(() -> member.returnBook(library, book));
    }

    /**
     * Checks if an exception is thrown if we try to borrow a book that does not exist in library
     */
    @Test
    public void testWrongBorrowBook()
    {
        Member member = new Member("John", "London");
        admin.addMember(member);
        Book book = new Book("Les Misérables", "Victor Hugo", true, 1);
        admin.addBook(book);

        Assertions.assertThrows(IllegalArgumentException.class, () -> member.borrowBook(library, new Book("Test", "Wrong", true, 1)));
    }

    /**
     * Checks if an exception is thrown if we try to return a book that is not borrowed by member
     */
    @Test
    public void testWrongReturnBook()
    {
        Member member = new Member("John", "London");
        admin.addMember(member);
        Book book = new Book("Les Misérables", "Victor Hugo", true, 1);
        admin.addBook(book);

        Assertions.assertThrows(IllegalArgumentException.class, () -> member.returnBook(library, new Book("Test", "Wrong", true, 1)));
    }
}
