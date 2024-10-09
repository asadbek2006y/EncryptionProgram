import java.util.*;

public class EncryptionProgram {

    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;
    private char[] secretletters;

    EncryptionProgram() {

        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList();
        shuffledList = new ArrayList();
        character = ' ';

        newKey();
        askQuestion();
    }

    private void askQuestion() {

        while (true) {
            System.out.println("**************************{ JAVA CODING }**************************");
            System.out.println("What do you want to do");
            System.out.println("(N)ew Key, (G)et Key, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (response) {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                case 'D':
                    decrypt();
                case 'Q':
                    quit();
                default:
                    System.err.println("Not a valid aswer: (N)");
                    ;
            }
        }
    }

    private void newKey() {

        character = ' ';
        list.clear();
        shuffledList.clear();

        for (int i = 32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }

        shuffledList = new ArrayList(list);
        Collections.shuffle(shuffledList);
        System.out.println("New key has been generated* ");
    }

    private void getKey() {

        System.out.println("Key: ");
        for (Character x : list) {
            System.out.println("x");

        }
        System.out.println();
        for (Character x : shuffledList) {
            System.out.println(x);
        }
        System.out.println();
    }

    private void encrypt() {
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == list.get(j)) {
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted: ");

        for (char x : letters) {
            System.out.println(x);
        }
        System.out.println();
    }

    private void decrypt() {
        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < shuffledList.size(); j++) {
                if (letters[i] == shuffledList.get(j)) {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted: ");

        for (char x : letters) {
            System.out.println(x);
        }
        System.out.println();
    }

    private void quit() {
        System.out.println("Thank you, have a nice day bro!");
        System.exit(0);
    }

}