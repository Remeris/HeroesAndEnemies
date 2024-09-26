package heroes;

import enemies.Enemy;
import utils.Stats;

import static utils.Stats.DEFAULT_CRIT_DAMAGE_MOD;

public class Archer extends Hero{
    static final int ARCHER_CRIT_MOD = 1;
    static final int DEFAULT_ARCHER_DAMAGE = 15;

    public Archer(String name) {
        super(name);
        setDamage(DEFAULT_ARCHER_DAMAGE);
        setHp(Stats.DEFAULT_HP);
        setArmor(Stats.DEFAULT_ARMOR);
    }

    //персонаж лучник совершает базовую атаку
    //перед атакой проверяет жив ли лучник и жив ли противник
    // лучник имеет бонусный модификатор на шанс критичской атаки, так же лучник имеет повышенный шанс критической атаки как таковой
    @Override
    public void attackEnemy(Enemy enemy) {
        if (isAlive() && enemy.isAlive()){
            if ((setCrit() + ARCHER_CRIT_MOD) >= 7) {
                System.out.println(getName() + " Делает критический выстрел на: " + (getDamage() * DEFAULT_CRIT_DAMAGE_MOD) + " урона");
                enemy.takeDamage(getDamage() * DEFAULT_CRIT_DAMAGE_MOD);
            } else {
                System.out.println(getName() + " Делает выстрел на: " + getDamage() + " урона");
                enemy.takeDamage(getDamage());
            }
        }
    }

}

