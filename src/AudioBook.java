import java.util.ArrayList;

public class AudioBook extends Book{

    //private fields
    private int duration;
    private static ArrayList<AudioBook> audioBook = new ArrayList<>();

    //constructor
    public AudioBook(String title, String author, String genre,int duration){
        super(title,author,genre,"AudioBook");
        this.duration=duration;

        audioBook.add(this);
    }

    //method to get cost of the audio books (Inheritance)
    @Override
    public double getCost(){
        return duration * 0.25;
    }

    //method to get average duration of minutes for the audio book
    public static double avgDuration(){
        int tot=0;
        for(AudioBook a: audioBook){
            tot=tot+a.duration;
        }
        if(audioBook.isEmpty()){
            return 0;
        }
        return ((double)tot)/ audioBook.size();
    }

    //displays last 3 audio books
    public static void displayLastThree(){
        int str=Math.max(0,audioBook.size()-3);
        for(int i=0;i< audioBook.size();i++){
            audioBook.get(i).display();
        }
    }


}
