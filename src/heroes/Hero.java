package heroes;

import enemies.Enemy;
import java.util.Random;

public abstract class Hero {
    private final String name;
    private int hp;
    private int damage;
    private int armor;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void attackEnemy(Enemy enemy);

    //базовый метод получения урона героев
    //урон рассчитывается с учетом брони персонажей
    public void takeDamage(int damage){
        if (isAlive()) {
            int realDamage = damage - getArmor();
            this.hp -=realDamage;
            System.out.println(getName() + " получает " + realDamage + " урона");
        }
        if (!isAlive()) {
            System.out.println(getName() + " убит" );

        }
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public int getDamage() {
        return damage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int setCrit(){
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                ", armor=" + armor +
                '}';
    }
}
