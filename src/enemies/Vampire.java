package enemies;

import heroes.Hero;

import static utils.Stats.DEFAULT_ARMOR;

public class Vampire extends Enemy {

    static final int DEFAULT_VAMPIRE_DAMAGE = 15;
    static final int VAMPIRE_REGENERATION = 5;
    static final int VAMPIRE_HP_MOD = -10;


    public Vampire(int hp, String name) {
        super(hp + VAMPIRE_HP_MOD, name);
        setArmor(DEFAULT_ARMOR);
        setDamage(DEFAULT_VAMPIRE_DAMAGE);
    }
    //базовая атака вампира, прибавляет фиксированное количество здоровья за атаку
    @Override
    public void attackEnemy(Hero hero) {
        if (isAlive() && hero.isAlive()) {
            System.out.println(getName() + " Совершает укус на: " + getDamage() + " урона");
            hero.takeDamage(getDamage());
            System.out.println(getName() + " получает " + VAMPIRE_REGENERATION + " здоровья");
            hp += VAMPIRE_REGENERATION;
        }
    }
}
