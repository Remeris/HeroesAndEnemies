package heroes;

import enemies.Enemy;

import static utils.Stats.*;
import static utils.Stats.DEFAULT_CRIT_DAMAGE_MOD;

public class Mage extends Hero{

    static final int BASE_MANA_STAT = 100;
    static final int MAGE_ARMOR_MOD = -5;
    static final int MAGE_HP_MOD = -20;
    static final int DEFAULT_MAGE_DAMAGE = 10;
    static final int MAGIC_CRIT_DAMAGE_MOD = 3;

    private int mana;

    public Mage(String name) {
        super(name);
        setDamage(DEFAULT_MAGE_DAMAGE);
        setHp(DEFAULT_HP + MAGE_HP_MOD);
        setArmor(DEFAULT_ARMOR + MAGE_ARMOR_MOD);
        setMana(BASE_MANA_STAT);
    }

    //базовая атака мага посохом
    //проверяет жив ли маг и его цель, после чего наносит атаку в зависимости расчета шанса критического удара
    @Override
    public void attackEnemy(Enemy enemy) {
        if (isAlive() && enemy.isAlive()){
            if ((setCrit()) >= 8) {
                System.out.println(getName() + " Критическая атака посохом на: " + (getDamage() * DEFAULT_CRIT_DAMAGE_MOD) + " урона");
                enemy.takeDamage(getDamage() * DEFAULT_CRIT_DAMAGE_MOD);
            } else {
                System.out.println(getName() + " Атака посохом на: " + getDamage() + " урона");
                enemy.takeDamage(getDamage());
            }
        }
    }

    //метод устанавливающий значение маны мага
    public void setMana(int mana) {
        this.mana = mana;
    }

    //второй атакующий навык мага
    //создает огненный шар и наносит урон расходуя ману
    //маг обладает повышенным уроном от заклинаний в случае критической атаки
    public void fireball(Enemy enemy){
        if (isAlive() && enemy.isAlive()){
            if (mana >= 30){
                mana = mana - 30;
                if ((setCrit()) >= 8) {
                    System.out.println(getName() + " Критическая атака огненным шаром на: " + ((getDamage() + 20) * MAGIC_CRIT_DAMAGE_MOD) + " урона");
                    enemy.takeDamage((getDamage() + 20) * MAGIC_CRIT_DAMAGE_MOD);
                } else {
                    System.out.println(getName() + " Атака огненным шаром на: " + (getDamage() + 20) + " урона");
                    enemy.takeDamage(getDamage() + 20);
                }
            }else {
                System.out.println("не хватает маны");
            }
        }
    }

}



