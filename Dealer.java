import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dealer {

    private ArrayList<Player> players;
    private Deck deck;
    private Table table;
    private Printer printer;
    private InputGetter inputGetter;
    private int nrOfCards;
    private int lastRoundWinnerIndex;

    public Dealer(String fileName, ArrayList<Player> players, int nrOfCards) throws FileNotFoundException {

        this.players = players;
        this.deck = new Deck(fileName);
        this.table = new Table();
        this.printer = new Printer();
        this.inputGetter = new InputGetter();
        this.nrOfCards = nrOfCards;
        this.lastRoundWinnerIndex = new Random().nextInt(players.size());

    }

    public void playGame() {

        boolean gameIsOver = false;

        dealCardsToPlayers();

        while (!gameIsOver) {

            putPlayerCardsOnTable();

            this.printer.printPlayer(this.players.get(this.lastRoundWinnerIndex), "This round is played by: ");
            this.printer.printCard(table.getCard(this.lastRoundWinnerIndex));
            int stat = this.players.get(this.lastRoundWinnerIndex).chooseStat();

            this.printer.printTable(this.table.getTable(), this.players);
            int winnerIndex = table.compareCards(stat);
            
            if (winnerIndex >= 0) {
                this.printer.printPlayer(this.players.get(winnerIndex), "This round is won by: ");
                this.lastRoundWinnerIndex = winnerIndex;
                sendCardsFromTableToWinner();
            }

            this.inputGetter.getStringFromUser("Press 'Enter' to continue.");

            gameIsOver = checkIfGameIsOver();
        }

    }

    private void dealCardsToPlayers() {

        for (int i=0; i<this.nrOfCards; i++) {

            for (Player player: this.players) {
                Animal card = this.deck.dealCard();
                player.putCardInHand(card);
            }

        }

    }

    private void putPlayerCardsOnTable() {

        for (int i=0; i<this.players.size(); i++) {
            this.table.addCardToTable(i, this.players.get(i).playCard());
        }

    }

    private void sendCardsFromTableToWinner() {

        List<Animal> cards = this.table.returnTable();
        this.players.get(this.lastRoundWinnerIndex).putTableInHand(cards);

    }

    private boolean checkIfGameIsOver() {

        for (Player player: this.players) {

            if (player.getHandSize() == 0)
                return true;

        }

        return false;
    }
}
