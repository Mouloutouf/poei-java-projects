/**
 * Describes a book with a title, author, isbn, and availability
 * @author m.droz
 */
public class Book implements IDisplayable
{
    public Book(String title, String author, boolean available, int isbn)
    {
        this.title = title;
        this.author = author;
        this.available = available;
        this.isbn = isbn;
    }

    private String title;
    private String author;
    private boolean available;
    private int isbn;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }

    /**
     * Displays the relevant information about a book : title, author, and isbn
     */
    @Override
    public void displayDetails()
    {
        System.out.println("Book : " + title + ", by " + author + ", ISBN : " + isbn);
    }
}
