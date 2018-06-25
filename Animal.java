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
}
