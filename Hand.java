import java.util.LinkedList;

public class Hand {

    private LinkedList<Animal> cards;

    public Hand() {
        cards = new LinkedList<>();
    }

    public Animal getCard() {
        Animal card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public void addCardToHand(Animal card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }
}