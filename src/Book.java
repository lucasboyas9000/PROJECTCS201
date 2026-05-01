import java.util.ArrayList;
//Abstract Class
public abstract class Book implements BookInterface  {

    //private fields (Encapsulation)
    private String title;
    private String author;
    private String genre;
    private String type;
    //constructor
    public Book(String title, String author, String genre, String type){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.type=type;
    }
    //getter
    public String getTitle() {
        return title;
    }
    //getter
    public String getAuthor() {
        return author;
    }
    //getter
    public String getGenre() {
        return genre;
    }
    //getter
    public String getType() {
        return type;
    }
    //setter
    public void setTitle(String title) {
        this.title = title;
    }
    //setter
    public void setAuthor(String author) {
        this.author = author;
    }
    //setter
    public void setGenre(String genre) {
        this.genre = genre;
    }
    //setter
    public void setType(String type) {
        this.type = type;
    }
    //abstract method(polymorphism) to get the cost of the book
    public abstract double getCost();

    //total cost method
    @Override
    public double getTotalCost(ArrayList<Book> books){
        double total = 0;

        for(Book b: books){
            total = total + b.getCost();
        }
        return total;
    }

    //number of books per genre method
    @Override
    public void numberBooksperGenre(ArrayList<Book> books){
        ArrayList<String> genres = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        for(Book b: books){
            String g = b.getGenre();

            if(genres.contains(g)){
                int set = genres.indexOf(g);
                count.set(set, count.get(set)+ 1);
            }
            else{
                genres.add(g);
                count.add(1);
            }
        }
        System.out.println("Books per genre:");
        for(int k=0; k<genres.size(); k++){
            System.out.println(genres.get(k)+": " +count.get(k));
        }


    }
    //display method
    public void display(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Type: " + type);
        System.out.println("Cost: $" + getCost());

    }




}
