package data_structures_algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NongDat
 */
public class Data_Structures_Algorithms {

    /**
     * @param args the command line arguments
     */
    private void run() {
        while (true) {
            String inputString = inputMethod();
            getTextList(inputString);
            outputMethod(getTextList(inputString));
            System.out.println("\nDo you want to continue (Y/N)?");
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        }
    }
    
//  Enter string
    private String inputMethod() {
        Scanner sc = new Scanner(System.in);
        String inputString = null;
        System.out.println("\nPlease enter a string");
//        If the user enters the wrong format, it must be re-entered
        do {
            inputString = sc.nextLine();
        } while (valid(inputString));
        return inputString;
    }

    private boolean valid(String text) {
        if (text.length() == 0 || text.trim().isEmpty()) {
            System.out.println("\nString canot be empty");
            return true;
        }
//      String can only contain a alphanumeric character
        String regex = "[a-zA-Z0-9\\s]+";
        if (!text.matches(regex)) {
            System.out.println("\n String cannot contain special characters or Vietnamese"
                    + "\nString can only contain a alphanumeric character!");
            return true;
        }
        return false;
    }
    
//  Convert the entered string into a list of words
    private List<String> getTextList(String text) {
        List<String> txtList = new ArrayList<>();
        int start = 0;
        int index = 0;
        String itemString = null;
        do {
            text.trim();
            index = text.indexOf(" ", index);
//            If the string does not contain spaces in between
            if (index == -1) {
                itemString = text.substring(start, text.length());
            } else {
                itemString = text.substring(start, index);
            }

            start = index;
            index++;
//            Handling multiple contiguous spaces
            if (!itemString.isEmpty()) {
                txtList.add(itemString);
            }
        } while (index != 0);
        return txtList;
    }

//    results received
    private void outputMethod(List<String> textList) {
        String maxString = textList.get(0);
        for (int i = 0; i < textList.size(); i++) {
            if (maxString.length() < textList.get(i).length()) {
                maxString = textList.get(i);
            }
        }
        System.out.println("\nThe longest word is: " + maxString);
    }
//       run

    public static void main(String[] args) {
        Data_Structures_Algorithms pb1 = new Data_Structures_Algorithms();
        pb1.run();
    }

}
