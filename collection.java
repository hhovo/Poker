/**
 * Created by hhovo on 6/30/2016.
 */



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

    public collection determineCollectionType(Card[] cardList){
        for(Card i : cardList){
            System.out.println(i);
        }
        if(is_one_pair(cardList, 0, cardList.length)) {
            coll_type = collection_type.ONE_PAIR;
        }
        if(is_two_pair(cardList)) {
            coll_type = collection_type.TWO_PAIR;
        }
        if(is_three_of_kind(cardList)){
            coll_type = collection_type.THREE_OF_KIND;
        }
        /*if(is_straight(cardList)){
            coll_type = collection_type.STRAIGHT;
            return this;
        }
        if(is_flush(cardList)){
            coll_type = collection_type.FLUSH;
            return this;
        }
        if(is_full_house(cardList)){
            coll_type = collection_type.FULL_HOUSE;
            return this;
        }
        if(is_four_of_kind(cardList)){
            coll_type = collection_type.FOUR_OF_KIND;
            return this;
        }
        if(is_straight_flush(cardList)){
            coll_type = collection_type.STRAIGHT_FLUSH;
            return this;
        }
        if(is_reyal_flush(cardList)){
            coll_type = collection_type.ROYAL_FLUSH;
            return this;
        }*/
        return this;
    }



    public boolean is_one_pair(Card[] cardList, int start, int end){
        for ( int i = start; i < end - 1; i++ ) {
            if( cardList[i].getFace() == cardList[i+1].getFace() ) {
                for(int j = i + 1; j < end - 1; j++ ){
                    if(cardList[j].getFace() == cardList[j+1].getFace()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean is_two_pair(Card[] cardList){
        for(int i = 0; i < cardList.length - 1; i++){
            if( cardList[i].getFace() == cardList[i+1].getFace() ){
                if (i+2 < cardList.length) {
                    if (is_one_pair(cardList, i + 2, cardList.length)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean is_three_of_kind(Card[] cardList){
        for(int i = 0; i < cardList.length - 2; i++){
            if(cardList[i].getFace() == cardList[i+1].getFace() && cardList[i].getFace() == cardList[i+2].getFace()){
                return true;
            }
        }
        return false;
    }

//    public void compare(coll_names p1, coll_names p2){
//        if ( p1.value > p2.value ){
//            System.out.println(p1 +  " is greater then " + p2);
//        }
//        else if( p1.value < p2.value ) {
//            System.out.println(p1 + " is less then " +  p2);
//        }
//        else {
//            System.out.println(p1 + " is equal to " + p2);
//        }
//
//    }

}

