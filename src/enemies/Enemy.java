package enemies;

import heroes.Hero;
import utils.Mortal;

import static utils.Stats.DEFAULT_HP;


public abstract class Enemy implements Mortal{
    protected int hp;
    private int damage;
    private int armor;
    private final String name;


    public Enemy(int hp,String name) {
        this.hp = hp;
        this.name = name;
    }

    public abstract void attackEnemy(Hero hero);

    //базовый метод получения урона
    //проверяет жив ли персонаж, после получает урон сниженный на показатель брони
    public void takeDamage(int damage) {
        if (isAlive()) {
            int realDamage = damage - getArmor();
            this.hp -= realDamage;
            System.out.println(getName() + " получает " + realDamage + " урона");
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name= " + name +
                ", hp=" + hp +
                ", damage=" + damage +
                ", armor=" + armor + '\'' +
                '}';
    }
}
