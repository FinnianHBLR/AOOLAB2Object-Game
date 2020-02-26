import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //By Finnian Logan-Riley
        //I know there are no functions used. Just did everything in main because this program isn't too complex.

        //Lists containing properties for Hashmaps
        List<String> colours = new ArrayList<>();
        List<String> objects = new ArrayList<>();

        //Selects colour 4 and object 4 from coloour and object array
        Map<Integer, Integer> eachItem = new HashMap<>();
        //Hashmap for Mouse
        eachItem.put(4, 4);
        //Hashmap for chair
        eachItem.put(2, 0);
        //Hashmap for ghost
        eachItem.put(1, 1);
        //Hashmap for book
        eachItem.put(3, 3);
        //Hashmap for bottle
        eachItem.put(0, 2);

        //Adding objets to list here. Each one will correspond with the Has maps above. Eg, 4, 4 is the last location on both colours and objects or "Grey Mouse"
        colours.add("green");
        colours.add("white");
        colours.add("red");
        colours.add("blue");
        colours.add("grey");

        objects.add("chair");
        objects.add("ghost");
        objects.add("bottle");
        objects.add("book");
        objects.add("mouse");

        //Uses an IntStream to create 4 numbers. This works by specifying a random number between 0-5
        //and using the distinct to create unique and limit to limit the amount.

        //https://stackoverflow.com/questions/8115722/generating-unique-random-numbers-in-java
        IntStream tempRandomNumber = (ThreadLocalRandom.current().ints(0, 5).distinct().limit(4));
        System.out.println(tempRandomNumber.toString());

        //Converts the IntSteam to an Array so the location can be accessed by randFirst etc.
        int[] arrayOfUniqueNumbers = tempRandomNumber.toArray();

        // System.out.println(Arrays.toString(arrayOfUniqueNumbers)); DEBUG
        //Creates 4 unique numbers betwwen 0-4

        //Selects the numbers from the unique numbers generated in arrayOfUniqueNumbers
        //Random rand = new Random();

        int randFirstColour = arrayOfUniqueNumbers[0];
        int randFirstObject = arrayOfUniqueNumbers[1];
        int randSecondColour = arrayOfUniqueNumbers[2];
        int randSecondObject = arrayOfUniqueNumbers[3];

        //This prints out the first random card before they are checked.
        System.out.println("This is a " + colours.get(randFirstColour)  + " " + objects.get(randFirstObject));

        //This prints out the second random card before they are checked.
        System.out.println("This is a " + colours.get(randSecondColour) + " " + objects.get(randSecondObject));

        //Previous code commented. This had an issue with checking each card. There was a nested for statement and I tried to break to loops
        //but it got too difficult so decided to change the if statement. The if statement now searchers for what it needs instead of comparing each card.
        // for(Map.Entry<Integer, Integer> selectedMap : eachItem.entrySet() ) {
        //Cycle through all valid items to check if cards match

           // eachItem.forEach((integer, integer2) -> System.out.println(integer + " " + integer2)); DEBUG for old for loop.

            //Searches for the key using the first colors then gets the object checks if it is equal to the first card.
            if(eachItem.containsKey(randFirstColour) && eachItem.get(randFirstColour) == randFirstObject) {
                System.out.println("The First Object, I found this is a " + colours.get(randFirstColour) + " " + objects.get(randFirstObject));
            //If first object and color on card equals the random card

                //Same as if statement above but for second random card
            } else if(eachItem.containsKey(randSecondColour) && eachItem.get(randSecondColour) == randSecondObject) {
                System.out.println("The Second object, I found this is a " + colours.get(randSecondColour) + " " + objects.get(randSecondObject));

                //If second object and color on card equals the random card
                //Remove
            } else {
                //If a card does not match this will search all cards to see if there is an object that does not contain any of the properties of the random card
                for (Map.Entry<Integer, Integer> notValidSelect : eachItem.entrySet()) {
                    if (notValidSelect.getKey() != randFirstColour
                            && notValidSelect.getValue() != randFirstObject

                            && notValidSelect.getKey() != randSecondColour
                            && notValidSelect.getValue() != randSecondObject) {
                        System.out.println("---Card Found With No Common Traits of Played Card---");

                        System.out.println(colours.get(notValidSelect.getKey()) + " " + objects.get(notValidSelect.getValue()));
                        //Break loop as the loop needs to be stopped because a match has been found.
                        break;
                    } else {
                        //System.out.println("No Card Picked Up!");
                    }
                }
            }
    }
}
