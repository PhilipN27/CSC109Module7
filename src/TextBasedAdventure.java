
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    List<String> inventory = new ArrayList<>();
    int health = 100;
    Scanner keyboardInput = new Scanner(System.in);

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        } else if (input == 2) {
            goRight();
        }
    }

    public void goLeft() {
        System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        } else if (input == 2) {
            start();
        }
    }

    public void goRight() {
        if (!hasSword) {
            System.out.println("You find a sword on the ground!");
            hasSword = true;
            pickUpItem("sword");
        } else {
            System.out.println("There's nothing here...");
        }
        start();
    }

    public void fight() {
        if (hasSword) {
            System.out.println("You defeat the giant with your sword and run out of the cave!");
        } else {
            System.out.println("You get stomped by the giant and red stuff goes everywhere.");
            health -= 50;
            if (health <= 0) {
                System.out.println("You have died.");
                // End game or restart
            } else {
                System.out.println("You have " + health + " health left.");
                // Allow player to use a health potion if available
                if (useItem("health potion")) {
                    health += 30;
                    System.out.println("You have " + health + " health now.");
                }
                start();
            }
        }
    }

    public void pickUpItem(String item) {
        System.out.println("You found a " + item + "!");
        inventory.add(item);
        System.out.println("Inventory: " + inventory);
    }

    public boolean useItem(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            System.out.println(item + " used.");
            return true;
        } else {
            System.out.println("You don't have a " + item + ".");
            return false;
        }
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}
