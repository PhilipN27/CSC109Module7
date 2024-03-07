import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    boolean hasStaff = false;
    boolean visitStaff = false;
    Scanner keyboardInput = new Scanner(System.in);

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right \n3. Go Straight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        }
        else if (input == 2) {
            goRight();
        } else if (input == 3) {
            goStraight();
        }
    }

    public void goLeft() {
        System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            start();
        }  
    }

    public void goRight() {
        if (!hasSword) {
            System.out.println("You find a sword on the ground!");
            hasSword = true;
        }
        else {
            System.out.println("There's nothing here...");
        }
        start();
    }

    public void goStraight() {
        if(!hasStaff) {
            System.out.println("You see a glowing staff sticking out of the floor in the middle of the room.\nWhen you pick it up, the staff vibrates and then glows brighter.");
            hasStaff = true;
        } else if (hasStaff && !visitStaff) {
            System.out.println("There is more to this room then there seems. In the corner is a message carved into the wall. It says\n\"Go right if you would like a sword, good luck\"");
            visitStaff = true;
        } else {
            System.out.println("The room is dark. There is nothing else in here");
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

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}