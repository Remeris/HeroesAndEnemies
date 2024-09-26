package enemies;

import heroes.Hero;

import static utils.Stats.DEFAULT_ARMOR;

public class Zombie extends Enemy {

    static final int DEFAULT_ZOMBIE_DAMAGE = 20;


    public Zombie(int hp, String name) {
        super(hp, name);
        setArmor(DEFAULT_ARMOR);
        setDamage(DEFAULT_ZOMBIE_DAMAGE);
    }

    @Override
    public void attackEnemy(Hero hero) {
        if (isAlive() && hero.isAlive()) {
            System.out.println(getName() + " Совершает атаку на: " + getDamage() + " урона");
            hero.takeDamage(getDamage());
        }
    }
}
