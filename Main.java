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


    private void getPlayerCount(){
        players = new ArrayList<Player>(inputGetter.getIntFromUser(2, 4));
    }

    private void addHumanPlayers(int humanPlayersCount){
        for (int i = 0; i< humanPlayersCount; i++){
            String playerName = inputGetter.getStringFromUser("Provide Player name");
            players.add(new HumanPlayer(playerName));
        }
    }  

    private void addCompPlayers(int humanPlayersCount) {
        for (int i = 0; i < players.size()- humanPlayersCount; i++){
            String botName = inputGetter.getStringFromUser("Provide bot name");
            players.add(new CompPlayer(botName));
        }
    }
    
    private void addPlayers(){
        getPlayerCount();
        int humanPlayersCount = inputGetter.getIntFromUser(0, players.size());
        addHumanPlayers(humanPlayersCount);
        addCompPlayers(humanPlayersCount);
    }

    private void createDealer() {
        try{
        dealer = new Dealer(filename, players, numOfCards);
        } catch (FileNotFoundException exception){
            dealer = new Dealer("animals.csv", players, numOfCards);
        }
    }

    public Main() {
        inputGetter = new InputGetter();
        setFilename();
        getPlayerCount();
        addPlayers();
        createDealer();
    }

    private void setFilename() {
        filename = inputGetter.getStringFromUser("Filename?");
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
