import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) {

        System.out.println("ADMINISTRATOR SETUP");
        System.out.println("===================");

        String itemName;
        int maxNumberOfItems;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Name of items in the jar: ");
            itemName = br.readLine().replaceAll("\\s", "");
            System.out.printf("Maximum number of %s in the jar: ", itemName);
            maxNumberOfItems = Integer.parseInt(br.readLine().replaceAll("\\s", ""));



            System.out.println("PLAYER");
            System.out.println("===================");
            System.out.printf("Your goal is to guess how many %s are in the jar. ", itemName);
            System.out.printf("Your guess should be between 1 and %s.%n", maxNumberOfItems);
            System.out.println();
            System.out.println("Ready? Press ENTER to start guessing!");

            String enter = " ";
            do {
                enter = br.readLine();
                System.out.println(enter);
            } while (enter != null && !enter.equals(""));
            Jar jar = new Jar(itemName, maxNumberOfItems);

            int counter = 0;
            int guess = -1;
            while (guess != jar.getNumberOfItems()) {
                System.out.print("Guess: ");
                String input = br.readLine();
                if (input != null) {
                    guess = Integer.parseInt(input.replaceAll("\\s", ""));
//                guess = Integer.parseInt(br.readLine().replaceAll("\\s", ""));
                    System.out.println("yolo: " + Integer.toString(guess));
                    counter++;
                } else {
                    System.out.println("Input was null.");
                }
            }
            System.out.printf("Congratulations, %s is the correct answer.%n", guess);
            System.out.printf("There are %s %s in the jar.%n", guess, jar.getItemName());
            System.out.printf("It took you %s guesses.%n", counter);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }
}
