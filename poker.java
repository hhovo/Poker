/**
 * Created by hhovo on 6/30/2016.
 */
import java.util.Arrays;
import java.util.Collections;

public class poker {
    private Player dealer;
    private Player guest;
    private DeckOfCards deck;

    private collection guest_collection;
    private collection dealer_collection;

    public poker(String guest_name) {
        dealer = new Player("Dealer");
        guest = new Player(guest_name);
        deck = new DeckOfCards();
        guest_collection = new collection();
        dealer_collection = new collection();
    }

    public void startGame(){
        System.out.println("Dealing cards");
        //deck.shuffle();
        //deck.printDeckOfCards();
        guest.setCard(new Card("Three","Hearts"));
        guest.setCard(new Card("Nine","Diamonds"));
        guest.setCard(new Card("Nine","Hearts"));
        guest.setCard(new Card("Ace","Clubs"));
        guest.setCard(new Card("Nine","Diamonds"));
/*
        for(int i = 0; i < 5; i++){
            guest.setCard(deck.dealCard());
            dealer.setCard(deck.dealCard());
        }
*/
        Arrays.sort(guest.getCardList(), (Card c1, Card c2) -> c1.getFace().compareTo(c2.getFace()));

        guest_collection.determineCollectionType(guest.getCardList());
        System.out.println(guest_collection.coll_type);
        System.out.println(guest_collection.coll_type.value);
    }
}
