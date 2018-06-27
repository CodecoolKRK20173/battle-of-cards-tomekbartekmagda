import java.util.Random;

public class CompPlayer extends Player {

    private final int MAX_STAT_INDEX = 4;

    public CompPlayer(String name) {
        super(name);
    }

    @Override
    public int chooseStat() {
        return new Random().nextInt(MAX_STAT_INDEX) + 1;
    }
}