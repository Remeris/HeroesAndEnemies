package heroes;

import enemies.Enemy;

import static utils.Stats.*;
import static utils.Stats.DEFAULT_CRIT_DAMAGE_MOD;

public class Warrior extends Hero{

    //статические поля относящиеся к расчёту класса воин
    static final int DEFAULT_WARRIOR_DAMAGE = 20;
    static final int WARRIOR_HP_MOD = 30;
    static final int WARRIOR_ARMOR_MOD = 5;

    //конструктор класса воин
    public Warrior(String name) {
        super(name);
        setDamage(DEFAULT_WARRIOR_DAMAGE);
        setHp(DEFAULT_HP + WARRIOR_HP_MOD);
        setArmor(DEFAULT_ARMOR + WARRIOR_ARMOR_MOD);
    }

    // переопределенный метод атаки по врагу, перед атакой проводит проверку жив ли герой и его противник
    // далее проверяет возможность критического удара (различна у каждого героя) и наносит урон исходя из модификаторов урона героя
    @Override
    public void attackEnemy(Enemy enemy) {
        if (isAlive() && enemy.isAlive()){
            if ((setCrit()) >= 8) {
                System.out.println(getName() + " Критическая атака мечем на: " + (getDamage() * DEFAULT_CRIT_DAMAGE_MOD) + " урона");
                enemy.takeDamage(getDamage() * DEFAULT_CRIT_DAMAGE_MOD);
            } else {
                System.out.println(getName() + " Атака мечем на: " + getDamage() + " урона");
                enemy.takeDamage(getDamage());
            }
        }
    }

    //второй навык атаки воина
    //совершает две атаки за один раз
    public void doubleAttack(Enemy enemy) {
        if (isAlive() && enemy.isAlive()) {
            System.out.println(getName() + " Совершает две атаки: ");
            attackEnemy(enemy);
            attackEnemy(enemy);
        }
    }
}
