import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookApplication {
    //saves the file
    public static void saveFile(ArrayList<Book> books, String fname){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(fname));
            for(Book b: books){
                writer.println(b.getType()+","+b.getTitle()+","+b.getAuthor()+","+b.getGenre()+",");
            }
            writer.close();
            System.out.println("Books saved succesfully!");
        }
        catch(IOException e){
            System.out.println("Error saving file.");
        }
    }
    //loads the file
    public static void loadFile(ArrayList<Book> books, String fname){
        try{
            Scanner sc = new Scanner(new File(fname));
            while(sc.hasNextLine()){
                String[] info = sc.nextLine().split(",");

              //  if (info.startsWith("Title")) continue;
                String title=info[0];


                String type=info[3];
                String author=info[1];
                String genre=info[2];

                if(type.equals("Printed")){
                    books.add(new PrintedBook(title,author,genre,100));
                }
                else if (type.equals("Audio")){
                    books.add(new AudioBook(title,author,genre,60));
                }
            }
            sc.close();
            System.out.println("Books loaded succesfully!");

        }
        catch (Exception e){
            System.out.println("Error loading file");
        }
    }
}
