public class Animal {

    private String name;
    private float size;
    private float weight;
    private float speed;
    private int lifeSpan;


    public Animal(String name, float size, float weight, float speed, int lifeSpan) {
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.speed = speed;
        this.lifeSpan = lifeSpan;
    }


    public String getName() {
        return name;
    }


    public float getSize() {
        return size;
    }


    public float getWeight() {
        return weight;
    }


    public float getSpeed() {
        return speed;
    }


    public int getLifeSpan() {
        return lifeSpan;
    }


    public String toString() {
        String line = "-----------------------------------------------";
        return String.format("%.29s \n| %-25s |\n%.29s \n| (1) Size: %12.2f cm |"
        + "\n| (2) Weight: %10.2f kg |\n| (3) Top speed: %6.2f kph |\n| (4) Life span: %4d years |"
        + " \n%.29s", line, name.toUpperCase(), line, size, weight, speed, lifeSpan, line);
    }
}
