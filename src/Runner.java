public class Runner {
    static boolean gameOver=false;

    public static void main(String[] args){
        Game g = new Game();
        g.random();
        while(!gameOver){
            String letter = g.scanWord();
            if(!g.containedInWord(letter)){
                g.incorrectGuesses++;
            }else{
                g.addToLettersGuessed(letter);
            }
            System.out.println(g.printWord());
            if(g.incorrectGuesses==8){
                gameOver=true;
                System.out.println("You Lose");
            }
            if(g.allCorrect()){
                System.out.println("You Win");
                gameOver=true;
            }
        }
    }
}
