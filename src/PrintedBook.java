import java.util.ArrayList;

public class PrintedBook extends Book{

    //private fields
    private int pages;
    private static ArrayList<PrintedBook> printedBooks =new ArrayList<>();

    //constructor
    public PrintedBook(String title, String author,String genre,int pages){
        super(title,author,genre,"PrintedBook");
        this.pages=pages;

        printedBooks.add(this);
    }
    //getter
    public int getPages() {
        return pages;
    }
    //setter
    public void setPages(int pages) {
        if(pages>0) {
            this.pages = pages;
        }
    }

    //computes cost for printed books
    @Override
    public double getCost(){
        return pages*0.5;
    }

    //average pages for printed book
    public static double avgPages(){
        int tot=0;

        for(PrintedBook b: printedBooks){
            tot=tot+b.pages;
        }
        if(printedBooks.isEmpty()){
            return 0;
        }
        return ((double)tot)/printedBooks.size();
    }

    //shows the last 3 printed books
    public static void displayLastThree(){
        int str = Math.max(0,printedBooks.size()-3);

        for (int i = str; i< printedBooks.size();i++){
            printedBooks.get(i).display();
        }
    }



}
