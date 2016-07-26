import java.util.Scanner;

public class Game {
    poker play;

    public Game(String guest_name){
        play = new poker(guest_name);
    }

    public void startGame() {
        play.startGame();
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = input.next();
        Game ob  = new Game(name);
        ob.startGame();
    }
}
