import java.io.FileNotFoundException;
import java.util.Collections;

public class Main {

    private ArrayList<Player> players;
    private int numOfCards;
    private Dealer dealer;
    private String FILENAME;

    private int getPlayerCount(){
        Printer.printMenu(menuList.get("PlayerCountInput"));
        players = new ArrayList<Player>(InputGetter.getIntFromUser(2, 4));
    }

    private void addHumanPlayers(int humanPlayersCount){
        for (int i = 0; i< humanPlayersCount; i++){
            String playerName = InputGetter.getStringFromUser(menuList.get("PlayerNameInput"));
            players.add(new HumanPlayer(playerName));
        }
    }  

    private void addCompPlayers(int humanPlayersCount) {
        for (int i = 0; i < players.size()- humanPlayersCount; i++){
            String botName = InputGetter.getStringFromUser("PlayerNameInput");
            players.add(new CompPlayer(botName));
        }
    }
    
    private void addPlayers(){
        getPlayerCount();
        Printer.printMenu(menuList.get("HumanPlayerCountInput"));
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
        MenuFileReader menuList = new MenuFileReader();
        setFilename();
        getPlayerCount();
        addPlayers();
        createDealer();
    }

    private void setFilename() {
        FILENAME = InputGetter.getStringFromUser(menuList.get("FilenameInput"));
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
