import java.util.List;

public abstract class Player implements Comparable<Player> {

    private String name;
    private Hand hand;

    public String getName() {
        return name;
    }

    public int getHandSize() {
        return hand.getSize();
    }

    public boolean isOutOfCards() {

        if (hand.getSize() == 0) {
            return true;
        }

        return false;
    }

    public Animal playCard() {
        return hand.getCard();
    }

    public void putCardInHand(Animal card) {
        hand.addCardToHand(card);
    }

    public void putTableInHand(List<Animal> cards) {
        for (Animal card: cards) {
            hand.addCardToHand(card);
        }
    }

    public abstract int chooseStat();

    @Override
    public int compareTo(Player otherPlayer) {
        return this.getHandSize().compareTo(otherPlayer.getHandSize());
    }
}