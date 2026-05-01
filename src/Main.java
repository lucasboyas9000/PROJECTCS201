import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    //prints out the menu for the program
    private static void printActions(){
        String menu= """
                ===== BOOK SYSTEM =====
                1 - Add Book
                2 - Search
                3- Display All
                4- Statistics
                5 - Sort Books
                6 - Save
                7 - Load
                0 - Exit
                _________________________
                Enter a number for which actions you want to do:
                """;
        System.out.print(menu + " ");
    }
    //sorts out the books alphabetically by title
    private static void sortBooks(ArrayList<Book> books){
        books.sort((b1,b2) ->b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        System.out.println("Books sorted by Title.");
    }
    public static void main(String[] args){

        //scanner
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        //file is loaded in
        BookApplication.loadFile(books,"sample TXT Project file.txt");
        Book help = new PrintedBook("dummy","dummy","dummy",1);

        while(true){
            printActions();
            int num = sc.nextInt();
            sc.nextLine();

            //book added
            if(num==1){
                System.out.println("If you want to add a Printed Book, type 1. If you want to add a Audio Book, add 2.");
                int type= sc.nextInt();
                sc.nextLine();
                System.out.print("Title: ");
                String title=sc.nextLine();
                System.out.print("Author: ");
                String author=sc.nextLine();
                System.out.print("Genre: ");
                String genre=sc.nextLine();
                if(type ==1){
                    System.out.print("Pages: ");
                    int pages=sc.nextInt();
                    books.add(new PrintedBook(title,author,genre,pages));
                }
                else{
                    System.out.print("Duration in minutes: ");
                    int dur = sc.nextInt();
                    books.add(new AudioBook(title,author,genre,dur));

                }
            }

            //a book is searched by author,title, genre, or type
            else if(num==2){
                System.out.print("Search keyword: ");
                String key=sc.nextLine().toLowerCase();

                for(Book b: books){
                    if(b.getTitle().toLowerCase().contains(key) || b.getAuthor().toLowerCase().contains(key) || b.getGenre().toLowerCase().contains(key) || b.getType().toLowerCase().contains(key)){
                        b.display();
                    }
                }
            }

            //all books are displayed
            else if (num==3){
                help.displayBooks(books);
            }

            //statistics of the books are displayed
            else if(num==4){
                System.out.println("Total Cost: $" + help.getTotalCost(books));
                help.numberBooksperGenre(books);
                System.out.println("Average Pages: " + PrintedBook.avgPages());
                System.out.println("Average Duration(minutes): " + AudioBook.avgDuration());
                System.out.println("To see the Last 6 books, Type 1.");
                System.out.println("To see the Last 3 Printed Books, Type 2.");
                System.out.println("To see the Last 3 Audio Books, Type 3.");

                int ob = sc.nextInt();
                if(ob==1) {
                    System.out.println("Last 6 Books: ");
                    for (int i = Math.max(0, books.size() - 6); i < books.size(); i++) {
                        books.get(i).display();
                    }
                }
                if(ob==2) {
                    System.out.println("Last 3 Printed Books: ");
                    PrintedBook.displayLastThree();
                }
                if(ob==3) {
                    System.out.println("Last 3 Audio Books: ");
                    AudioBook.displayLastThree();
                }
                else{
                    System.out.println("Invalid Answer.");
                }
            }

            //all books are sorted alphabetically
            else if(num==5){
                sortBooks(books);
            }

            //the file is saved
            else if(num==6){
                BookApplication.saveFile(books,"sample TXT Project file.txt");
            }
            //the file is loaded
            else if(num==7){
                BookApplication.loadFile(books,"sample TXT Project file.txt");
            }
            //the program ends
            else if(num==0){
                System.out.println("Bye!");
                break;
            }
            //Error from an invalid input.
            else{
                System.out.println("Invalid Choice.");
            }


        }
        sc.close();


    }
}