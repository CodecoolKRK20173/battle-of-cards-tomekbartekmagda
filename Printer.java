import java.util.ArrayList;

public class Printer {


    public void printTable(ArrayList<Animal> table, ArrayList<Player> players) {
        String cards = "\n";

        for (Player player : players){
            cards += String.format("%-29s ", player.getName());
        }
        cards += "\n";
        for (Player player : players){
            cards += String.format("Cards in hand: %-14s ", player.getHandSize());
        }
        cards += "\n";
        final int NUM_OF_LINE_IN_CARD = 8;
        for (int i = 0; i < NUM_OF_LINE_IN_CARD; i++){
            for (Animal card : table){
                cards += card.toString().split("\n")[i];
                cards += " ";
            }
            cards += "\n";
        }
        System.out.println(cards);
    }


    public void printText(String text) {
        System.out.println(text);
    }


    public void printCard(Animal card) {
        System.out.println(card.toString());
    }

    public void printPlayer(Player player, String message) {
        System.out.printf("%s%s\n\n", message, player.getName());
    }

    public void printWinner(Player player) {
        System.out.printf("The winnwer is %s, with %d cards!\n", player.getName(), player.getHandSize());
    }
}
