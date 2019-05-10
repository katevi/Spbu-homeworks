package Vinnik.g144.com;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.LinkedList;

public class Controller {

    @FXML
    private TextArea output;

    /** Converts given two-dimension strings-array to list of lists and creates new SortedSet from it.
     *
     * @param array - given two-dimension array of strings.
     * @return - new SortedSet.
     */
    public SortedSet convertInput(String[][] array) {
        LinkedList<LinkedList<String>> lists = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            LinkedList<String> currentList = new LinkedList();
            for (int j = 0; j < array[i].length; j++) {
                String[] words = array[i][j].split(" ");
                for (int k = 0; k < words.length; k++) {
                    currentList.add(words[k]);
                }
            }
            lists.add(currentList);
        }
        SortedSet set = new SortedSet();
        for (int i = 0; i < lists.size(); i++) {
            set.add(lists.get(i));
        }
        return set;
    }

    /** Starts application, outputs set. */
    public void initialize() {
        // I am sorry a lot, but it is hard code:(
        String[][] arrays = {{}, {"abckjh vcmvnc mmnmnv"}, {"fdkjlkj dflkjgldfjg"}, {"mvmvmvmv"}, {"kf kf kf kf"}};
        SortedSet<String> set = convertInput(arrays);
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < set.getStrings().size(); i++) {
            string.append(set.getStrings().get(i).toString());
            string.append("\n");
        }
        output.setText(string.toString());
    }
}
