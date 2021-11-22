package Model;

import java.util.Random;

public class DroidMedic extends Droid{
    public static final Random random = new Random();
    public DroidMedic()
    {
        this.name = "DroidMedic";
        this.health = 100;
        this.energy = 30;
    }

    @Override
    public void Attack() {
        if (energy < 10)
            this.setDamage((random.nextInt(50)+20 )*(-1));
        else {
            if (random.nextInt(2) == 0)
                this.setDamage((random.nextInt((50) + 20))*(-1));
            else {
                System.out.println("Super power");
                this.setDamage(-150);
                this.setEnergy(this.getEnergy() - 10);
            }
        }
    }

    @Override
    public void Defense(int damage) {
        this.setHelth(this.getHealth() - damage);
    }


}
