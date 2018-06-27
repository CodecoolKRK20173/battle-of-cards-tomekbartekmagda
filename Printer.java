public class Printer {


    public void printTable(ArrayList<Animal> table, ArrayList<Palyer> players) {
        String cards = "";
        for (Player player : players){
            cards += String.format("%-29s ", player.getName());
        }
        cards += "\n";
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < table.size(); j++){
                cards += table.get(j).toString().split("\n")[i];
                cards += " ";
            }
            cards += "\n";
        }
        System.out.println(cards);
    }


    public void printMenu() {
        String menu = "(1) Option";
        System.out.println(menu);
    }

}
