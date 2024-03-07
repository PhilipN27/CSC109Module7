import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    Scanner keyboardInput = new Scanner(System.in);

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right \n3. Talk to the mysterious figure");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        } else if (input == 2) {
            goRight();
        } else if (input == 3) {
            interactWithCharacter();
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
        }
    }

    public void interactWithCharacter() {
        System.out.println("A mysterious figure appears before you. 'Answer my riddle and I shall grant you a clue to escape this cave,' it says.");
        System.out.println("'I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?'");
        String answer = keyboardInput.next();
        if ("echo".equalsIgnoreCase(answer)) {
            System.out.println("The figure nods approvingly. 'You are wise. Look for the lever hidden behind the stone in the next room.'");
        } else {
            System.out.println("The figure shakes its head. 'That is incorrect. You may try again later.'");
        }
        start();
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}