import java.security.SecureRandom;
import java.util.Scanner;

public class TextBasedAdventure {
    SecureRandom ran= new SecureRandom();
    boolean hasSword = false;
    boolean hasWon = false;
    int playerHealth = 15;
    int giantHealth = 20;
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
            System.out.println("Battle COMMENCE !");
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
            System.out.println("Your health: " + playerHealth + "\nGiant's health: " + giantHealth + "\nWhat will you do?\n1. ATTACK\n2. ITEM\n3. MAGIC\n4. FLEE");
            int input = keyboardInput.nextInt();
            switch (input) {
                case 1:
                    int damage = (int) ((Math.random() * 20) + 1);
                    if (damage == 20) {
                        System.out.println("You score a critical hit!!");
                        giantHealth = giantHealth - 10;
                    }
                    else if (damage > 15) {
                        System.out.println("You swing your sword at the giant with unmatched ferocity!");
                        giantHealth = giantHealth - 6;
                    }
                    else if (damage > 10) {
                        System.out.println("You swing your sword at the giant!");
                        giantHealth = giantHealth - 4;
                    }
                    else if (damage > 5) {
                        System.out.println("You attempt to swing your sword at the giant!");
                        giantHealth = giantHealth - 2;
                    }
                    else System.out.println("You try to swing at the giant, but it evades smoothly!");
                    if (giantHealth < 1) hasWon = true;
                    break;

                case 2: //for item usage during combat
                    System.out.println("You have no items!");
                    break;
                case 3: //for magic usage during combat
                    System.out.println("You don't have magic!");
                    break;
                case 4: //for fleeing
                    System.out.println("Determining optimal escape route...");
                    int escape = (int) (Math.random() * 2);
                    if (escape == 1) {
                        System.out.println("\nYou managed to escape!");
                        start();
                    }
                    else System.out.println("You couldn't get away!");
                    break;   
            }
            if (hasWon) System.out.println("Victory! You defeat the giant with your sword and run out of the cave! You gain 0 XP and -1 GOLD.");
            else {
                System.out.println("The giant charges you!");
                int damage = (int) ((Math.random() * 20) + 1);
                    if (damage == 20) {
                        System.out.println("The giant scores a critical hit!!");
                        playerHealth = playerHealth - 5;
                    }
                    else if (damage > 10) {
                        System.out.println("The giant's attack connects!");
                        playerHealth = playerHealth - 3;
                    }
                    else if (damage > 5) {
                        System.out.println("You manage to guard against the impact!");
                        playerHealth = playerHealth - 1;
                    }
                    else System.out.println("You manage to evade the attack!");
                    if (playerHealth < 1) System.out.println("You get stomped by the giant and red stuff goes everywhere.\nGAME OVER");
                    else fight();
            }
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