import java.util.ArrayList;
import java.util.Scanner;

public class ThereforeIAm {

    public static Scanner keyboard = new Scanner(System.in);

//  Array list to hold sentences beginning with "I am "
    public static ArrayList<String> sentenceList = new ArrayList<>();

    public static void main(String[] args) {

        String qualities = "";

//  Call me method for user input of sentences
        getSentences();

        for (String sentence : sentenceList) {

//  Extract qualities from each sentence in sentenceList
            String quality = sentence.substring(5);

//  Add comma after each collected quality
            if (!qualities.isEmpty()) {
                qualities += ", ";
            }
            qualities += quality;
        }

//  Output string with all collected qualities
        System.out.println("The qualities are " + qualities);

    }

// Method to get sentences from user input and put sentences beginning with "I am " in array list
    private static void getSentences() {

        String sentence;

        System.out.println("Please enter sentences, . to end.");

        while (true) {
            sentence = keyboard.nextLine();

            if (sentence.equals(".")) {
                break;
            }

            if (sentence.startsWith("I am ")) {
                sentenceList.add(sentence);
            }
        }
    } 
} // End of class
