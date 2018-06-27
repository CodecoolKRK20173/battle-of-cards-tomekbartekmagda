import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.ArrayList;

public class Main {

    private ArrayList<Player> players;
    private int numOfCards;
    public Dealer dealer;
    private String filename;
    public InputGetter inputGetter;
    private Printer printer;
    private int playersCount;


    private void getPlayerCount(){
        printer.printText("\nProvide number of players");
        playersCount = inputGetter.getIntFromUser(2, 4);
    }

    private void addHumanPlayers(int humanPlayersCount){
        for (int i = 0; i< humanPlayersCount; i++){
            String playerName = inputGetter.getStringFromUser("\nProvide Player name");
            players.add(new HumanPlayer(playerName));
        }
    }

    private void addCompPlayers(int humanPlayersCount) {
        for (int i = 0; i < playersCount - humanPlayersCount; i++){
            String botName = inputGetter.getStringFromUser("\nProvide bot name");
            players.add(new CompPlayer(botName));
        }
    }

    private void addPlayers(){
        printer.printText("\nProvide number of human players");
        int humanPlayersCount = inputGetter.getIntFromUser(0, playersCount);
        addHumanPlayers(humanPlayersCount);
        addCompPlayers(humanPlayersCount);
    }

    private void createDealer() {
        try{
        dealer = new Dealer(filename, players, numOfCards);
        } catch (FileNotFoundException exception){
            dealer = null;
        }

        if (dealer == null) {
            try {
                dealer = new Dealer("animals.csv", players, numOfCards);
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
                System.exit(0);
            }
        }
    }

    public Main() {
        players = new ArrayList<Player>();
        inputGetter = new InputGetter();
        printer = new Printer();
        setFilename();
        getPlayerCount();
        addPlayers();
        printer.printText("\nProvide number of cards for each player");
        numOfCards = inputGetter.getIntFromUser(3, 15);
        createDealer();
    }

    private void setFilename() {
        filename = inputGetter.getStringFromUser("Provide name of file with cards or press 'Enter' to use animal cards.");
    }

    private Player getWinner() {
        return Collections.max(players);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.dealer.playGame();
        main.printer.printWinner(main.getWinner());
    }
}
