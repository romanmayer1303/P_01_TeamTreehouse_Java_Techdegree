import java.util.Random;

/**
 * Created by romanmayer on 20/02/17.
 */
public class Jar {

    private String ITEM_NAME;
    private int MAX_NUMBER_OF_ITEMS;
    private int NUMBER_OF_ITEMS;

    public Jar(String itemName, int maxNumberOfItems) {
        this.ITEM_NAME = itemName;
        this.MAX_NUMBER_OF_ITEMS = maxNumberOfItems;
        this.NUMBER_OF_ITEMS = getRandomNumber(maxNumberOfItems);
    }

    public String getItemName() {
        return ITEM_NAME;
    }

    public int getMaxNumberOfItems() {
        return MAX_NUMBER_OF_ITEMS;
    }

    public int getNumberOfItems() {
        return NUMBER_OF_ITEMS;
    }

    private int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max) + 1;
    }
}
