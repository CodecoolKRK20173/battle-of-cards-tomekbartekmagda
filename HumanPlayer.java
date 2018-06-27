public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int chooseStat() {
        return new InputGetter().getIntFromUser(1, 4);
    }
}