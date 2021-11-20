package Model;

import java.util.Random;

public class BattleDroid extends Droid{
    public static final Random random = new Random();

    public BattleDroid() {
        this.name = "BattleDroid";
        this.health = 150;
        this.energy = 20;
    }

    @Override
    public void Attack()
    {
        if (energy<5)
            this.setDamage(random.nextInt(30) + 20);
        else {
            if(random.nextInt(3)!=0)
                this.setDamage((random.nextInt(30) + 20));
            else {
                System.out.println("Critical damage");
                this.setDamage(55);
                this.setEnergy(this.getEnergy() - 5);
            }
        }
    }
    @Override
    public void Defense(int damage)
    {
        this.setHelth(this.getHealth() - damage);
    }

}



