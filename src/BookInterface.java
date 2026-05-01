import java.util.ArrayList;

public interface BookInterface {
    // default method which shows all the books
    default void displayBooks(ArrayList<Book> books){
        for(Book b: books){
            b.display(); //polymorphism
            System.out.println("_____________________________");
        }
    }
    //abstract method that returns the numbers of books per genre (abstraction)
    void numberBooksperGenre(ArrayList<Book> books);
    //abstract method that returns the total cost of all the books
    double getTotalCost(ArrayList<Book> books);



}
