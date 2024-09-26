import enemies.Enemy;
import enemies.Vampire;
import enemies.Zombie;
import heroes.Archer;
import heroes.Hero;
import heroes.Mage;
import heroes.Warrior;

public class TrainingGround {

    public static void main(String[] args) {

        //создание трёх тестовых зомби
        Zombie zombie = new Zombie(100, "Первый зомби");
        Zombie zombie2 = new Zombie(100, "Второй зомби");
        Vampire vampire = new Vampire(100, "Первый вампир");

        //создание героев
        Hero archer = new Archer("Legolas");
        Warrior warrior = new Warrior("Aragorn");
        Mage mage = new Mage("Gandalf");
        //локальный класс с методом вывода иноформации о персонажах
        class RunClass {
             public void stats(){
                System.out.println("------------------------");
                System.out.println(archer.toString());
                System.out.println(warrior.toString());
                System.out.println(mage.toString());
                System.out.println(zombie.toString());
                 System.out.println(zombie2.toString());
                System.out.println(vampire.toString());
                System.out.println("------------------------");
            }
        }
        RunClass run = new RunClass();
        run.stats();

        //первый раунд
        System.out.println("*************************");
        archer.attackEnemy(zombie);
        warrior.doubleAttack(zombie);
        mage.fireball(zombie2);

        zombie.attackEnemy(archer);
        zombie2.attackEnemy(mage);
        vampire.attackEnemy(mage);
        System.out.println("*************************");
        run.stats();

        //второй раунд
        System.out.println("*************************");
        archer.attackEnemy(zombie);
        warrior.doubleAttack(vampire);
        mage.fireball(zombie);

        zombie.attackEnemy(archer);
        zombie2.attackEnemy(mage);
        vampire.attackEnemy(mage);
        System.out.println("*************************");
        run.stats();

        //третий раунд
        System.out.println("*************************");
        archer.attackEnemy(zombie);
        warrior.doubleAttack(zombie);
        mage.fireball(zombie2);

        zombie.attackEnemy(archer);
        zombie2.attackEnemy(warrior);
        vampire.attackEnemy(warrior);
        System.out.println("*************************");
        run.stats();

        //четвертый раунд (у мага закончилась мана на заклинания)
        System.out.println("*************************");
        archer.attackEnemy(zombie);
        warrior.doubleAttack(zombie);
        mage.fireball(zombie2);

        zombie.attackEnemy(archer);
        zombie2.attackEnemy(warrior);
        vampire.attackEnemy(warrior);
        System.out.println("*************************");
        run.stats();

        //пятый раунд - зомби убивает мага, вампир не атакует убитого мага
        System.out.println("*************************");
        archer.attackEnemy(zombie);
        warrior.doubleAttack(zombie);
        mage.attackEnemy(zombie2);

        zombie.attackEnemy(archer);
        zombie2.attackEnemy(mage);
        vampire.attackEnemy(mage);
        System.out.println("*************************");
        run.stats();

        //шестой раунд мертвый маг не наносит атак, лучник не стреляет в убитого зомби
        System.out.println("*************************");
        archer.attackEnemy(zombie);
        warrior.doubleAttack(zombie2);
        mage.attackEnemy(zombie2);

        zombie.attackEnemy(archer);
        zombie2.attackEnemy(warrior);
        vampire.attackEnemy(warrior);
        System.out.println("*************************");
        run.stats();

    }
}
