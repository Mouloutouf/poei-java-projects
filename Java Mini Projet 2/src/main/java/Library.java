import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Describes a library with members, books, and a collection of borrowed books
 * Allows users to add, remove, borrow, and return books
 * @author m.droz
 */
public class Library implements IBorrowManager
{
    private HashSet<Member> members = new HashSet<>();
    public ArrayList<Member> getMembers() { return new ArrayList<>(members); }

    private ArrayList<Book> books = new ArrayList<>();
    public ArrayList<Book> getBooks() { return books; }

    private HashMap<Book, Member> borrowedBooks = new HashMap<>();
    public HashMap<Book, Member> getBorrowedBooks() { return borrowedBooks; }

    /**
     * Adds a new book to the library
     * @param newBook
     */
    public void addBook(Book newBook)
    {
        books.add(newBook);
    }

    /**
     * Removes an existing book from library
     * @param book
     */
    public void deleteBook(Book book) throws IllegalArgumentException
    {
        if (books.contains(book) == false)
            throw new IllegalArgumentException("The given book does not exist in library");

        books.remove(book);
    }

    /**
     * Allows a member to borrow an existing book, making it unavailable
     * @param book
     * @param member
     */
    @Override
    public void borrowBook(Book book, Member member) throws IllegalArgumentException
    {
        if (book == null || member == null)
            throw new IllegalArgumentException("Cannot handle null references");

        if (members.contains(member) == false)
            throw new IllegalArgumentException("Member is not registered in library");

        if (books.contains(book) == false)
            throw new IllegalArgumentException("Selected book is not from the library");

        if (book.isAvailable() == false)
            throw new IllegalArgumentException("Selected book is unavailable");

        borrowedBooks.put(book, member);
        book.setAvailable(false);
    }

    /**
     * Allows a member to return an existing book, making it available again
     * @param book
     * @param member
     */
    @Override
    public void returnBook(Book book, Member member) throws IllegalArgumentException
    {
        if (book == null || member == null)
            throw new IllegalArgumentException("Cannot handle null references");

        if (members.contains(member) == false)
            throw new IllegalArgumentException("Member is not registered in library");

        if (books.contains(book) == false)
            throw new IllegalArgumentException("Selected book is not from the library");

        if (book.isAvailable() == true)
            throw new IllegalArgumentException("Book is already in library");

        borrowedBooks.remove(book);
        book.setAvailable(true);
    }

    /**
     * Finds a book by its title
     * @param title
     * @return the book if found otherwise null
     */
    public Book findBookByTitle(String title)
    {
        for (Book book : books)
        {
            if (book.getTitle() == title)
                return book;
        }

        System.out.println("Could not find book with title : " + title);
        return null;
    }

    /**
     * Finds books by their author
     * @param author
     * @return a list of books, will be empty if not books are found
     */
    public ArrayList<Book> findBooksByAuthor(String author)
    {
        ArrayList<Book> foundBooks = new ArrayList<>();

        for (Book book : books)
        {
            if (book.getAuthor() == author)
                foundBooks.add(book);
        }

        if (foundBooks.isEmpty())
            System.out.println("Could not find any books by author : " + author);

        return foundBooks;
    }

    /**
     * Adds a member to the library
     * @param member
     * @return
     */
    public boolean addMember(Member member) throws IllegalArgumentException
    {
        if (members.contains(member) == true)
            throw new IllegalArgumentException("Member already exists");

        members.add(member);
        return true;
    }

    /**
     * Removes a member from library
     * @param member
     * @return
     */
    public boolean removeMember(Member member) throws IllegalArgumentException
    {
        if (members.contains(member) == false)
            throw new IllegalArgumentException("Member does not exist");

        members.remove(member);
        return true;
    }

    public void clearBooks()
    {
        books.clear();
    }

    public void clearMembers()
    {
        members.clear();
    }
}
