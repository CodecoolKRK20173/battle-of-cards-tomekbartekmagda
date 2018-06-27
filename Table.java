import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;

public class Table{
    private ArrayList<Animal> table;
    private ArrayList<Animal> sideTable;

    public Table(){
        table = new ArrayList<>();
        sideTable = new ArrayList<>();
    }

    public void addCardToTable (int index, Animal card){
        table.add(index, card);
    }

    public ArrayList<Animal> returnTable(){
        ArrayList<Animal> finalTable = new ArrayList<Animal>();
        finalTable.addAll(table);
        finalTable.addAll(sideTable);
        table.clear();
        sideTable.clear();
        return finalTable;
    }
    
    public int compareCards(int stat){
        ArrayList<Float> valuesToCompare = new ArrayList<>();
        int searchedIndex;
        for (Animal animal : table){    
            if (stat == 1){
                valuesToCompare.add(animal.getSize());
            }
            if (stat == 2){
                valuesToCompare.add(animal.getWeight());
            }
            if (stat == 3){
                valuesToCompare.add(animal.getSpeed());
            }
            if (stat == 4){
                valuesToCompare.add(animal.getLifeSpan());
            }
        }
        Set<Float> uniqueValues = new HashSet<>(valuesToCompare);
        if (uniqueValues.size()<valuesToCompare.size()){
            searchedIndex = -1;
            sideTable.addAll(table);
            table.clear();
        }
        else{
            searchedIndex =valuesToCompare.indexOf(Collections.max(valuesToCompare));
        }   
        return searchedIndex;
    }

    public Animal getCard(int index){
        return table.get(index);
    }
}