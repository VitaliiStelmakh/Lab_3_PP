package Model;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int damage;
    protected int energy;



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }
    public int getDamage() {
        return this.damage;
    }
    public int getEnergy() {
        return energy;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setHelth(int helth) {
        this.health = helth;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }


    public abstract void Attack();
    public abstract void Defense(int damage);

}
