import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.io.FileReader;

public class Deck{
    private ArrayList<Animal> deck;


    public Deck(String filename) throws FileNotFoundException {
        deck = new ArrayList<Animal>();
        loadCardsFromFile(filename);
    }

    private void loadCardsFromFile(String fileName) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            addCardsFromFile(br);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No file");
        }
    }

    private void addCardsFromFile(BufferedReader fileRead) throws IOException {
        final int NAME_COL = 0;
        final int SIZE_COL = 1;
        final int WEIGHT_COL = 2;
        final int SPEED_COL = 3;
        final int LIFE_SPAN_COL = 4;
        String animalData;
        while ((animalData = fileRead.readLine()) != null) {
            String[] animal = animalData.split("\\|");
            String name = animal[NAME_COL];
            float size = Float.parseFloat(animal[SIZE_COL]);
            float weight = Float.parseFloat(animal[WEIGHT_COL]);
            float speed = Float.parseFloat(animal[SPEED_COL]);
            float lifeSpan = Float.parseFloat(animal[LIFE_SPAN_COL]);
            deck.add(new Animal(name, size, weight, speed, lifeSpan));
            }
        }

    public Animal dealCard(){
        Random rand = new Random();
        int cardIndex = rand.nextInt(deck.size()-1);
        Animal card = deck.get(cardIndex);
        deck.remove(cardIndex);
        return card;
    }

}
