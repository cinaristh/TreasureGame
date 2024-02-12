//First version from VB

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;


public class Main {
    // Global variables
    static String position;
    static String userInput;
    static boolean hasSword;
    static boolean hasKey;
    static boolean hasFireJacket;
    static boolean giantStabbed;
    static boolean hasPhone;
    static boolean hasDied;
    static boolean hasWon;
    static int itemCount;

    public static void main(String[] args) {
        initialise();

        do {
            displayPosition();
            checkIfDead(args);
            checkIfWon(args);
            allowMove();
        } while (true);
    }

    static void initialise() {
        // Set start position
        position = "start";

        // Initialise variables
        hasSword = false;
        hasKey = false;
        hasFireJacket = false;
        giantStabbed = false;
        hasPhone = false;
        hasDied = false;
        hasWon = false;

        itemCount = 0;

        // Show welcome message
        System.out.println("\nWELCOME TO TREASURE TROVE...");
        System.out.println();
        System.out.println("You can move by typing a compass direction. (eg N  S  E  or  W)");
        System.out.println("You can pick up and hold as many as three items at once.");
        System.out.println();
        System.out.println("Good luck.");
        System.out.println();
        System.out.println("Enter B to BEGIN...");
        System.out.println();

        // Allow user to begin
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("b")) {
            return;
        } else {
            System.out.println();
            System.out.println("\u0007"); // Beep sound
            initialise();
        }
    }

    static void displayPosition() {
        clearConsole();
        switch (position) {
            case "start":
                System.out.println("You find yourself in a leafy clearing in a wood.");
                System.out.println();
                if (!hasFireJacket) {
                    System.out.println("There is an uncool Fireproof Jacket lying on the ground.");
                    System.out.println();
                    System.out.println("To pick up the jacket type in PUT ON JACKET or press ENTER to continue");
                    System.out.println();
                    userInput = new Scanner(System.in).nextLine();
                    if (userInput.equalsIgnoreCase("put on jacket")) {
                        hasFireJacket = true;
                        itemCount++;
                        System.out.println();
                        System.out.println("You are wearing a very untrendy Fireproof Jacket.");
                    }
                }
                break;

            case "dragon's lair":
                System.out.println("You find yourself in a DRAGON'S LAIR.");
                System.out.println();
                if (!hasFireJacket) {
                    System.out.println("The very big and scary dragon breathes out fire.");
                    System.out.println();
                    System.out.println("You burn up very quickly.");
                    System.out.println("There is a smell of burnt human.");
                    System.out.println();
                    System.out.println();
                    System.out.println("You should have been wearing a very untrendy Fireproof Jacket.");
                    hasDied = true;
                } else {
                    if (!hasPhone) {
                        System.out.println("There is a mobile phone lying on the ground.");
                        System.out.println();
                        System.out.println("To pick up the phone type in PICK UP PHONE or press ENTER to continue");
                        System.out.println();
                        userInput = new Scanner(System.in).nextLine();
                        if (userInput.equalsIgnoreCase("pick up phone")) {
                            hasPhone = true;
                            itemCount++;
                            System.out.println();
                            System.out.println("You are carrying a mobile phone.");
                        }
                    }
                }
                break;

            case "giant's castle":
                System.out.println("You find yourself in a GIANT'S CASTLE.");
                System.out.println();
                if (giantStabbed) {
                    System.out.println("There is an angry giant here.");
                    System.out.println("He is hopping mad and has a sword stuck in his knee.");
                    System.out.println();
                }
                if (!hasSword) {
                    System.out.println("The very big and scary giant squashes you.");
                    System.out.println();
                    System.out.println("You don't like this much.");
                    System.out.println("There is a squashed human here.");
                    System.out.println();
                    System.out.println();
                    System.out.println("You should have tried to fight the giant.");
                    hasDied = true;
                } else if (!giantStabbed) {
                    System.out.println();
                    System.out.println("The giant arrives.");
                    System.out.println();
                    System.out.println("You use your sword to stab him in the knee.");
                    System.out.println();
                    System.out.println("He is now hopping mad.");
                    System.out.println("But in too much pain to hurt you.");
                    System.out.println();
                    giantStabbed = true;
                }
                if (!hasKey && hasSword) {
                    System.out.println();
                    System.out.println("There is a small key lying on the ground.");
                    System.out.println();
                    System.out.println("To pick up the key type in PICK UP KEY or press ENTER to continue");
                    System.out.println();
                    userInput = new Scanner(System.in).nextLine();
                    if (userInput.equalsIgnoreCase("pick up key")) {
                        hasKey = true;
                        itemCount++;
                        System.out.println();
                        System.out.println("You are carrying a small key.");
                    }
                }
                break;

            case "narrow chamber":
                System.out.println("You find yourself in a NARROW CHAMBER.");
                System.out.println();
                System.out.println("There isn't much space to move about.");
                System.out.println();
                if (!hasSword) {
                    System.out.println("There is a rusty sword lying on the ground in a puddle.");
                    System.out.println();
                    System.out.println();
                    System.out.println("To pick up the sword type in PICK UP SWORD or press ENTER to continue");
                    System.out.println();
                    userInput = new Scanner(System.in).nextLine();
                    if (userInput.equalsIgnoreCase("pick up sword")&(itemCount<4)) {
                        hasSword = true;
                        itemCount++;
                        System.out.println();
                        System.out.println("You are carrying a small rusty sword.");
                    }
                    else{
                        System.out.println("You are carrying too many items, you must drop one of the item in order to pick up the sword. Press D to drop an item");
                        userInput = new Scanner(System.in).nextLine();
                        if (userInput.equalsIgnoreCase("d")){
                            userInput = new Scanner(System.in).nextLine();
                            System.out.println("");

                            if (userInput.equalsIgnoreCase("d")){


                            }
                        }

                    }
                }
                break;

            case "treasure cave":
                System.out.println("You find yourself in a dark CAVE.");
                System.out.println();
                System.out.println("There is a treasure chest at the end of the cave.");
                System.out.println("It has a padlock on it with a small key hole.");
                System.out.println();
                System.out.println();
                if (hasKey) {
                    System.out.println();
                    System.out.println("You could use your key to try and open the box.");
                    System.out.println("Type in USE KEY.");
                    System.out.println();
                    userInput = new Scanner(System.in).nextLine();
                    if (userInput.equalsIgnoreCase("use key")) {
                        hasWon = true;
                        System.out.println();
                        System.out.println("The key turns in the lock...");
                    }
                }
                break;
        }
    }

    static void allowMove() {
        switch (position) {
            case "start":
                System.out.println();
                System.out.println("There is a path to the SOUTH and another to the EAST.");
                System.out.println();
                System.out.println("Type S to go SOUTH or E to go EAST.");
                System.out.println();
                userInput = new Scanner(System.in).nextLine();
                if (userInput.equalsIgnoreCase("s")) {
                    position = "giant's castle";
                } else if (userInput.equalsIgnoreCase("e")) {
                    position = "dragon's lair";
                }
                break;

            case "dragon's lair":
                System.out.println();
                System.out.println("There is one path to the SOUTH, one path to the SOUTH EAST");
                System.out.println(" and another to the WEST.");
                System.out.println();
                System.out.println("Type in S, W or SE.");
                System.out.println();
                userInput = new Scanner(System.in).nextLine();
                if (userInput.equalsIgnoreCase("s")) {
                    position = "narrow chamber";
                } else if (userInput.equalsIgnoreCase("w")) {
                    position = "start";
                } else if (userInput.equalsIgnoreCase("se")) {
                    position = "treasure cave";
                }
                break;

            case "giant's castle":
                System.out.println();
                System.out.println("There is a path to the NORTH and another to the EAST.");
                System.out.println();
                System.out.println("Type in N or E.");
                System.out.println();
                userInput = new Scanner(System.in).nextLine();
                if (userInput.equalsIgnoreCase("n")) {
                    position = "start";
                } else if (userInput.equalsIgnoreCase("e")) {
                    position = "narrow chamber";
                }
                break;

            case "narrow chamber":
                System.out.println();
                System.out.println("There are paths to the NORTH, WEST and another to the EAST.");
                System.out.println();
                System.out.println("Type in N, W or E.");
                System.out.println();
                userInput = new Scanner(System.in).nextLine();
                if (userInput.equalsIgnoreCase("w")) {
                    position = "giant's castle";
                } else if (userInput.equalsIgnoreCase("e")) {
                    position = "treasure cave";
                } else if (userInput.equalsIgnoreCase("n")) {
                    position = "dragon's lair";
                }
                break;

            case "treasure cave":
                System.out.println();
                System.out.println("There is a path to the NORTHWEST and another to the WEST.");
                System.out.println();
                System.out.println("Type in NW or W.");
                System.out.println();
                userInput = new Scanner(System.in).nextLine();
                if (userInput.equalsIgnoreCase("w")) {
                    position = "narrow chamber";
                } else if (userInput.equalsIgnoreCase("nw")) {
                    position = "dragon's lair";
                }
                break;
        }
    }

    static void checkIfDead(String[] a) {
        if (hasDied) {
            System.out.println();
            System.out.println("You are dead.");
            System.out.println();
            System.out.println("Enter R to RESTART...");
            System.out.println("Oh. I forgot. You can't because you're dead.");
            System.out.println();

            //restart
            userInput = new Scanner(System.in).nextLine();
            if (userInput.equalsIgnoreCase("r")) {

                main(a);
            } else {
                // beep and give them another chance to restart
                System.out.println("\u0007");
                System.out.println();
                checkIfDead(a);
            }
        }
    }

    static void checkIfWon(String[] a) {
        if (hasWon) {
            System.out.println();
            System.out.println("The treasure box opens with a creek.");
            System.out.println("Inside are one thousand heavy bars of solid gold.");
            System.out.println();
            System.out.println("Congratulations!");
            System.out.println("You have won!");
            System.out.println();
            System.out.println("You marry the princess (what princess?) and live happily ever after...");
            System.out.println();
            System.out.println("Enter R to RESTART...");
            System.out.println();

            //restart
            userInput = new Scanner(System.in).nextLine();
            if (userInput.equalsIgnoreCase("r")) {
                main(a);
            } else {
                System.out.println("\u0007");
                System.out.println();
                checkIfWon(a);
            }
        }
    }

    static void clearConsole() {
        // Clear console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}