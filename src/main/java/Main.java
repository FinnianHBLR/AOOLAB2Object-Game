import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Program");

        System.out.println("Enter Your Paladrome");
        System.out.println(isPaladrome("EEE"));
    }


    public static String isPaladrome(String toCheck){

     List<Character> spltWord =  new ArrayList<>();

     spltWord.addAll(toCheck.);

     List<Character> addToTemp = new ArrayList<>();


     //BE careful binch. This selects the last location in the array with -1
        for(int i = spltWord.length -1; i >= 0; i--) {
            System.out.println(spltWord[i]);

            addToTemp.add(spltWord[i]);

        }

        if(Arrays.equals(addToTemp.toArray(), spltWord)) {
            return spltWord.toString() + " is a paladrome";
        } else {
            return spltWord.toString() + " is not a paladrome";
        }

    }

}
