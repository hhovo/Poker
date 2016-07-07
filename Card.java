
public class Card {
    private final faces face;
    private final String suit;

    public Card (faces cardFace, String cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    public Integer getFace(){
        return face.value;
    }

    public String getSuit(){
        return suit;
    }

    public String toString () {
        return face + " of " + suit;
    }
}
