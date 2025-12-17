import java.time.Year;

public class Book {

    private int id;
    private static int idGen = 1;

    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book() {
        this.id = idGen++;
        this.available = true;
    }

    public Book(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("title must not be empty");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty())
            throw new IllegalArgumentException("author must not be empty");
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int current = Year.now().getValue();
        if (year < 1500 || year > current)
            throw new IllegalArgumentException("Invalid year");
        this.year = year;
    }

    public void markAsBorrowed() {
        if (!available)
            System.out.println("Book is already borrowed");
        else
            available = false;
    }

    public void markAsReturned() {
        if (available)
            System.out.println("Book is already returned");
        else
            available = true;
    }

    @Override
    public String toString() {
        return "Book{id=" + id +
                ", title='" + title +
                "', author='" + author +
                "', year=" + year +
                ", available=" + available +
                "}";
    }
}
