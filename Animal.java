public class Animal {

    private String name;
    private float size;
    private float weight;
    private float speed;
    private float lifeSpan;


    public Animal(String name, float size, float weight, float speed, float lifeSpan) {
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


    public float getLifeSpan() {
        return lifeSpan;
    }


    public String toString() {
        String line = "-----------------------------------------------";
        return String.format("%.25s \n| %-21s |\n%.25s \n| Size: %12.2f cm |"
        + "\n| Weight: %10.2f kg |\n| Top speed: %6.2f kph |\n| Life span: %4.0f years |"
        + " \n%.25s", line, name.toUpperCase(), line, size, weight, speed, lifeSpan, line);
    }
}
