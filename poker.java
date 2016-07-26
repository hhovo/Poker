
import java.util.Arrays;

public class poker {
    private Player dealer;
    private Player guest;
    private DeckOfCards deck;

    public poker(String guest_name) {
        dealer = new Player("Dealer");
        guest = new Player(guest_name);
        deck = new DeckOfCards();
    }

    public void PrintPlayersCards(){
        System.out.println(dealer + "'s" + " Hand" + "\n" + "---------------");
        dealer.printCards();
        System.out.println(dealer.coll.coll_type + "\n");
        System.out.println(guest  + "'s" + " Hand" + "\n" + "---------------");
        guest.printCards();
        System.out.println(guest.coll.coll_type + "\n");
    }

    public void determineWinner(Player guest, Player dealer) {
        this.PrintPlayersCards();
        switch (guest.coll.coll_type.value) {
            case 0: case 4: case 5: case 8:
                collection.kicker(guest,dealer);
            case 1: case 2:
                collection.compare_coll_cards_and_kiker(guest,dealer);
            case 3: case 6: case 7:
                collection.compare_coll_cards(guest,dealer);
            default:
                break;
        }
        if (guest.win_flag)
            System.out.println(guest + " WON");
        else if (dealer.win_flag) {
            System.out.println(dealer + " WON");
        } else {
            System.out.println("Drawn Game");
        }
    }


    public void startGame(){
        System.out.println("Hello " + guest + "\n" + "!!!Good Luck!!!" + "\n");
        System.out.println("Dealing cards");
        System.out.println("_________________" + "\n");
        deck.shuffle();
        for(int i = 0; i < 5; i++){
            guest.setCard(deck.dealCard());
            dealer.setCard(deck.dealCard());
        }
        Arrays.sort(guest.getCardList(), (Card c1, Card c2) -> c1.getFace().compareTo(c2.getFace()));
        Arrays.sort(dealer.getCardList(), (Card c1, Card c2) -> c1.getFace().compareTo(c2.getFace()));
        guest.coll.determineCollectionType(guest.getCardList());
        dealer.coll.determineCollectionType(dealer.getCardList());
        if (guest.coll.compare(dealer.coll) == 1){
            this.PrintPlayersCards();
            System.out.println(guest + " WON");
            endGame();
        }
        else if(guest.coll.compare(dealer.coll) == -1){
            this.PrintPlayersCards();
            System.out.println(dealer + " WON");
            endGame();
        }
        else {
            this.determineWinner(guest,dealer);
            endGame();
        }
    }

    private void endGame(){
        System.out.println("Good By " + guest + "\n");
    }
}
