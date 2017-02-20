import java.io.IOException;

public class Game {
    public static void main(String[] args) {

        Prompter prompter = new Prompter();

        String itemName = prompter.askForItemName();
        int maxNumberOfItems = prompter.askForMaxNumberOfItems(itemName);
        String name = prompter.askForUsername();

        Jar jar = new Jar(itemName, maxNumberOfItems);

        prompter.promptToStartTheGame(itemName, maxNumberOfItems);

        int counter = 0;
        int guess = -1;
        while (guess != jar.getNumberOfItems()) {
            guess = prompter.promptForGuess();
            if (guess > 0 && guess <= maxNumberOfItems) {
                counter++;
                if (guess < jar.getNumberOfItems()) {
                    prompter.guessIsTooLow();
                } else if (guess > jar.getNumberOfItems()) {
                    prompter.guessIsTooHigh();
                }
            } else {
                prompter.outOfRange(maxNumberOfItems);
            }
        }

        prompter.printResult(counter);

    }
}
