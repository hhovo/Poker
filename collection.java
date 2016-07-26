import java.util.ArrayList;


public class collection {

    public enum collection_type{
        HIGH_CARD(0),
        ONE_PAIR(1),
        TWO_PAIR(2),
        THREE_OF_KIND(3),
        STRAIGHT(4),
        FLUSH(5),
        FULL_HOUSE(6),
        FOUR_OF_KIND(7),
        STRAIGHT_FLUSH(8),
        ROYAL_FLUSH(9);
        int value;
        collection_type(int value){
            this.value = value;
        }

    }

    public collection_type coll_type = collection_type.HIGH_CARD;
    public ArrayList<Card> coll_cards = new ArrayList<Card>();

    public collection determineCollectionType(Card[] cardList){
        if(is_one_pair(cardList, 0, cardList.length)) {
            coll_type = collection_type.ONE_PAIR;
        }
        else if(is_two_pair(cardList)) {
            coll_type = collection_type.TWO_PAIR;
        }
        else if(is_three_of_kind(cardList, 0, 5)){
            coll_type = collection_type.THREE_OF_KIND;
        }
        else if(is_straight(cardList)){
            coll_type = collection_type.STRAIGHT;
        }
        else if(is_flush(cardList)){
            coll_type = collection_type.FLUSH;
        }
        else if(is_full_house(cardList)){
            coll_type = collection_type.FULL_HOUSE;
        }
        else if(is_four_of_kind(cardList)){
            coll_type = collection_type.FOUR_OF_KIND;
        }
        else if(is_straight_flush(cardList)){
            coll_type = collection_type.STRAIGHT_FLUSH;
        }
        else if(is_royal_flush(cardList)){
            coll_type = collection_type.ROYAL_FLUSH;
        }
        return this;
    }


    /************************** Collection functions ********************************/

    public boolean is_one_pair(Card[] cardList, int start, int end){
        for ( int i = start; i < end - 1; i++ ) {
            if( cardList[i].getFace() == cardList[i+1].getFace() ) {
                this.coll_cards.add(cardList[i]);
                for(int j = i + 1; j < end - 1; j++ ){
                    if(cardList[j].getFace() == cardList[j+1].getFace()) {
                        this.coll_cards.clear();
                        return false;
                    }
                }
                return true;
            }
        }
        this.coll_cards.clear();
        return false;
    }

    public boolean is_two_pair(Card[] cardList){
        if (is_four_of_kind(cardList)){
            return false;
        }
        for(int i = 0; i < cardList.length - 1; i++){
            if( cardList[i].getFace() == cardList[i+1].getFace() ){
                this.coll_cards.add(cardList[i]);
                if (i+2 < cardList.length) {
                    if ( is_one_pair(cardList, i + 2, cardList.length) ) {
                        return true;
                    }
                }
            }
        }
        this.coll_cards.clear();
        return false;
    }

    public boolean is_three_of_kind(Card[] cardList, int start, int end){
        for(int i = start; i < end - 2; i++){
            if(cardList[i].getFace() == cardList[i+1].getFace() && cardList[i].getFace() == cardList[i+2].getFace()){
                this.coll_cards.add(cardList[i]);
                for(int j = i + 2; j < end - 1; j++){
                    if ( cardList[j].getFace() == cardList[j + 1].getFace() ){
                        this.coll_cards.clear();
                        return false;
                    }
                }
                return true;
            }
            else if(cardList[i].getFace() == cardList[i+1].getFace()){
                this.coll_cards.clear();
                return false;
            }
        }
        this.coll_cards.clear();
        return false;
    }

    public boolean is_straight(Card[] cardList){
        for(int i = 0; i < cardList.length - 1; i++){
            if( cardList[i+1].getFace() - cardList[i].getFace() != 1 ){
                return false;
            }
        }
        return true;
    }

    public boolean is_flush(Card[] cardList){
        for(int i = 0; i < cardList.length - 1; i++){
            if( cardList[i].getSuit() != cardList[i+1].getSuit()){
                return false;
            }
        }
        return true;
    }

    public  boolean is_full_house(Card[] cardList){
        return (is_one_pair(cardList, 0, 2) && is_three_of_kind(cardList, 2, 5)) ||
               (is_one_pair(cardList, 3, 5) && is_three_of_kind(cardList, 0, 3));
    }

    public boolean is_four_of_kind(Card[] cardList) {
        if ((cardList[0].getFace() == cardList[1].getFace() &&
             cardList[0].getFace() == cardList[2].getFace() &&
             cardList[0].getFace() == cardList[3].getFace())
             ||
            (cardList[1].getFace() == cardList[2].getFace() &&
             cardList[1].getFace() == cardList[3].getFace() &&
             cardList[1].getFace() == cardList[4].getFace()) ) {
            this.coll_cards.add(cardList[2]);
            return true;
        }
        return false;
    }

    public boolean is_straight_flush(Card[] cardList) {
        return is_straight(cardList) && is_flush(cardList);
    }

    public boolean is_royal_flush(Card[] cardList) {
        return is_straight(cardList) && is_flush(cardList) && cardList[0].getFace() == faces.Ten.value;
    }


    /************************************ compare functions *******************************************/

    public static void kicker(Player guest, Player dealer) {
        for (int i = guest.getCardList().length-1; i >= 0; i--) {
            if (guest.getCardList()[i].getFace() > dealer.getCardList()[i].getFace()){
                guest.win_flag = true;
                return;
            }
            if (guest.getCardList()[i].getFace() < dealer.getCardList()[i].getFace()) {
                dealer.win_flag = true;
                return;
            }
        }
    }

    public static void compare_coll_cards(Player guest, Player dealer){
        for (int i = guest.coll.coll_cards.size()-1; i >= 0; i--){
            if(guest.coll.coll_cards.get(i).getFace() > dealer.coll.coll_cards.get(i).getFace()){
                guest.win_flag = true;
                return;
            }
            if( guest.coll.coll_cards.get(i).getFace() < dealer.coll.coll_cards.get(i).getFace()){
                dealer.win_flag = true;
                return;
            }
        }
    }

    public static void compare_coll_cards_and_kiker(Player guest, Player dealer){
        collection.compare_coll_cards(guest,dealer);
        if (!(guest.win_flag || dealer.win_flag)) {
            collection.kicker(guest, dealer);
        }
    }

    public int compare(collection p1){
        if ( this.coll_type.value > p1.coll_type.value ){
            return 1;
        }
        else if( this.coll_type.value < p1.coll_type.value ) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

