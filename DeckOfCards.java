
import java.security.SecureRandom;
import java.util.Arrays;

public enum faces {
    Deuce(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13),
    Ace(14);
}

public class DeckOfCards {
    private Card[] deck;
    private int currentCard;
    private static final int NUMBER_OF_CARDS = 52;

    private static final SecureRandom randomNumbers = new SecureRandom();

    public DeckOfCards ()
    {

        String[] faces  = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

        deck = new Card[NUMBER_OF_CARDS];
        currentCard = 0;

        for ( int i = 0; i < NUMBER_OF_CARDS; i++ ){
            deck[i] = new Card(faces[i % 13], suits[i / 13]);
        }
    }

    public void shuffle(){
        currentCard = 0;
        for ( int i = 0; i < NUMBER_OF_CARDS; i++ ) {
            int rand_index = randomNumbers.nextInt(NUMBER_OF_CARDS);
            Card temp = deck[i];
            deck[i] = deck[rand_index];
            deck[rand_index] = temp;
        }
    }

    public Card dealCard()
    {
        if(currentCard < deck.length)
            return deck[currentCard++];
        else
            return null;
    }

    public void printDeckOfCards()
    {
        for(int i = 0; i < NUMBER_OF_CARDS; i++){
            System.out.println(deck[i]);
        }
    }
}


