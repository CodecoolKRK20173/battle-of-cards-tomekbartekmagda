import java.util.List;

public abstract class Player implements Comparable<Player> {

    private String name;
    private Hand hand;
    private boolean wonLastRound;

    public String getName() {
        return name;
    }

    public boolean getWonLastRound() {
        return wonLastRound;
    }

    public void setWonLastRound(boolean won) {
        wonLastRound = won;
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