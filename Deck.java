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
        String animalData;
        while ((animalData = fileRead.readLine()) != null) {
            String[] animal = animalData.split("\\|");
            String name = animal[0];
            float size = Float.parseFloat(animal[1]);
            float weight = Float.parseFloat(animal[2]);
            float speed = Float.parseFloat(animal[3]);
            float lifeSpan = Float.parseFloat(animal[4]);
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
