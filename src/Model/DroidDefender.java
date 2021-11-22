package Model;

import java.util.Random;

public class DroidDefender extends Droid{

    public static final Random random = new Random();


    public DroidDefender() {
        this.name = "DroidDefender";
        this.health = 400;
        this.energy = 30;
    }
    @Override
    public void Attack() {
        this.setDamage((random.nextInt(30) + 20));
    }

    @Override
    public void Defense(int damage) {
        if(energy<10)
            this.setHelth(this.getHealth() - damage);
        else {
            if (random.nextInt(3) == 0){
                System.out.println("Block damage");
                this.setHelth(this.getHealth());
            }
            else
            this.setHelth(this.getHealth() - damage);
        }
    }
}
