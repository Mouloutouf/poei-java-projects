public interface IBorrowManager
{
    void borrowBook(Book book, Member member);

    void returnBook(Book book, Member member);
}
