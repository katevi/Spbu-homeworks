package Vinnik.g144;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/** Implements intercative example of work with hash table. */
public class Main {
    /** Implementation communication with the user. */
    public static void main(String args[]) throws Exception {

        System.out.println("Enter 1 if you want to choose hash function with polynom, " +
                "2 if you want to choose hash function with sum");
        Scanner input = new Scanner(System.in);
        String inputHashFunction = input.next();
        while (!inputHashFunction.equals("1") && !inputHashFunction.equals("2")) {
            System.out.println("Enter correct number");
            inputHashFunction = input.next();
        }
        HashTable table;
        HashFunction hashFunction;
        if (inputHashFunction.equals("1")) {
            hashFunction = new HashFunctionPolynom();
            System.out.println("You have chosen hash function with polynom");
        } else {
            hashFunction = new HashFunctionSum();
            System.out.println("You have chosen hash function with sum");
        }
        table = new ListHashTable(hashFunction);
        menu();
        String option = input.next();
        while (!option.equals("0")) {
            switch (option) {
                case "1": {
                    System.out.println("Enter value of element you want to add");
                    String string = input.next();
                    table.addElement(string);
                    break;
                }
                case "2": {
                    System.out.println("Enter value of element you want to remove");
                    String string = input.next();
                    table.removeElement(string);
                    break;
                }
                case "3": {
                    System.out.println("Enter value of element, which existance should be checked");
                    String string = input.next();
                    System.out.println(table.exists(string));
                    break;
                }
                case "4": {
                    table.printStatistics();
                    break;
                }
                case "5": {
                    loadFile(table);
                    System.out.println("Loaded");
                    break;
                }
                default:
                    System.out.println("Enter correct number");
            }
            option = input.next();
        }
        input.close();
    }

    private static void loadFile(HashTable table) throws FileNotFoundException {
        File file = new File("src/main/java/Vinnik/g144/input.txt");
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            table.addElement(in.next());
        }
        in.close();
    }

    private static void menu() {
        System.out.println("Press 0 if you want to exit");
        System.out.println("Press 1 if you want to add element");
        System.out.println("Press 2 if you want to remove element");
        System.out.println("Press 3 if you want to check existance of element");
        System.out.println("Press 4 if you want to print statistics");
        System.out.println("Press 5 if you want to load information from file");
    }
}

