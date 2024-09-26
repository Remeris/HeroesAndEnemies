package enemies;

import heroes.Hero;

import static utils.Stats.DEFAULT_ARMOR;
import static utils.Stats.DEFAULT_HP;

public class Zombie extends Enemy {

    static final int DEFAULT_ZOMBIE_DAMAGE = 20;
    private boolean ressurection = true;

    public Zombie(int hp, String name) {
        super(hp, name);
        setArmor(DEFAULT_ARMOR);
        setDamage(DEFAULT_ZOMBIE_DAMAGE);
    }

    //базовая атака по врагу, перед атакой проверяет жив ли зомби и жив ли персонаж которого он атакует
    @Override
    public void attackEnemy(Hero hero) {
        if (isAlive() && hero.isAlive()) {
            System.out.println(getName() + " Совершает атаку на: " + getDamage() + " урона");
            hero.takeDamage(getDamage());
        }
    }

    //переопределённый метод получения урона для зомби
    //в случае смерти зомби зомби однократно восстаёт из мертвых с базовым значением жизней
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isAlive()) {
            if (ressurection) {
                ressurection = false;
                hp = DEFAULT_HP;
                System.out.println(getName() + " воскрес");
            } else {
                System.out.println(getName() + " убит");
            }
        }
    }
}
