
import java.util.ArrayList;
import java.util.Arrays;
public class Game {
    poker play;

    public Game(String guest_name){
        System.out.println("Hello " + guest_name + "\n" + "!!!Good Luck!!!");
        play = new poker(guest_name);
    }

    public void startGame() {
        play.startGame();
    }

    public static void main(String[] args){
        Game ob  = new Game("hhovo");
        ob.startGame();
    }
}
