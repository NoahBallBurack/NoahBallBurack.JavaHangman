import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class Game {

    String[] words={"awkward", "bagpipe", "banjo", "bungler", "crypt", "dwarves", "fishhook", "gazebo", "haiku", "hyphen", "ivory", "jiffy", "memento", "mystify", "oxygen", "pajama", "phlegm", "pixel", "rogue", "swivel", "zombie", "yacht"};

    String word;

    ArrayList<String> lettersGuessed = new ArrayList<>();

    int incorrectGuesses;

    public void random(){
        int randomNumber = new Random().nextInt(this.words.length);
        this.word=this.words[randomNumber];
    }

    public String scanWord(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Guess a lowercase letter");
        String letter=scanner.next();
        return letter;
    }

    public boolean containedInWord(String letter){
        for(int i=0;i<this.word.length();i++){
            if(letter.equals(this.word.substring(i,i+1))){
                return true;
            }
        }
        return false;
    }

    public void addToLettersGuessed(String letter){
        this.lettersGuessed.add(letter);
    }

    public String printWord(){
        String evolvingWord="";
        for(int i=0;i<this.word.length();i++){
            boolean hasBeenGuessed=false;
            for(int j=0;j<this.lettersGuessed.size();j++){
                if(this.word.substring(i,i+1).equals(this.lettersGuessed.get(j))){
                    hasBeenGuessed=true;
                }
            }
            if(hasBeenGuessed){
                evolvingWord+=this.word.substring(i,i+1);
            }else{
                evolvingWord+=" _ ";
            }
        }
        return evolvingWord;
    }

    public boolean allCorrect(){
        for(int i=0;i<this.word.length();i++){
            boolean hasBeenGuessed=false;
            for(int j=0;j<this.lettersGuessed.size();j++){
                if(this.word.substring(i,i+1).equals(this.lettersGuessed.get(j))){
                    hasBeenGuessed=true;
                }
            }
            if(!hasBeenGuessed){
                return false;
            }
        }
        return true;
    }
}
