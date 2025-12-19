public class Main {
    public static void main(String[] args) {

        System.out.println("=== TEST RECTANGLES ===");

        Rectangle r1 = new Rectangle();        
        Rectangle r2 = new Rectangle(4, 6);   

        System.out.println(r1);
        System.out.println("Area: " + r1.area());
        System.out.println("Perimeter: " + r1.perimeter());

        System.out.println();

        System.out.println(r2);
        System.out.println("Area: " + r2.area());
        System.out.println("Perimeter: " + r2.perimeter());


        System.out.println("=== TEST BOOK ===");

        Book b1 = new Book("Java Basics", "John Smith", 2020);

        System.out.println(b1);

        System.out.println("\nBorrowing book...");
        b1.markAsBorrowed();
        System.out.println(b1);

        System.out.println("\nReturning book...");
        b1.markAsReturned();
        System.out.println(b1);
    }
}

