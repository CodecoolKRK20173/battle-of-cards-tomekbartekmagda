import java.io.FileNotFoundException;
import java.util.Collections;

public class Main {

    private ArrayList<Player> players;
    private int numOfCards;
    private Dealer dealer;
    private String FILENAME;

    private int getPlayerCount(){
        players = new ArrayList<Player>(InputGetter.getIntFromUser(2, 4));
    }

    private void addHumanPlayers(int humanPlayersCount){
        for (int i = 0; i< humanPlayersCount; i++){
            String playerName = InputGetter.getStringFromUser("Provide player name");
            players.add(new HumanPlayer(playerName));
        }
    }  

    private void addCompPlayers(int humanPlayersCount) {
        for (int i = 0; i < players.size()- humanPlayersCount; i++){
            String botName = InputGetter.getStringFromUser("Provide bot name");
            players.add(new CompPlayer(botName));
        }
    }
    
    private void addPlayers(){
        getPlayerCount();
        int humanPlayersCount = InputGetter.getIntFromUser(0, players.size());
        addHumanPlayers();
        addCompPlayers();
    }

    private void createDealer() {
        try{
        dealer = new Dealer(filename, players, numOfCards);
        } catch (FileNotFoundException exception){
            dealer = new Dealer("animals.csv", players, numOfCards);
        }
    }

    public Main() {
        Printer printer = new Printer();
        setFilename();
        getPlayerCount();
        addPlayers();
        createDealer();
    }

    private void setFilename() {
        FILENAME = InputGetter.getStringFromUser("Provide file with cards");
    }

    private Player getWinner() {
        return Collections.max(players);
    }

    public static void main(String[] args) {
        Main main = new Main();
        Dealer.playGame();
        Printer.printWinner(getWinner());
    }
}
