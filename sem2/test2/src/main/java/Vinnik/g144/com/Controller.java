package Vinnik.g144.com;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.Scanner;

public class Controller {

    private int lengthArrayStrings = 0;

    @FXML
    private TextField output;

    public String[][] input() {
        /*System.out.println("Enter number of arrays");
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        for (int i = 0; i < length; i++) {

        }*/
        lengthArrayStrings = 3;
        String[][] array = {{"abc abc"}, {"bfg"}, {"dflk lkj"}};
        return array;
    }


    private SortedSet convertInput(String[][] array, int length) {
        LinkedList<LinkedList<String>> lists = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String[] words = array[i][j].split(" ");
                LinkedList currentList = new LinkedList();
                currentList.add(words);
                lists.add(currentList);
            }
        }
        SortedSet set = new SortedSet();
        set.add(lists);
        return set;
    }

    public void initialize() {
        String[][] arrays = input();
        SortedSet<String> set = convertInput(arrays, lengthArrayStrings);
        output.setText(set.strings.toString());
    }
}
