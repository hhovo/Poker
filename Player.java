
public class Player {
    private String userName;
    private Card[] cardList;
    private int ind_curr_card;
    public collection coll;
    boolean win_flag;

    public Player(String name) {
        this.userName = name;
        this.ind_curr_card = 0;
        cardList = new Card[5];
        coll = new collection();
    }

    public void setCard(Card currentCard){

        cardList[ind_curr_card++] = currentCard;
    }

    public String toString() {

        return userName;
    }

    public Card[] getCardList(){

        return cardList;
    }

    public void printCards(){
        for(Card i : cardList){
            System.out.print("\n" + i);
        }
        System.out.println();
    }
}
